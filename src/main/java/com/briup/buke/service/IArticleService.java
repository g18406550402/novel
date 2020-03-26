package com.briup.buke.service;

import java.util.List;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Chapter;
public interface IArticleService {
	public void saveOrUpdate(Article article)throws Exception;
	
	public Article findById(int id)throws Exception;
	
	public List<Article> findAll();
	
	public void deleteById(Integer id)throws Exception;
	
	public Integer findCategoryIdById(Integer id);
	
	public List<Article> findByCategory(Integer categoryId);
	
	public List<Article> findByTitleOrArthor(String titleOrAuthor);
	
	public String findArticleNameByArticleId(Integer id);
}
