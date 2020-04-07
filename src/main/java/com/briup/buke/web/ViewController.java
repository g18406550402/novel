package com.briup.buke.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.BookMark;
import com.briup.buke.bean.BookShelf;
import com.briup.buke.bean.Chapter;
import com.briup.buke.bean.ChapterPack;
import com.briup.buke.bean.Reader;
import com.briup.buke.dao.ArticleDao;
import com.briup.buke.service.IArticleService;
import com.briup.buke.service.ICategoryService;
import com.briup.buke.service.IChapterService;
import com.briup.buke.service.IReaderService;

@Controller
public class ViewController {
	@Autowired
	private IReaderService readerService;
	@Autowired 
	private IChapterService chapterService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	//跳转到首页
	@RequestMapping({"/foreground/toIndex","/foreground"})
	public String toForegroundIndex(HttpSession session) {
		List<Article> articleList = articleService.findHotSearch();
		session.setAttribute("hotSearch", articleList);
		return "foreground/index";
	}
	//跳转到个人中心
	@RequestMapping("/foreground/reader")
	public String toMyself() {
		
		return "foreground/reader";
	}
	//跳转到我的书架
	@RequestMapping("/foreground/bookshelf")
	public String toBookShelf(Long reader_id,HttpSession session,HttpServletRequest request) {
		try {
			Reader reader = readerService.findById(reader_id);
			Set<Article> articleList = reader.getArticles();
			Set<BookShelf> bsList = new HashSet<>();
			for(Article article:articleList) {
				BookShelf bs = new BookShelf();
				bs.setId(article.getId());
				bs.setTitle(article.getTitle());
				bs.setImage(article.getImage());
				
				String categoryName = categoryService.findNameById(article.getCategory_id());
				bs.setCategoryName(categoryName);
				
				bs.setCategoryId(article.getCategory_id());
				Chapter chapter = chapterService.findLatestChapter(article.getId());
				bs.setLatestChapterName(chapter.getSubtitle());
				bs.setLatestChapterId(chapter.getId());
				bsList.add(bs);
			}
			request.setAttribute("articleList", bsList);
			session.setAttribute("reader", reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foreground/bookshelf";
	}
	//跳转到阅读记录
	@RequestMapping("/foreground/bookmark")
	public String toBookMark(Long reader_id,HttpSession session,HttpServletRequest request) {
		try {
			Reader reader = readerService.findById(reader_id);
			Set<Chapter> chapterList = reader.getChapters();
			Set<BookMark> bkList= new HashSet<>();
			for(Chapter chapter:chapterList) {
				Article article = articleService.findById(chapter.getArticleId());
				BookMark bk =new BookMark();
				bk.setId(chapter.getId());
				bk.setSubtitle(chapter.getSubtitle());
				bk.setArticleId(chapter.getArticleId());
				bk.setArticleTitle(article.getTitle());
				bk.setArticleImage(article.getImage());
				bkList.add(bk);
			}
			request.setAttribute("chapterList", bkList);
			session.setAttribute("reader", reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "foreground/bookmark";
	}
	@RequestMapping("/foreground/toMyBookshelf")
	public String toMyBookShelf(Long reader_id,HttpSession session,HttpServletRequest request) {
		try {
			Reader reader = readerService.findById(reader_id);
			Set<Article> articleList = reader.getArticles();
			Set<BookShelf> bsList = new HashSet<>();
			for(Article article:articleList) {
				BookShelf bs = new BookShelf();
				bs.setId(article.getId());
				bs.setTitle(article.getTitle());
				bs.setImage(article.getImage());
				
				String categoryName = categoryService.findNameById(article.getCategory_id());
				bs.setCategoryName(categoryName);
				
				bs.setCategoryId(article.getCategory_id());
				Chapter chapter = chapterService.findLatestChapter(article.getId());
				bs.setLatestChapterName(chapter.getSubtitle());
				bs.setLatestChapterId(chapter.getId());
				bsList.add(bs);
			}
			request.setAttribute("articleList", bsList);
			session.setAttribute("reader", reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foreground/myBookshelf";
	}
	@RequestMapping("/foreground/toMyBookmark")
	public String toMyBookmark(Long reader_id,HttpSession session,HttpServletRequest request) {
		try {
			Reader reader = readerService.findById(reader_id);
			Set<Chapter> chapterList = reader.getChapters();
			Set<BookMark> bkList= new HashSet<>();
			for(Chapter chapter:chapterList) {
				Article article = articleService.findById(chapter.getArticleId());
				BookMark bk =new BookMark();
				bk.setId(chapter.getId());
				bk.setSubtitle(chapter.getSubtitle());
				bk.setArticleId(chapter.getArticleId());
				bk.setArticleTitle(article.getTitle());
				bk.setArticleImage(article.getImage());
				bkList.add(bk);
			}
			request.setAttribute("chapterList", bkList);
			session.setAttribute("reader", reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "foreground/myBookmark";
	}
	//跳转到后台管理登录页面
	@RequestMapping({"/background/toLogin","/background"})
	public String backgroundToLogin() {
		return "background/login";
	}
	//跳转到都断管理首页
	@RequestMapping("/background/toIndex")
	public String backgroundToINdex() {
		return "background/index";
	}
}
