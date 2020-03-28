package com.briup.buke.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.buke.bean.Administrator;
import com.briup.buke.bean.Reader;
import com.briup.buke.service.IAdministratorService;

@Controller
public class AdministratorController {
	@Autowired
	private IAdministratorService adminService;
	@RequestMapping("/background/login")
	public String login(String username,String password,HttpSession session,HttpServletRequest request) {
		try {
			Administrator admin = adminService.login(username, password);
			session.setAttribute("admin",admin);
			return "background/index";
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "background/login";
		}
		
	}
	@RequestMapping("/background/logout")
	public String login(HttpSession session) {
		session.removeAttribute("admin");
		return "background/login";
	}
	
}
