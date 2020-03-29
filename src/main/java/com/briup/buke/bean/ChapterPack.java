package com.briup.buke.bean;

public class ChapterPack {
	private Integer id;
	private String subtitle;
	private String content;
	private Integer articleId;
	private String articleTitle;
	public ChapterPack(Integer id, String subtitle, String content, Integer articleId, String articleTitle) {
		super();
		this.id = id;
		this.subtitle = subtitle;
		this.content = content;
		this.articleId = articleId;
		this.articleTitle = articleTitle;
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
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	@Override
	public String toString() {
		return "ChapterPack [id=" + id + ", subtitle=" + subtitle + ", content=" + content + ", articleId=" + articleId
				+ ", articleTitle=" + articleTitle + "]";
	}
	
	
}
