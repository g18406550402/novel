package com.briup.buke.service;

import java.util.List;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Chapter;
public interface IArticleService {
	public void saveOrUpdate(Article article)throws Exception;
	
	public Article findById(Long id)throws Exception;
	
	public List<Article> findAll();
	
	public void deleteById(Long id)throws Exception;
	
	public Long findCategoryIdByArticleId(Long id);
	
	public List<Article> findArticleByCategoryId(Long categoryId);
	
	public List<Article> findByTitleOrArthor(String titleOrAuthor);
	
	public String findArticleNameByArticleId(Long id);
}
