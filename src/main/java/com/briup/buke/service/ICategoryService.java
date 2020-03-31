package com.briup.buke.service;

import java.util.List;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Category;


public interface ICategoryService {
	
	public List<Category> findAll();
	
	public void deleteById(Long id)throws Exception;
	
	public void saveOrUpdate(Category category)throws Exception;
	
	public Category findById(Long id)throws Exception;
	
	public Long findIdByName(String name)throws Exception;
	
	
	
	public String findNameById(Long id);
	
}
