package com.briup.buke.bean;

import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api
public class ArticleAndCategoryName {
	
	@ApiModelProperty(value="文章ID")
	private Long id;
	@ApiModelProperty(value="文章作者")
	private String author;
	@ApiModelProperty(value="文章点击次数",hidden=true)
	private Long clickTimes;
	@ApiModelProperty(value="文章简介")
	private String intro;
	@ApiModelProperty(value="文章更新时间",hidden=true)
	private String updateDate;
	@ApiModelProperty(value="文章标题")
	private String title;
	@ApiModelProperty(value="文章状态")
	private String state;
	@ApiModelProperty(value="文章字数（万字）")
	private Long words;
	@ApiModelProperty(value="文章图片URL")
	private String image;
	@ApiModelProperty(value="文章所在栏目")
	private String categoryName;
	public ArticleAndCategoryName() {
	}

	public ArticleAndCategoryName(Long id, String author, Long clickTimes, String intro, String updateDate,
			String title, String state, Long words, String image,String categoryName) {
		super();
		this.id = id;
		this.author = author;
		this.clickTimes = clickTimes;
		this.intro = intro;
		this.updateDate = updateDate;
		this.title = title;
		this.state = state;
		this.words = words;
		this.image = image;
		this.categoryName = categoryName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getClickTimes() {
		return clickTimes;
	}
	public void setClickTimes(Long clickTimes) {
		this.clickTimes = clickTimes;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getWords() {
		return words;
	}

	public void setWords(Long words) {
		this.words = words;
	}

	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ArticleAndCategoryName [id=" + id + ", author=" + author + ", clickTimes=" + clickTimes + ", intro="
				+ intro + ", updateDate=" + updateDate + ", title=" + title + ", state=" + state + ", words=" + words
				+ ", categoryNmae=" + categoryName + "]";
	}
	
	
}
