package com.briup.buke.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.ArticleAndCategoryName;
import com.briup.buke.bean.Category;
import com.briup.buke.bean.Chapter;
import com.briup.buke.service.IArticleService;
import com.briup.buke.service.ICategoryService;
import com.briup.buke.utils.Message;
import com.briup.buke.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
@Api(description="文章相关接口")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/saveOrUpdate")
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
	@GetMapping("/findById")
	@ApiOperation("根据id查询文章")
	@ApiImplicitParam(name="id",value="文章id",paramType="query",dataType="int",required=true)
	public Message<ArticleAndCategoryName> findById(int id){
		Message<ArticleAndCategoryName> message = null;
		try {
			Article article = articleService.findById(id);
			String name = categoryService.findNameById(article.getCategory_id());
			ArticleAndCategoryName ac = new ArticleAndCategoryName();
			
			ac.setId(article.getId());
			ac.setAuthor(article.getAuthor());
			ac.setClickTimes(article.getClickTimes());
			ac.setIntro(article.getIntro());
			ac.setUpdateDate(article.getUpdateDate());
			ac.setTitle(article.getTitle());
			ac.setState(article.getState());
			ac.setImage(article.getImage());
			//words字段处理
				ac.setWords(article.getWords());
			ac.setCategoryName(name);
			message=MessageUtil.success(ac);
		} catch (Exception e) {
			message=MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@ApiOperation("查询所有文章")
	@GetMapping("/findAll")
	public Message<List<ArticleAndCategoryName>> findAll(){
		List<Article> list = articleService.findAll();
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			String categoryName=categoryService.findNameById(article.getCategory_id());
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate(), 
					article.getTitle(),article.getState(),article.getWords(), article.getImage(),categoryName);
			aclist.add(ac);
		}
		return MessageUtil.success(aclist);
	}
	@DeleteMapping("/deleteById")
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
	@GetMapping("/findByTitleOrAuthor")
	@ApiImplicitParam(name="titleOrAuthor",value="文章的标题或作者",paramType="query",dataType="String",required=true)
	public Message<List<Article>> findByTitleOrArthor(String titleOrAuthor){
		
		List<Article> articleList;
		try {
			articleList = articleService.findByTitleOrArthor(titleOrAuthor);
			return MessageUtil.success(articleList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
		
	}
}
