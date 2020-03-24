package com.briup.buke.service;

import java.util.List;


import com.briup.buke.bean.Link;
import com.briup.buke.exception.CustomerException;


public interface ILinkService {

	
	public void saveOrUpdate(Link link)throws Exception;
	public List<Link> findAll();
	public Link findById(Integer id);
	public void deleteById(Integer id) throws Exception;
}
