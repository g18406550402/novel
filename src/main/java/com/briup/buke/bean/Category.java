package com.briup.buke.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="book_category")
@ApiModel
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="栏目id")
	private Long id;
	@ApiModelProperty(value="栏目代码",required=true)
	private Long code;
	@ApiModelProperty(value="栏目名",required=true)
	@Column(unique=true)
	private String name;
	
	@JsonIgnore
	@OneToMany
	private List<Article> articles;
	public Category() {
	}

	
	public void setCode(Long code) {
		this.code = code;
	}

	
	public Category(Long code, String name) {
		super();
		this.code = code;
		this.name = name;
	}


	public Long getCode() {
		return code;
	}


	public Category(Long id, Long code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
}
