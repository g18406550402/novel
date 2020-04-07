package com.briup.buke.bean;

public class BookShelf {
	private Long id;
	private String title;
	private String image;
	private Long categoryId;
	private String categoryName;
	private String latestChapterName;
	private Long latestChapterId;
	
	public BookShelf(Long id, String title, String image, Long categoryId, String categoryName,
			String latestChapterName, Long latestChapterId) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.latestChapterName = latestChapterName;
		this.latestChapterId = latestChapterId;
	}
	public BookShelf() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getLatestChapterName() {
		return latestChapterName;
	}
	public void setLatestChapterName(String latestChapterName) {
		this.latestChapterName = latestChapterName;
	}
	public Long getLatestChapterId() {
		return latestChapterId;
	}
	public void setLatestChapterId(Long latestChapterId) {
		this.latestChapterId = latestChapterId;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "BookShelf [id=" + id + ", title=" + title + ", image=" + image + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", latestChapterName=" + latestChapterName + ", latestChapterId="
				+ latestChapterId + "]";
	}
	
	
}
