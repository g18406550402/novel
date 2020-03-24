package com.briup.buke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.buke.bean.Link;
import com.briup.buke.dao.LinkDao;
import com.briup.buke.exception.CustomerException;
import com.briup.buke.service.ILinkService;
@Service
public class LinkServiceImpl implements ILinkService{
	@Autowired
	private LinkDao linkDao;
	@Override
	public void saveOrUpdate(Link link) throws CustomerException {
		if(link!=null) {
			Integer id = link.getId();
			if(id==null) {
				linkDao.save(link);
			}else {
				Link link_db = linkDao.findById(id).get();
				if(link.getName()!=null) {
					link_db.setName(link.getName());
				}
				if(link.getUrl()!=null) {
					link_db.setUrl(link.getUrl());
				}
				linkDao.save(link_db);
			}
		}else {
			throw new CustomerException(500, "Lack of Parameter");
		}
	}
	@Override
	public List<Link> findAll() {
		List<Link> list = linkDao.findAll();
		return list;
	}
	@Override
	public Link findById(Integer id) {
		Optional<Link> opt = linkDao.findById(id);
		Link link = opt.isPresent()?opt.get():null;
		
		return link;
		
	}
	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Link> opt = linkDao.findById(id);
		Link link = opt.isPresent()?opt.get():null;
		if(link!=null) {
			linkDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在！！");
		}
	}
	
}
