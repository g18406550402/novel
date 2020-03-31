package com.briup.buke.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="book_article")
@ApiModel
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="文章ID")
	private Long id;
	@ApiModelProperty(value="文章作者")
	private String author;
	@ApiModelProperty(value="点击次数",hidden=true)
	@Column(name="clickTimes")
	private Long clickTimes;
	@Lob
	@Column(columnDefinition="text")
	@ApiModelProperty(value="文章简介")
	private String intro;
	@ApiModelProperty(value="文章更新时间",hidden=true)
	@Column(name="updateDate")
	private Date updateDate;
	@ApiModelProperty(value="文章标题")
	private String title;
	@ApiModelProperty(value="文章状态")
	private String state;
	@ApiModelProperty(value="文章字数（万字）")
	private Long words;
	@ApiModelProperty(value="文章图片URL")
	private String image;
	@JoinColumn(name="category_id")
	//@Column(name="category_id")
	private Long category_id;
	
	@JsonIgnore
	@OneToMany
	private List<Chapter> chapters;
	
	@JsonIgnore
	@OneToMany
	private List<Comment> comments;
	public Article() {}

	public Article(Long id, String author, Long clickTimes, String intro, Date updateDate, String title,
			String state, Long words, String image, Long category_id) {
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
		this.category_id = category_id;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", clickTimes=" + clickTimes + ", intro=" + intro
				+ ", updateDate=" + updateDate + ", title=" + title + ", state=" + state + ", words=" + words
				+ ", image=" + image + ", category_id=" + category_id + "]";
	}
	
}
