package com.briup.buke.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value="/background/article/saveOrUpdate",method=RequestMethod.POST)
	@ApiOperation(value="保存或更新一篇文章")
	@ResponseBody
	public String saveOrUpdate(ArticleAndCategoryName articleAndCategoryName){
		//封装文章信息
		Article article = new Article();
		Long id = articleAndCategoryName.getId();
		String title = articleAndCategoryName.getTitle();
		String author = articleAndCategoryName.getAuthor();
		String intro = articleAndCategoryName.getIntro();
		Long words = articleAndCategoryName.getWords();
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
		Long categoryId=null;
		try {
			//根据输入的栏目名查找栏目id
			String categoryName = articleAndCategoryName.getCategoryName();
			categoryId = categoryService.findIdByName(categoryName);
		} catch (Exception e1) {
			return e1.getMessage();
		}
		
			article.setCategory_id(categoryId);
		try {
			articleService.saveOrUpdate(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		return "更新成功！";
	}
	
	
	@RequestMapping("/foreground/toArticle")
	@ApiOperation("根据id查询文章")
	public String toArticle(Long id,HttpServletRequest request){
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
			List<Chapter> chapterList = chapterService.findByArticleId(article.getId());
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
	@RequestMapping("/foreground/article/reverseOrderChapter/{articleId}")
	@ResponseBody
	public Message<List<Chapter>> reverseOrder(@PathVariable Long articleId){
		//传递章节信息
		List<Chapter> chapterList = chapterService.findByArticleId(articleId);
		Collections.sort(chapterList,new Comparator<Chapter>() {
			@Override
			public int compare(Chapter o1, Chapter o2) {
				Long diff = o1.getId()-o2.getId();
				if(diff>0)
					return -1;
				else if(diff<0)
					return 1;
				return 0;
			}
		});
		return MessageUtil.success(chapterList);
	}
	@RequestMapping("/foreground/article/positiveSequence/{articleId}")
	@ResponseBody
	public Message<List<Chapter>> positiveSequence(@PathVariable Long articleId){
		//传递章节信息
		List<Chapter> chapterList = chapterService.findByArticleId(articleId);
		Collections.sort(chapterList,new Comparator<Chapter>() {
			@Override
			public int compare(Chapter o1, Chapter o2) {
				Long diff = o1.getId()-o2.getId();
				if(diff>0)
					return 1;
				else if(diff<0)
					return -1;
				return 0;
			}
		});
		return MessageUtil.success(chapterList);
	}
	
	
	@RequestMapping("/background/article/findById/{id}")
	@ApiOperation("根据id查询文章")
	@ResponseBody
	public ArticleAndCategoryName findById(@PathVariable Long id){
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
			
			return ac;
		} catch (Exception e) {
			System.out.println("Error!!!!!!!!");
			e.getMessage();
			return null;
		}
		
	}
	@ApiOperation("查询所有文章")
	@RequestMapping("/background/article/findAll")
	public String findAll(HttpServletRequest request){
		List<Article> list = articleService.findAll();
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			String categoryName=categoryService.findNameById(article.getCategory_id());
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate().toString().replace(".0", ""), 
					article.getTitle(),article.getState(),article.getWords(), article.getImage(),categoryName);
			aclist.add(ac);
		}
		request.setAttribute("articleList", aclist);
		return "background/article";
	}
	@RequestMapping("/background/article/deleteById/{id}")
	@ApiOperation("根据id删除文章")
	@ResponseBody
	public String deleteById(@PathVariable Long id){
		String message = null;
		try {
			articleService.deleteById(id);
			message = "删除成功";
		} catch (Exception e) {
			message = e.getMessage();
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
	public String toCategory(Long categoryId,HttpServletRequest request){
		List<Article> list = articleService.findArticleByCategoryId(categoryId);
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
	
	@RequestMapping(value="/background/article/findByCategoryId/{categoryId}")
	@ApiOperation("查找该栏目的所有文章")
	public String findByCategoryId(@PathVariable Long categoryId,HttpServletRequest request){
		List<Article> list = articleService.findArticleByCategoryId(categoryId);
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate().toString().replace(".0", ""), 
					article.getTitle(),article.getState(),article.getWords(),article.getImage(), categoryService.findNameById(article.getCategory_id()));
			aclist.add(ac);
		}
		request.setAttribute("articleList", aclist);
		return "background/article";
	}
	
	@RequestMapping("/foreground/toStack")
	@ApiOperation("查找本网站的所有文章并分类")
	public String findAllByCategory(HttpServletRequest request){
		for(Long i=1l;i<=7;i++) {
			List<Article> list = articleService.findArticleByCategoryId(i);
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

