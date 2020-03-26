package com.briup.buke.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.buke.bean.Article;
import com.briup.buke.bean.Category;
import com.briup.buke.dao.ArticleDao;
import com.briup.buke.dao.CategoryDao;
import com.briup.buke.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ArticleDao articleDao;
	@Override
	public List<Category> findAll() {
		List<Category> list=categoryDao.findAll();
		return list;
	}
	@Override
	public void deleteById(int id) throws Exception {
		Optional<Category> opt = categoryDao.findById(id);
		Category category = opt.isPresent()?opt.get():null;
		if(category!=null) {
			categoryDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}
	@Override
	public void saveOrUpdate(Category category) throws Exception {
		if(category!=null){
			Integer id=category.getId();
			if(id==null) {
				categoryDao.save(category);
			}else {
				Category category_db = categoryDao.findById(id).get();
				String name = category.getName();
				Long code = category.getCode();
				if(name!=null) {
					category_db.setName(name);
				}
				if(code!=0) {
					category_db.setCode(code);
				}
				categoryDao.save(category_db);
			}
		}else {
			throw new Exception("参数为空！");
		}
	}
	@Override
	public Category findById(int id) throws Exception {
		Optional<Category> opt = categoryDao.findById(id);
		Category category = opt.isPresent()?opt.get():null;
		
		if(category!=null){
			return category;
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}
	@Override
	public Integer findIdByName(String name) throws Exception {
		if(name!=null) {
			Integer id = categoryDao.findIdByName(name);
			if(id!=null)
				return id;
			else
				throw new Exception("该栏目名不存在");
		}else
			return null;
	}
	
	@Override
	public String findNameById(Integer id)  {
		
		String  name = categoryDao.findNameById(id);
		return name;
	}
	

}
