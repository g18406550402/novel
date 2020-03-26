package com.briup.buke.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.buke.bean.Reader;
import com.briup.buke.service.IReaderService;

@Controller
public class ViewController {
	@Autowired
	private IReaderService readerService;
	//跳转到首页
	@RequestMapping("/foreground/index")
	public String toIndex() {
		return "foreground/index";
	}
	//跳转到个人中心
	@RequestMapping("/foreground/reader")
	public String toMyself() {
		
		return "foreground/reader";
	}
	//跳转到我的书架
	@RequestMapping("/foreground/bookshelf")
	public String toBookShelf(int reader_id,HttpSession session) {
		try {
			Reader reader = readerService.findById(reader_id);
			session.setAttribute("reader", reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foreground/bookshelf";
	}
	//跳转到阅读记录
	@RequestMapping("/foreground/bookmark")
	public String toBookMark(int reader_id,HttpSession session) {
		try {
			Reader reader = readerService.findById(reader_id);
			session.setAttribute("reader", reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foreground/bookmark";
	}

}
