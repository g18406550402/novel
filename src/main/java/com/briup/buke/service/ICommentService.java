package com.briup.buke.service;

import java.util.List;

import com.briup.buke.bean.Comment;

public interface ICommentService {
	public List<Comment> findAll();
	
	public Comment findById(Long id)throws Exception;
	
	public void saveOrUpdate(Comment comment)throws Exception;
	
	public void deleteById(Long id)throws Exception;
	
	public List<Comment> findCommentByArticleId (Long id);
}
