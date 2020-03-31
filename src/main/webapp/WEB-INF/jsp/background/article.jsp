<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 文章信息查询 -->
<div id="article">
<div>
  <form class="form-inline">
  <div class="form-group">
	<select name="search" id="" class="form-control">
		 <option value="">请选择所属栏目</option>
        <option value="1">奇幻玄幻</option>
        <option value="2">言情浪漫</option>
        <option value="3">青春校园</option>
        <option value="4">武侠仙侠</option>
        <option value="5">文学名著</option>
        <option value="6">历史军事</option>
        <option value="7">人文社科</option>
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
		      <th>文章标题</th>
		      <th>文章作者</th>
		      <th>文章状态</th>
		      <th>文章字数</th>
		      <th>文章栏目</th>
			  <th >操作</th>
		    </tr> 
		  </thead>
		  <tbody>
		 	 <c:forEach items="${articleList}" var="article">
			    <tr>
			      <td>${article.id}</td>
			      <td>${article.title}</td>
			      <td>${article.author}</td>
			      <td>${article.state}</td>
			      <td>${article.words}万</td>
			      <td>${article.categoryName}</td>
			      <td class="test">	
			      	<i value="${article.id}"class="layui-icon layui-icon-edit first" title="编辑文章信息"></i> 
			        <i value="${article.id}" class="layui-icon layui-icon-delete deletee" title="删除文章记录"></i>    
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
							<label>文章标题:</label>
							<input type="text" name="articleTitle"  class="form-control">
						</div>
						<div class="form-group">
							<label>文章作者:</label>
							<input type="text" name="articleAuthor" class="form-control">
						</div>
						<div class="form-group">
							<label>文章简介:</label><br>
							<textarea id="articleIntro" name="articleIntro" ></textarea><br>
						</div>
						<div class="form-group">
							<label>文章状态:</label>
							<input type="text" name="articleState" class="form-control">
						</div>
						<div class="form-group">
							<label>文章字数:</label>
							<input type="text" name="articleWords" class="form-control">
						</div>
						<div class="form-group">
							<label>文章栏目:</label>
							<select name="categoryName" id="" class="form-control">
								<option value="">请选择所属栏目</option>
						        <option value="玄幻奇幻">玄幻奇幻</option>
						        <option value="言情浪漫">言情浪漫</option>
						        <option value="青春校园">青春校园</option>
						        <option value="武侠仙侠">武侠仙侠</option>
						        <option value="文学名著">文学名著</option>
						        <option value="历史军事">历史军事</option>
						        <option value="人文社科">人文社科</option>
							</select>
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
#article{
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
#articleIntro{
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
		let articleId;
		// 点击新增显示模态框
		$('#add').click(function(){
			articleId=null;
			$('#toAdd').show();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			//$('button[type=reset]').trigger('click');
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			let articleTitle = $("input[name=articleTitle]").val();
			let articleAuthor = $("input[name=articleAuthor]").val();
			//处理文章简介
			let articleIntro = $("textarea[name=articleIntro]").val();
			articleIntor = articleIntro.replace(/\r/g,'');
			articleIntor = '<p>'+articleIntor.replace(/n*$/g,'').replace(/\n/g,'</p><p>')+'</p>';
			articleIntor = articleIntor.replace(/\s+/g,"");
			articleIntor = articleIntor.replace(RegExp("<p></p>","g"),'');
			
			let articleState = $("input[name=articleState]").val();
			let articleWords = $("input[name=articleWords]").val();
			let categoryName = $("select[name=categoryName] option:selected").val();
			
			let data = {
				id:articleId,
				title:articleTitle,
				author:articleAuthor,
				intro:articleIntro,
				words:articleWords,
				state:articleState,
				categoryName:categoryName
			};
			console.log(data);
			let url = "/background/article/saveOrUpdate";
			$.post(url,data,function(data){
				$(".layui-nav-item dd:contains('文章信息查询')").trigger("click");
			})
		})	
		// 显示编辑模态框
		$('.first').click(function(){
			articleId = $(this).attr("value");
			let url = "/background/article/findById/"+articleId;
			$.post(url,function(data){
				console.log(data);
				$("input[name=articleTitle]").val(data.title);
				$("input[name=articleAuthor]").val(data.author);
				$("textarea[name=articleIntro]").val(data.intro);
				$("input[name=articleState]").val(data.state);
				$("input[name=articleWords]").val(data.words);
				$("select[name=categoryName]").val(data.categoryName);
			});
			$('#toAdd').show();
		})
		// 显示删除模态框
		$('.deletee').click(function(){
			articleId=$(this).attr("value");
			alert(articleId);
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
			let url = "/background/article/deleteById/"+articleId;
			$.get(url,function(data){
				alert(data);
				$(".layui-nav-item dd:contains('文章信息查询')").trigger("click");
			});
			$('#deleteModal').hide();
		})
		// 查询
		$('.search').click(function(){
			let categoryId = $("select[name=search] option:selected").val();
			let url = "/background/article/findByCategoryId/"+categoryId;
			$('.layui-body').load(url);
		})

	})
</script>