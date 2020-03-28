package com.briup.buke.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.buke.bean.Administrator;
import com.briup.buke.bean.Reader;
import com.briup.buke.dao.AdministratorDao;
import com.briup.buke.service.IAdministratorService;
@Service
public class AdministratorServiceImpl implements IAdministratorService{
	@Autowired
	private AdministratorDao adminDao;
	@Override
	public Administrator login(String username, String password) throws Exception {
		Administrator admin = adminDao.findByUsername(username);
		if(admin!=null) {
			if(password.equals(admin.getPassword())) {
				return admin;
			}else {
				throw new Exception("密码错误，请重新输入！"); 
			}
		}else {
			throw new Exception("用户名错误，请确认用户名是否正确！！"); 
		}
	}

	@Override
	public void changePassword(Administrator admin) throws Exception {
		if(admin!=null) {
			if(admin.getId()!=null&&admin.getPassword()!=null) {
				
				adminDao.save(admin);
			}
			else throw new Exception("密码不能为空");
		}else throw new Exception("请输入参数");
			
		
		
	}

}
