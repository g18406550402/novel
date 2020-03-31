package com.briup.buke.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="book_comment")
@Api
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="评论ID")
	private Long id;
	@ApiModelProperty(value="评论内容")
	private String content;
	@ApiModelProperty(value="评论发表日期",hidden=true)
	@Column(name="publishDate")
	private Date publishDate;
	@Column(name="article_id")
	private Long articleId;
	/*@Column(name="reader_id")
	private Long readerId;*/
	public Comment() {
		super();
	}
	
	

	public Comment(Long id, String content, Date publishDate, Long articleId) {
		super();
		this.id = id;
		this.content = content;
		this.publishDate = publishDate;
		this.articleId = articleId;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	/*public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}*/

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", publishDate=" + publishDate + "]";
	}
	
	
}
