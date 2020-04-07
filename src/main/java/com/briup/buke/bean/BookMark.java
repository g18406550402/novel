package com.briup.buke.bean;

public class BookMark {
	private Long id;
	private String subtitle;
	private Long articleId;
	private String articleTitle;
	private String articleImage;

	public BookMark(Long id, String subtitle, Long articleId, String articleTitle, String articleImage) {
		super();
		this.id = id;
		this.subtitle = subtitle;
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleImage = articleImage;
	}
	
	public BookMark() {
		super();
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
	public String getArticleImage() {
		return articleImage;
	}
	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}
	@Override
	public String toString() {
		return "BookMark [id=" + id + ", subtitle=" + subtitle + ", articleId=" + articleId + ", articleTitle="
				+ articleTitle + ", articleImage=" + articleImage + "]";
	}
	
	
	
	
}
