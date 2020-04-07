package com.briup.buke.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Chapter;
import com.briup.buke.bean.Comment;
import com.briup.buke.bean.Reader;
import com.briup.buke.dao.ArticleDao;
import com.briup.buke.dao.ChapterDao;
import com.briup.buke.dao.CommentDao;
import com.briup.buke.dao.ReaderDao;
import com.briup.buke.service.IArticleService;
import com.briup.buke.service.IChapterService;
import com.briup.buke.service.ICommentService;
import com.briup.buke.service.IReaderService;
@Service
public class ReaderServiceImpl implements IReaderService{
	@Autowired
	private ReaderDao readerDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChapterDao chapterDao;
	
	@Override
	public List<Reader> findAll() {
		List<Reader> readerList = readerDao.findAll();
		return readerList;
	}

	@Override
	public Reader findById(Long id) throws Exception {
		Optional<Reader> opt = readerDao.findById(id);
		Reader reader = opt.isPresent()?opt.get():null;
		if(reader!=null)
			return reader;
		else 
			throw new Exception("该id在数据库中不存在！");
		
	}

	@Override
	public void saveOrUpdate(Reader reader) throws Exception {
		if(reader!=null) {
			Long id = reader.getId();
			if(id==null) {
				readerDao.save(reader);
			}else {
				Reader reader_db = readerDao.findById(id).get();
				String username = reader.getUsername();
				String password = reader.getPassword();
				String email = reader.getEmail();
				if(username!=null)
					reader_db.setUsername(username);
				if(password!=null)
					reader_db.setPassword(password);
				if(email!=null)
					reader_db.setEmail(email);
				readerDao.save(reader_db);
				
			}
		}else
			throw new Exception("参数为空！");
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Reader> opt = readerDao.findById(id);
		Reader reader = opt.isPresent()?opt.get():null;
		if(reader!=null) {
			readerDao.deleteById(id);
		}else
			throw new Exception("该id在数据库中不存在！");
		
	}

	@Override
	public void addToBookShelf(Long reader_id, Long article_id) {
		Reader reader = readerDao.findById(reader_id).get();
		Article article = articleDao.findById(article_id).get();
		Set<Article> articleList = reader.getArticles();
		articleList.add(article);
		reader.setArticles(articleList);
		readerDao.save(reader);
	}

	@Override
	public void addBookMark(Long reader_id, Long chapter_id) {
		Reader reader = readerDao.findById(reader_id).get();
		//添加书签
		Chapter chapter = chapterDao.findById(chapter_id).get();
		Set<Chapter> chapterList = reader.getChapters();
		chapterList.add(chapter);
		//添加到我的书籍
		Article article = articleDao.findById(chapter.getArticleId()).get();
		Set<Article> articleList = reader.getArticles();
		articleList.add(article);
		reader.setArticles(articleList);
		reader.setChapters(chapterList);
		readerDao.save(reader);
	}
	
	@Override
	public void commentaryArticle(Long reader_id, Comment comment) {
		//根据id查出读者
		Reader reader = readerDao.findById(reader_id).get();
		//保存评论
		comment.setPublishDate(new Date());
		commentDao.save(comment);
		//添加关系
		Set<Comment> commentList = reader.getComments();
		commentList.add(comment);
		reader.setComments(commentList);
		readerDao.save(reader);
		
	}

	@Override
	public Reader login(String username, String password) throws Exception {
		Reader reader = readerDao.findByUsername(username);
		if(reader!=null) {
			if(password.equals(reader.getPassword())) {
				return reader;
			}else {
				throw new Exception("密码错误，请注意字母大小写是否输入正确！！"); 
			}
		}else {
			throw new Exception("用户名错误，请确认用户名是否输入正确！！"); 
		}
		
	}

	@Override
	public void removeFromBookShelf(Long readerId, Long articleId) {
		Reader reader = readerDao.findById(readerId).get();
		Article article = articleDao.findById(articleId).get();
		Set<Article> articleList = reader.getArticles();
		articleList.remove(article);
		reader.setArticles(articleList);
		readerDao.save(reader);
		
	}

	@Override
	public void deleteBookMark(Long readerId, Long chapterId) {
		Reader reader = readerDao.findById(readerId).get();
		//添加书签
		Chapter chapter = chapterDao.findById(chapterId).get();
		Set<Chapter> chapterList = reader.getChapters();
		chapterList.remove(chapter);
		reader.setChapters(chapterList);
		readerDao.save(reader);
		
	}
	 
	
	
	
}
