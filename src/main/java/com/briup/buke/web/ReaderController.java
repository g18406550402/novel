package com.briup.buke.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/reader/findAll")
	public Message<List<Reader>> findAll(){
		List<Reader> readerList = readerService.findAll();
		return MessageUtil.success(readerList);
	}
	@ApiOperation("根据id查询读者")
	@GetMapping("/reader/findById")
	@ApiImplicitParam(name="id",value="读者id",paramType="query",dataType="int",required=true)
	public Message<Reader> findById(Integer id){
		try {
			Reader reader = readerService.findById(id);
			return MessageUtil.success(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
	}
	
	@ApiOperation("更新或保存读者信息")
	@PutMapping("/reader/saveOrUpdate")
	public Message<String> saveOrUpdate(ReaderPack readerPack){
		try {
			Reader reader=new Reader(readerPack.getId(), readerPack.getUsername(), 
					readerPack.getPassword(), readerPack.getEmail());
			readerService.saveOrUpdate(reader);
			return MessageUtil.success("更新成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
	}
	@ApiOperation("根据id删除读者")
	@DeleteMapping("/reader/deleteById")
	@ApiImplicitParam(name="id",value="读者id",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(Integer id){
		try {
			readerService.deleteById(id);
			return MessageUtil.success("删除成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
	}
	@ResponseBody
	@RequestMapping("/foreground/addToBookShelf")
	@ApiOperation("添加书籍到我的书架")
	public String addToBookShelf(Integer reader_id,Integer article_id){
		readerService.addToBookShelf(reader_id, article_id);
		return "添加成功！您可以前往我的书架查看";
	}
	@ResponseBody
	@RequestMapping("/foreground/addBookMark")
	@ApiOperation("添加书签")
	public String addBookMark(Integer reader_id,Integer chapter_id){
		readerService.addBookMark(reader_id, chapter_id);
		return "添加成功！您可以前往阅读记录查看";
	}
	@PutMapping("/commentaryArticle")
	public Message<String> commentaryArticle(String content,Integer article_id,Integer reader_id){
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setArticleId(article_id);
		readerService.commentaryArticle(reader_id, comment);
		return MessageUtil.success("评论成功！");
	}
	//登录
	@RequestMapping(value="/foreground/login",method=RequestMethod.POST)
	public String login(String username ,String password,HttpServletRequest request,HttpSession session)  {
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
	//退出
	@RequestMapping("/foreground/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("reader");
		return "foreground/index";
	}
	
}
