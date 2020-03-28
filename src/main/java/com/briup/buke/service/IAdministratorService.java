package com.briup.buke.service;

import com.briup.buke.bean.Administrator;

public interface IAdministratorService {
	public Administrator login(String username,String password)throws Exception;
	
	public void changePassword(Administrator admin)throws Exception;
}
