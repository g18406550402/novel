package com.briup.buke.service;

import java.util.List;

import com.briup.buke.bean.Comment;
import com.briup.buke.bean.Reader;

public interface IReaderService {
	public List<Reader> findAll();
	
	public Reader findById(Long id)throws Exception;
	
	public void saveOrUpdate(Reader reader)throws Exception;
	
	public void deleteById(Long id)throws Exception;
	
	public void addToBookShelf (Long reader_id,Long article_id);
	
	public void removeFromBookShelf(Long readerId,Long articleId);
	
	public void addBookMark(Long reader_id,Long chapter_id);
	
	public void deleteBookMark(Long readerId,Long chapterId);
	
	public void commentaryArticle(Long reader_id,Comment comment);
	
	public Reader login(String username,String password) throws Exception;
}
