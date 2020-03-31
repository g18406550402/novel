package com.briup.buke.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.buke.bean.Link;
import com.briup.buke.exception.CustomerException;
import com.briup.buke.service.ILinkService;
import com.briup.buke.utils.Message;
import com.briup.buke.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/link")
@Api(description="Link相关接口")
public class LinkController {
	@Autowired
	private ILinkService linkService;
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation("更新或者保存信息，如果id为空则为保存")
	public Message<String> saveOrUpdate(Link link) throws Exception {
		linkService.saveOrUpdate(link);
		return MessageUtil.success("save success");
	}
	@GetMapping("/findAll")
	@ApiOperation("查询所有Link信息")
	public Message<List<Link>> findAll(){
		List<Link> list = linkService.findAll();
		return MessageUtil.success(list);
	}
	@GetMapping("/findById")
	@ApiImplicitParam(name="id",value="链接ID",paramType="query",dataType="int",required=true)
	@ApiOperation("根据id查询Link")
	
	public Message<Link> findById(Long id){
		
			Link link = linkService.findById(id);
			return MessageUtil.success(link);
		
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除一个链接")
	@ApiImplicitParam(name="id",value="链接ID",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(Long id){
		Message<String> message=null;
		try {
			linkService.deleteById(id);
			message= MessageUtil.success("delete success");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			message=MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
}
