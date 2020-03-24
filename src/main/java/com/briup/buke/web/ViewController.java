package com.briup.buke.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/foreground")
public class ViewController {
	@RequestMapping({"/","/toLogin"})
	public String toLogin() {
		return "foreground/index";
	}
	
}
