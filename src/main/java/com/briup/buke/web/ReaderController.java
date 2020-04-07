package com.briup.buke.web;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.briup.buke.bean.Comment;
import com.briup.buke.bean.Reader;
import com.briup.buke.bean.ReaderPack;
import com.briup.buke.service.IReaderService;
import com.briup.buke.utils.Message;
import com.briup.buke.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
public class ReaderController {
	@Autowired
	private IReaderService readerService;

	@ApiOperation("查询所有读者")
	@RequestMapping("/background/reader/findAll")
	public String findAll(HttpServletRequest request) {
		List<Reader> readerList = readerService.findAll();
		request.setAttribute("readerList", readerList);
		return "background/reader";
	}

	@ApiOperation("根据id查询读者")
	@ResponseBody
	@RequestMapping("/background/reader/findById/{id}")
	public Reader findById(@PathVariable Long id) {
		try {
			Reader reader = readerService.findById(id);
			return reader;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@ApiOperation("更新或保存读者信息")
	@RequestMapping("/background/reader/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(ReaderPack readerPack) {
		try {
			Reader reader = new Reader(readerPack.getId(), readerPack.getUsername(), readerPack.getPassword(),
					readerPack.getEmail());
			readerService.saveOrUpdate(reader);
			return "更新成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	@ApiOperation("根据id删除读者")
	@RequestMapping("/background/reader/deleteById/{id}")
	@ResponseBody
	public String deleteById(@PathVariable Long id) {
		try {
			readerService.deleteById(id);
			return "删除成功！";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	@ResponseBody
	@RequestMapping("/foreground/addToBookShelf")
	@ApiOperation("添加书籍到我的书架")
	public String addToBookShelf(Long reader_id, Long article_id) {
		readerService.addToBookShelf(reader_id, article_id);
		return "添加成功！您可以前往我的书架查看";
	}

	@ResponseBody
	@RequestMapping("/foreground/addBookMark")
	@ApiOperation("添加书签")
	public String addBookMark(Long reader_id, Long chapter_id) {
		readerService.addBookMark(reader_id, chapter_id);
		return "添加成功！您可以前往阅读记录查看";
	}
	@ResponseBody
	@RequestMapping("/foreground/removeFromBookShelf")
	@ApiOperation("从我的书架中删除书籍")
	public String removeFromBookShelf(Long readerId, Long articleId) {
		readerService.removeFromBookShelf(readerId, articleId);
		return "删除成功";
	}

	@ResponseBody
	@RequestMapping("/foreground/deleteBookMark")
	@ApiOperation("删除书签")
	public String deleteBookMark(Long readerId, Long chapterId) {
		readerService.deleteBookMark(readerId, chapterId);
		return "删除成功";
	}
	
	
	@RequestMapping("/commentaryArticle")
	public Message<String> commentaryArticle(String content, Long article_id, Long reader_id) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setArticleId(article_id);
		readerService.commentaryArticle(reader_id, comment);
		return MessageUtil.success("评论成功！");
	}

	// 登录
	@RequestMapping(value = "/foreground/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpServletRequest request, HttpSession session) {
		try {
			Reader reader = readerService.login(username, password);
			session.setAttribute("reader", reader);
			session.setAttribute("readerId", reader.getId());
			return "foreground/index";
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "foreground/error";
		}
	}

	// 退出
	@RequestMapping("/foreground/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("reader");
		session.removeAttribute("readerId");
		return "foreground/index";
	}

	// 转到注册页面
	@RequestMapping("/foreground/toRegister")
	public String toRegister() {
		return "foreground/register";
	}

	//注册
	@RequestMapping(value="/foreground/register",method=RequestMethod.POST)
	public String register(String username, String password, String email,HttpServletRequest request, HttpSession session) {
		Reader reader = new Reader();
		reader.setUsername(username);
		reader.setPassword(password);
		reader.setEmail(email);
		try {
			readerService.saveOrUpdate(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "foreground/error";
		}
		session.setAttribute("reader", reader);
		session.setAttribute("readerId", reader.getId());
		return "foreground/index";
	}

}
