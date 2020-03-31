package com.briup.buke.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.buke.bean.Comment;
import com.briup.buke.service.ICommentService;
import com.briup.buke.utils.Message;
import com.briup.buke.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comment")
@Api(description="评论相关操作")
public class CommentController {
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/findAll")
	@ApiOperation("查找全部评论")
	public Message<List<Comment>> findAll(){
		List<Comment> commentList = commentService.findAll();
		return MessageUtil.success(commentList);
	}
	@GetMapping("/findById")
	@ApiOperation("根据id查找评论")
	@ApiImplicitParam(name="id",value="评论id",paramType="query",dataType="int",required=true)
	public Message<Comment> findById(Long id){
		try {
			Comment comment = commentService.findById(id);
			return MessageUtil.success(comment);
			
		} catch (Exception e) {
			return MessageUtil.error(500, e.getMessage());
		}
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除评论")
	@ApiImplicitParam(name="id",value="评论id",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(Long id){
		try {
			commentService.deleteById(id);
			return MessageUtil.success("删除成功");
		} catch (Exception e) {
			return MessageUtil.error(500, e.getMessage());
		}
	}
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation("保存或更新评论")
	public Message<String> saveOrUpdate(Comment comment){
		
		try {
			comment.setPublishDate(new Date());
			commentService.saveOrUpdate(comment);
			return MessageUtil.success("更新成功");
		} catch (Exception e) {
			return MessageUtil.error(500, e.getMessage());
		}
	}
	@GetMapping("/findCommentByArticleId")
	@ApiOperation("根据文章id查找评论")
	@ApiImplicitParam(name="article_id",value="文章id",paramType="query",dataType="int",required=true)
	public Message<List<Comment>> findCommentByArticleId(Long article_id){
		List<Comment> commentList = commentService.findCommentByArticleId(article_id);
		return MessageUtil.success(commentList);
	}
}
