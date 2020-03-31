package com.briup.buke.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.briup.buke.bean.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {
	@Query(value="select * from book_comment c where c.article_id=?1",nativeQuery=true)
	public List<Comment> findCommentByArticleId(Long article_id);
}
