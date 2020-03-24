package com.briup.buke.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="book_chapter")
@Api
public class Chapter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="章节ID")
	private Integer id;
	@ApiModelProperty(value="章节标题")
	private String subtitle;
	@Lob
	@Column(columnDefinition="text")
	@ApiModelProperty(value="章节内容")
	private String content;
	@ApiModelProperty(value="小说id")
	@Column(name="article_id")
	private Integer articleId;
	
	
	public Chapter(Integer id, String subtitle, String content, Integer articleId) {
		super();
		this.id = id;
		this.subtitle = subtitle;
		this.content = content;
		this.articleId = articleId;
	}
	public Chapter() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", subtitle=" + subtitle + ", content=" + content + "]";
	}
	
	
}
