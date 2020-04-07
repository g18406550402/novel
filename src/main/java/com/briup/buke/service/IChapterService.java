package com.briup.buke.service;


import java.util.List;

import com.briup.buke.bean.Chapter;


public interface IChapterService {
	public void saveOrUpdate(Chapter chapter)throws Exception;
	
	public void deleteById(Long id)throws Exception;
	
	public Chapter findById(Long id)throws Exception;
	
	public List<Chapter> findByArticleId(Long article_id);
	
	public List<Chapter> findUpdateChapter(Long id);
	
	public List<Chapter> findAll();
	
	public Chapter findLatestChapter(Long articleId);
}
