package com.briup.buke.service;


import java.util.List;

import com.briup.buke.bean.Chapter;


public interface IChapterService {
	public void saveOrUpdate(Chapter chapter)throws Exception;
	
	public void deleteById(Integer id)throws Exception;
	
	public Chapter findById(Integer id)throws Exception;
	
	public List<Chapter> findByArticleId(Integer article_id);
	
	public List<Chapter> findUpdateChapter(Integer id);
	
	public List<Chapter> findAll();
}
