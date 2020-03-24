package com.briup.buke.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.ArticleAndCategoryName;
import com.briup.buke.bean.Category;
import com.briup.buke.bean.CategoryPack;
import com.briup.buke.service.ICategoryService;
import com.briup.buke.utils.Message;
import com.briup.buke.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@Api(description="栏目相关接口")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/findAll")
	@ApiOperation("查询所有栏目")
	public Message<List<CategoryPack>> findAll(){
		List<Category> categoryList = categoryService.findAll();
		List<CategoryPack> categoryPackList = new ArrayList<CategoryPack>();
		for(Category c:categoryList) {
			CategoryPack categoryPack=new CategoryPack(c.getId(), c.getCode(), c.getName());
			categoryPackList.add(categoryPack);
		}
		return MessageUtil.success(categoryPackList);
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除栏目")
	@ApiImplicitParam(name="id",value="栏目id",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(int id){
		Message<String> message = null;
		try {
			categoryService.deleteById(id);
			message = MessageUtil.success("删除成功！");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@PutMapping("/saveOrUpdate")
	@ApiOperation("保存或更新一个栏目")
	
	public Message<String> saveOrUpdate(CategoryPack categoryPack){
		Message<String> message = null;
		Category category = new Category();
		category.setId(categoryPack.getId());
		category.setCode(categoryPack.getCode());
		category.setName(categoryPack.getName());
		try {
			categoryService.saveOrUpdate(category);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findById")
	@ApiOperation("根据id查询栏目")
	@ApiImplicitParam(name="id",paramType="query",dataType="int",required=true)
	public Message<CategoryPack> findById(int id){
		Message<CategoryPack> message = null;
		try {
			Category category = categoryService.findById(id);
			System.out.println(category);
			CategoryPack cp=new CategoryPack();
			cp.setId(category.getId());
			cp.setName(category.getName());
			cp.setCode(category.getCode());
			message = MessageUtil.success(cp);
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		
		return message;
	}
	@GetMapping("/findByCategoryId")
	@ApiOperation("查找该栏目的所有文章")
	@ApiImplicitParam(name="categoryId",paramType="query",dataType="Integer",required=true)
	public Message<List<ArticleAndCategoryName>> findByCategoryId(Integer categoryId){
		List<Article> list = categoryService.findByCategory(categoryId);
		System.out.println(list);
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate(), 
					article.getTitle(),article.getState(),article.getWords(),article.getImage(), categoryService.findNameById(article.getCategory_id()));
			aclist.add(ac);
		}
		return MessageUtil.success(aclist);
	}
}
