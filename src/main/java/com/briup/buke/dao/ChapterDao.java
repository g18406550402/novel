package com.briup.buke.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.buke.bean.Chapter;

public interface ChapterDao extends JpaRepository<Chapter, Long> {
	@Query(value="select * from book_chapter c where c.article_id=?1",nativeQuery=true)
	public List<Chapter> findByArticleId(Long article_id);
	
	@Query(value="select * from book_chapter c where c.article_id=?1 order by c.id desc limit 6",nativeQuery=true)
	public List<Chapter> findUpdateChapter(Long id);
}
