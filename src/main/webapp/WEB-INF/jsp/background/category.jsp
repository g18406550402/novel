<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 客户信息查询 -->
<div id="category">
<div>
<%--   <form class="form-inline">
  <div class="form-group">
	<select name="name" id="" class="form-control">
		<option value="">请选择栏目名称</option>
		<c:forEach items="${categoryList }" var="category">
        <option value="${category.id }">${category.name }</option>
		</c:forEach>
	</select>
  </div>
  <input class="btn btn-default search" type="button" value="查询">
  <input class="btn btn-default" type="reset" value="重置"> --%>
  <input class="btn btn-default" type="button" value="新增" id="add">
</form>
</div>
<div>
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>序号</th>
		      <th>栏目代码</th>
		      <th>栏目名称</th>		 
			  <th >操作</th>
		    </tr> 
		  </thead>
		  <tbody>
		 	 <c:forEach items="${categoryList}" var="category">
			    <tr>
			      <td>${category.id}</td>
			      <td>${category.code}</td>
			      <td>${category.name}</td>
			      <td class="test">	
			      	<i value="${category.id}"class="layui-icon layui-icon-edit first" title="编辑栏目信息"></i> 
			        <i value="${category.id}" class="layui-icon layui-icon-delete deletee" title="删除栏目记录"></i>    
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
							<label>栏目代码:</label>
							<input type="text" name="categoryCode" class="form-control">
						</div>
						<div class="form-group">
							<label>栏目名称:</label>
							<input type="text" name="categoryName"  class="form-control">
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
#add{
	margin-left:980px;
}
#category{
	width: 1140px;
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
	#toAdd{
		margin-top: 50px;
	}
	#deleteModal{
		margin-top: 100px;
	}
</style>
<script type="text/javascript">
	function pageSelect(curPage){
		let url = "customer/findAllCustomerByPage/"+curPage;
		$(".layui-body").load(url);
	}
	$(function(){
		let categoryId;
		//点击查看栏目文章信息		
		$('.category-article').on('click',function(){
			$('.layui-body').load('./pages/linkman.html');  
		})
		$('.editRecord').on('click',function(){
			$('.layui-body').load('./pages/activities.html');  
		})

		// 点击新增显示模态框
		$('#add').click(function(){
			$('#toAdd').show();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			$('button[type=reset]').trigger('click');
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			let categoryName = $("input[name=categoryName]").val();
			let categoryCode = $("input[name=categoryCode]").val();
			categoryId=null;
			let data = {
				id:categoryId,
				name:categoryName,
				code:categoryCode,
			};
			console.log(data);
			let url = "/background/category/saveOrUpdate";
			$.post(url,data,function(data){
				$(".layui-nav-item dd:contains('栏目信息查询')").trigger("click");
			})
		})	
		// 显示编辑模态框
		$('.first').click(function(){
			categoryId = $(this).attr("value");
			let url = "/background/category/findById/"+categoryId;
			$.post(url,function(data){
				console.log(data);
				$("input[name=categoryName]").val(data.name);
				$("input[name=categoryCode]").val(data.code);
			});
			$('#toAdd').show();
		})
		// 显示删除模态框
		$('.deletee').click(function(){
			categoryId=$(this).attr("value");
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
			let url = "/background/category/deleteById/"+categoryId;
			$.get(url,function(data){
				alert(data);
				$(".layui-nav-item dd:contains('栏目信息查询')").trigger("click");
			});
			$('#deleteModal').hide();
		})
		// 查询
		$('.search').click(function(){
			alert('查询')
		})

	})
</script>