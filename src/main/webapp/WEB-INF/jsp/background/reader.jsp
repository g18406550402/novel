<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 读者信息查询 -->
<div id="reader">
<div>
  <form class="form-inline">
  <div class="form-group">
	<select name="search" id="" class="form-control">
		<option value="">请选择所属文章标题</option>
		<c:forEach items="${articleList }" var="article">
        <option value="${article.id }">${article.title }</option>
        </c:forEach> 
	</select>
  </div>
  <input class="btn btn-default search" type="button" value="查询">
  <input class="btn btn-default" type="reset" value="重置">
  <input class="btn btn-default" type="button" value="新增" id="add">
</form>
</div>
<div>
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>序号</th>
		      <th>用户名</th>
		      <th>密码</th>
		      <th>email</th>
			  <th >操作</th>
		    </tr> 
		  </thead>
		  <tbody>
		 	 <c:forEach items="${readerList}" var="reader">
			    <tr>
			      <td>${reader.id}</td>
			      <td>${reader.username}</td>
			      <td>${reader.password}</td>
			      <td>${reader.email}</td>
			      <td class="test">	
			      	<i value="${reader.id}"class="layui-icon layui-icon-edit first" title="编辑读者信息"></i> 
			        <i value="${reader.id}" class="layui-icon layui-icon-delete deletee" title="删除读者记录"></i>    
			      </td>
			    </tr> 
		   	 </c:forEach>
         </tbody>
    </table>
</div>
<!-- 删除模态框 -->
<div class="modal" id="deleteModal">
  <div class="modal-dialog"  style="width:350px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">是否确定删除</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
<!-- 新增模态框 -->
<div class="modal"  id="toAdd">
  <div class="modal-dialog" style="height:400px;overflow:auto;">
    <div class="modal-content">
       <form>
					<div class="modal-body">
						<div class="form-group">
							<label>用户名:</label>
							<input type="text" name="readerUsername"  class="form-control">
						</div>
						<div class="form-group">
							<label>密码:</label><br>
							<input type="text" name="readerPassword"  class="form-control">
						</div>
						<div class="form-group">
							<label>email:</label><br>
							<input type="text" name="readerEmail"  class="form-control">
						</div>
					</div>
					<button type="reset"></button>
				</form>
				<div class="modal-footer">
				    <button class="btn" style="background:#ccc">取消</button>
					<button class="btn" style="background:#ccc">保存</button>
				</div>
    </div>
  </div>
</div>
</div>
<style>
#reader{
	width: 1080px;
	overflow: hidden;
}
.pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover, .pagination > .active > span, .pagination > .active > span:focus, .pagination > .active > span:hover {
    background-color: #ccc;
    border-color: #ccc;
}
.pagination > li > a, .pagination > li > span {
    color: black;
}
.fenye{
	margin-left: 400px;
}
#readerContent{
display: block;
width: 100%;
height: 160px;
padding: 6px 12px;
font-size: 14px;
line-height: 1.42857143;
color: #555;
background-color: #fff;
background-image: none;
border: 1px solid #ccc;
border-radius: 4px;
box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
	.form-inline{
		margin-top: 15px;
		margin-left: 10px;
		margin-bottom: 20px;
	}
	.search{
		margin-left: 50px;
	}
	.table th,td{
		text-align: center;
	}
	#add{
	
	}
	#toAdd{
		margin-top: 50px;
	}
	#deleteModal{
		margin-top: 100px;
	}
</style>
<script type="text/javascript">
	$(function(){
		let readerId;
		// 点击新增显示模态框
		$('#add').click(function(){
			readerId=null;
			$('#toAdd').show();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			readerId=null;
			$('button[type=reset]').trigger('click');
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			let readerUsername = $("input[name=readerUsername]").val();
			let readerPassword = $("input[name=readerPassword]").val();
			let readerEmail = $("input[name=readerEmail]").val();
			let data = {
				id:readerId,
				username:readerUsername,
				password:readerPassword,
				email:readerEmail
			};
			console.log(data)
			let url = "/background/reader/saveOrUpdate";
			$.post(url,data,function(data){
				$(".layui-nav-item dd:contains('读者信息查询')").trigger("click");
			})
		})	
		// 显示编辑模态框
		$('.first').click(function(){
			readerId = $(this).attr("value");
			let url = "/background/reader/findById/"+readerId;
			$.post(url,function(data){
				console.log(data);
				$("input[name=readerUsername]").val(data.username);
				$("input[name=readerPassword]").val(data.password);
				$("input[name=readerEmail]").val(data.email);
			});
			$('#toAdd').show();
		})
		// 显示删除模态框
		$('.deletee').click(function(){
			readerId=$(this).attr("value");
			$('#deleteModal').show();
		})
		// 关闭删除模态框
		$('.close').click(function(){
			$('#deleteModal').hide();
		})
		// 关闭删除模态框
		$('.btn-default').click(function(){
			$('#deleteModal').hide();
		})
		// 确定删除
		$('.btn-primary').click(function(){
			let url = "/background/reader/deleteById/"+readerId;
			$.get(url,function(data){
				alert(data);
				$(".layui-nav-item dd:contains('读者信息查询')").trigger("click");
			});
			$('#deleteModal').hide();
		})
		// 查询
		$('.search').click(function(){
			let articleId = $("select[name=search] option:selected").val();
			let url = "/background/reader/findByArticleId/"+articleId;
			$('.layui-body').load(url);
		})

	})
</script>