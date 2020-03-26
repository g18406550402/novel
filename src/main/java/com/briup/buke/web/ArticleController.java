package com.briup.buke.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.ArticleAndCategoryName;
import com.briup.buke.bean.Category;
import com.briup.buke.bean.Chapter;
import com.briup.buke.service.IArticleService;
import com.briup.buke.service.ICategoryService;
import com.briup.buke.service.IChapterService;
import com.briup.buke.utils.Message;
import com.briup.buke.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IChapterService chapterService;
	@PostMapping("/article/saveOrUpdate")
	@ApiOperation(value="保存或更新一篇文章")
	public Message<String> saveOrUpdate(ArticleAndCategoryName articleAndCategoryName){
		//封装文章信息
		Article article = new Article();
		Integer id = articleAndCategoryName.getId();
		String title = articleAndCategoryName.getTitle();
		String author = articleAndCategoryName.getAuthor();
		String intro = articleAndCategoryName.getIntro();
		Integer words = articleAndCategoryName.getWords();
		String state = articleAndCategoryName.getState();
		String image = articleAndCategoryName.getImage();
		article.setId(id);
		article.setTitle(title);
		article.setAuthor(author);
		article.setIntro(intro);
		article.setWords(words);
		article.setState(state);
		article.setImage(image);
		article.setUpdateDate(new Date());
		Integer categoryId=null;
		try {
			//根据输入的栏目名查找栏目id
			String categoryName = articleAndCategoryName.getCategoryName();
			categoryId = categoryService.findIdByName(categoryName);
		} catch (Exception e1) {
			return MessageUtil.error(500, e1.getMessage());
		}
		
			article.setCategory_id(categoryId);
		try {
			articleService.saveOrUpdate(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
		return MessageUtil.success("更新成功！");
	}
	@RequestMapping("/foreground/toArticle")
	@ApiOperation("根据id查询文章")
	public String findById(int id,HttpServletRequest request){
		String message = null;
		try {
			Article article = articleService.findById(id);
			String name = categoryService.findNameById(article.getCategory_id());
			ArticleAndCategoryName ac = new ArticleAndCategoryName();
			//封装
			ac.setId(article.getId());
			ac.setAuthor(article.getAuthor());
			ac.setClickTimes(article.getClickTimes());
			ac.setIntro(article.getIntro());
			ac.setUpdateDate(article.getUpdateDate().toString().replace(".0", ""));
			ac.setTitle(article.getTitle());
			ac.setState(article.getState());
			ac.setImage(article.getImage());
			//words字段处理
				ac.setWords(article.getWords());
			ac.setCategoryName(name);
			//传递章节信息
			List<Chapter> chapterList = chapterService.findAllChapterById(article.getId());
			request.setAttribute("chapterList", chapterList);
			//传递最新章节信息
			List<Chapter> updateList = chapterService.findUpdateChapter(article.getId());
			request.setAttribute("updateList", updateList);
			//传递栏目id
			request.setAttribute("categoryId", article.getCategory_id());
			//传递文章信息
			request.setAttribute("article", ac);
			request.setAttribute("articleId", ac.getId());
		} catch (Exception e) {
			message= e.getMessage();
			request.setAttribute("errorMessage", message);
		}
		
		return "foreground/article";
	}
	@ApiOperation("查询所有文章")
	@RequestMapping("/article/findAll")
	public Message<List<ArticleAndCategoryName>> findAll(){
		List<Article> list = articleService.findAll();
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			String categoryName=categoryService.findNameById(article.getCategory_id());
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate().toString().replace(".0", ""), 
					article.getTitle(),article.getState(),article.getWords(), article.getImage(),categoryName);
			aclist.add(ac);
		}
		return MessageUtil.success(aclist);
	}
	@DeleteMapping("/article/deleteById")
	@ApiOperation("根据id删除文章")
	@ApiImplicitParam(name="id",value="文章id",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(Integer id){
		Message<String> message = null;
		try {
			articleService.deleteById(id);
			message = MessageUtil.success("delete success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	
	@ApiOperation("根据标题或作者查询文章")
	@RequestMapping(value="/foreground/toSearch",method=RequestMethod.GET)
	public String findByTitleOrArthor(String searchKey,HttpServletRequest request){
		List<Article> articleList = articleService.findByTitleOrArthor(searchKey);
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:articleList) {
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate().toString().replace(".0", ""), 
					article.getTitle(),article.getState(),article.getWords(),article.getImage(), categoryService.findNameById(article.getCategory_id()));
			aclist.add(ac);
		}
		request.setAttribute("articleList", aclist);
		return "foreground/search";
		
	}
	@RequestMapping("/foreground/toCategory")
	@ApiOperation("查找该栏目的所有文章")
	public String findByCategoryId(Integer categoryId,HttpServletRequest request){
		List<Article> list = articleService.findByCategory(categoryId);
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate().toString().replace(".0", ""), 
					article.getTitle(),article.getState(),article.getWords(),article.getImage(), categoryService.findNameById(article.getCategory_id()));
			aclist.add(ac);
		}
		request.setAttribute("articleList", aclist);
		return "foreground/category";
	}
	@RequestMapping("/foreground/toStack")
	@ApiOperation("查找本网站的所有文章并分类")
	public String findAllByCategory(HttpServletRequest request){
		for(int i=1;i<=7;i++) {
			List<Article> list = articleService.findByCategory(i);
			List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
			for(Article article:list) {
				ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
						article.getIntro(), article.getUpdateDate().toString().replace(".0", ""), 
						article.getTitle(),article.getState(),article.getWords(),article.getImage(), categoryService.findNameById(article.getCategory_id()));
				aclist.add(ac);
			}
			String categoryName = categoryService.findNameById(i);
			String categoryNamei= "categoryName"+i;
			String articleListi = "articleList"+i;
			request.setAttribute(categoryNamei, categoryName);
			request.setAttribute(articleListi, aclist);
		}
		return "foreground/stack";
	}
}

