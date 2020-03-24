package com.briup.buke;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Category;
import com.briup.buke.dao.ArticleDao;
import com.briup.buke.dao.CategoryDao;
import com.briup.buke.service.ICategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BukeApplicationTests {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private CategoryDao categoryDao;
	@Test
	public void test() throws Exception {
		System.out.println("---------------------------");
		Category category = categoryService.findById(1);
		//List<Article> articles = category.getArticles();
		System.out.println(category);
		//System.out.println(articles);
		System.out.println("---------------------------");
	}
	@Test
	public void contextLoads() {
		
		
	}

}
