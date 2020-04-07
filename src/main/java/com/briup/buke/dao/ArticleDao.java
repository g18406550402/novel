package com.briup.buke.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Chapter;

public interface ArticleDao extends JpaRepository<Article, Long>{
	@Query(value="select c.category_id from book_article c where c.id=?1",nativeQuery=true)
	public Long findCategoryIdByArticleId(Long id);
	
	@Query(value="select * from book_article c where c.category_id=?1",nativeQuery=true)
	public List<Article> findByCategory(Long categoryId);
	
	@Transactional
	@Modifying
	@Query(value="delete from book_article where id= ?1",nativeQuery=true)
	public void deleteById(Long id);
	
	@Query(value="select * from book_article c where c.title like %?1% or c.author like %?1%",nativeQuery=true)
	public List<Article> findByTitleOrArthor(String titleaOrAuthor);
	
	@Query(value="select c.title from book_article c where c.id=?1",nativeQuery=true)
	public String findArticleNameByArticleId(Long id);
	
	@Query(value="select c.id from book_article c where c.title=?1",nativeQuery=true)
	public Long findArticleIdByArticleName(String articleName);
	
	@Query(value="select * from book_article a order by a.clickTimes desc limit 5",nativeQuery=true)
	public List<Article> findHotSearch();
}
