package com.briup.buke.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

@Controller
@Api(description="栏目相关接口")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("/background/category/findAll")
	@ApiOperation("查询所有栏目")
	public String findAll(HttpServletRequest request){
		List<Category> categoryList = categoryService.findAll();
		List<CategoryPack> categoryPackList = new ArrayList<CategoryPack>();
		for(Category c:categoryList) {
			CategoryPack categoryPack=new CategoryPack(c.getId(), c.getCode(), c.getName());
			categoryPackList.add(categoryPack);
		}
		request.setAttribute("categoryList", categoryPackList);
		return "background/category";
	}
	@RequestMapping("/background/category/deleteById/{id}")
	@ApiOperation("根据id删除栏目")
	@ResponseBody
	public String deleteById(@PathVariable int id){
		String message = null;
		try {
			categoryService.deleteById(id);
			message = "删除成功！";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}
	
	@ResponseBody
	@RequestMapping(value="/background/category/saveOrUpdate",method=RequestMethod.POST)
	@ApiOperation("保存或更新一个栏目")
	public String saveOrUpdate(CategoryPack categoryPack){
		String message = null;
		Category category = new Category();
		category.setId(categoryPack.getId());
		category.setCode(categoryPack.getCode());
		category.setName(categoryPack.getName());
		try {
			categoryService.saveOrUpdate(category);
			message = "保存成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}
	@RequestMapping("/background/category/findById/{id}")
	@ApiOperation("根据id查询栏目")
	@ResponseBody
	public CategoryPack findById(@PathVariable int id){
		CategoryPack message = null;
		try {
			Category category = categoryService.findById(id);
			System.out.println(category);
			CategoryPack cp=new CategoryPack();
			cp.setId(category.getId());
			cp.setName(category.getName());
			cp.setCode(category.getCode());
			message = cp;
			return message;
		} catch (Exception e) {
			return null;
		}
	}
}

