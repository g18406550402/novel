package com.briup.buke.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.buke.bean.Comment;
import com.briup.buke.dao.CommentDao;
import com.briup.buke.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	private CommentDao commentDao;
	@Override
	public List<Comment> findAll() {
		List<Comment> commentList = commentDao.findAll();
		return commentList;
	}

	@Override
	public Comment findById(Integer id) throws Exception {
		Optional<Comment> opt = commentDao.findById(id);
		Comment comment = opt.isPresent()?opt.get():null;
		if(comment!=null) {
			return comment;
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}

	@Override
	public void saveOrUpdate(Comment comment) throws Exception {
		if(comment!=null) {
			Integer id = comment.getId();
			if(id==null) {
				commentDao.save(comment);
			}else {
				Comment comment_db = commentDao.findById(id).get();
				String content = comment.getContent();
				Integer articleId = comment.getArticleId();
				Date publishDate = comment.getPublishDate();
				if(content!=null)
					comment_db.setContent(content);
				if(articleId!=null)
					comment_db.setArticleId(articleId);
				if(publishDate!=null) 
					comment_db.setPublishDate(publishDate);
				
				commentDao.save(comment_db);
				
			}
		}else {
			throw new Exception("参数为空！");
		}
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Comment> opt = commentDao.findById(id);
		Comment comment = opt.isPresent()?opt.get():null;
		if(comment!=null) {
			commentDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
		
	}

	@Override
	public List<Comment> findCommentByArticleId(Integer id)  {
		List<Comment> commentList = commentDao.findCommentByArticleId(id);
		
		return commentList;
	}

}
