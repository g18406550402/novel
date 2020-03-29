package com.briup.buke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Category;
import com.briup.buke.bean.Chapter;
import com.briup.buke.dao.ArticleDao;
import com.briup.buke.dao.ChapterDao;
import com.briup.buke.service.IChapterService;
@Service
public class ChapterServiceImpl implements IChapterService {
	@Autowired
	private ChapterDao chapterDao;
	@Autowired
	private ArticleDao articleDao;
	@Override
	public void saveOrUpdate(Chapter chapter) throws Exception {
		if(chapter!=null) {
			Integer id = chapter.getId();
			if(id==null) {
				//插入章节是修改文章的upadateDate
				Integer articleId = chapter.getArticleId();
				Article article = articleDao.findById(articleId).get();
				articleDao.save(article);
				chapterDao.save(chapter);
			}else {
				//根据id查出文章
				Chapter chapter_db = chapterDao.findById(id).get();
				//更改标题作者栏目
				String subtitle = chapter.getSubtitle();
				String content = chapter.getContent();
				Integer articleId = chapter.getArticleId();
				if(subtitle!=null&&(subtitle!="")) 
					chapter_db.setSubtitle(subtitle);
				if(content!=null&&(content!=""))
					chapter_db.setContent(content);
				if(articleId!=null)
					chapter_db.setArticleId(articleId);
				chapterDao.save(chapter_db);
			}
		}else{
			throw new Exception("参数ID为空");
		}
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Chapter> opt = chapterDao.findById(id);
		Chapter chapter = opt.isPresent()?opt.get():null;
		if(chapter!=null) {
			chapterDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}

	@Override
	public Chapter findById(Integer id) throws Exception {
		Optional<Chapter> opt = chapterDao.findById(id);
		Chapter chapter = opt.isPresent()?opt.get():null;
		if(chapter!=null) {
			return chapter;
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}
	
	@Override
	public List<Chapter> findByArticleId(Integer article_id) {
		List<Chapter> chapList = chapterDao.findByArticleId(article_id);
		return chapList;
	}

	@Override
	public List<Chapter> findUpdateChapter(Integer id) {
		List<Chapter> chapterList = chapterDao.findUpdateChapter(id);
		return chapterList;
	}

	@Override
	public List<Chapter> findAll() {
		List<Chapter> chapterList = chapterDao.findAll();
		return chapterList;
	}

}
