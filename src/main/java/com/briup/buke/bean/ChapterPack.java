package com.briup.buke.bean;

public class ChapterPack {
	private Long id;
	private String subtitle;
	private String content;
	private Long articleId;
	private String articleTitle;
	public ChapterPack(Long id, String subtitle, String content, Long articleId, String articleTitle) {
		super();
		this.id = id;
		this.subtitle = subtitle;
		this.content = content;
		this.articleId = articleId;
		this.articleTitle = articleTitle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
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
