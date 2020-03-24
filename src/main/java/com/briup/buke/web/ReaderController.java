package com.briup.buke.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

@RestController
@RequestMapping("/reader")
public class ReaderController {
	@Autowired
	private IReaderService readerService;
	@ApiOperation("查询所有读者")
	@GetMapping("/findAll")
	public Message<List<Reader>> findAll(){
		List<Reader> readerList = readerService.findAll();
		return MessageUtil.success(readerList);
	}
	@ApiOperation("根据id查询读者")
	@GetMapping("/findById")
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
	@PutMapping("/saveOrUpdate")
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
	@DeleteMapping("/deleteById")
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
	
	@PutMapping("/addToBookShelf")
	@ApiOperation("添加书籍到我的书架")
	@ApiImplicitParams({
		@ApiImplicitParam(name="reader_id",value = "读者id",paramType = "query",dataType = "int",required=true),
		@ApiImplicitParam(name="article_id",value = "文章id",paramType = "query",dataType = "int",required=true)
	})
	public Message<String> addToBookShelf(Integer reader_id,Integer article_id){
		readerService.addToBookShelf(reader_id, article_id);
		return MessageUtil.success("添加成功！");
	}
	
	@PutMapping("/addBookMark")
	@ApiOperation("添加书签")
	@ApiImplicitParams({
		@ApiImplicitParam(name="reader_id",value = "读者id",paramType = "query",dataType = "int",required=true),
		@ApiImplicitParam(name="chapter_id",value = "章节id",paramType = "query",dataType = "int",required=true)
	})
	public Message<String> addBookMark(Integer reader_id,Integer chapter_id){
		readerService.addBookMark(reader_id, chapter_id);
		return MessageUtil.success("添加成功！");
	}
	@PutMapping("/commentaryArticle")
	@ApiOperation("评论文章")
	@ApiImplicitParams({
		@ApiImplicitParam(name="content",value="评论内容",paramType="query",dataType="String",required=true),
		@ApiImplicitParam(name="article_id",value = "文章id",paramType = "query",dataType = "int",required=true),
		@ApiImplicitParam(name="reader_id",value = "读者id",paramType = "query",dataType = "int",required=true)
	})
	
	public Message<String> commentaryArticle(String content,Integer article_id,Integer reader_id){
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setArticleId(article_id);
		readerService.commentaryArticle(reader_id, comment);
		return MessageUtil.success("评论成功！");
	}
	
}
