<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${articleName}-${chapter.subtitle }</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${articleName }-${chapter.subtitle }</title>
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/chapter.css?v01128" />
<script type="text/javascript" src="http://localhost:8080/js/pcman.js"></script>
<script type="text/javascript" src="http://localhost:8080/js/pctheme.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>

</head>
<body class="bg6" id="readbg">
	<div class="top">
		<div class="bar">
			<div class="chepnav">
				<i>当前位置:</i><a href="/foreground/index">铅笔小说</a>><a
					href="/foreground/toCategory?id=${categoryId }">${categoryName }</a>><a
					href="/foreground/toArticle?id=${articleId }">${articleName}</a>> <em>${chapter.subtitle }</em>
			</div>
			<c:set var="username" value="${reader.username}" />
			<c:choose>
			<c:when test="${empty username}">
			<ul>
				<form action="/foreground/login" name="frmlogin" method="post">
					<div class="unloginl">
						<input type="text" name="username" placeholder="帐号" class="putk">
						<input type="password" name="password" placeholder="密码"
							class="putk"> 
						<input type="submit" name="submit" class="logint" value="登录">&nbsp;&nbsp;<a
							href="/foreground/toRegister">注册</a>
					</div>
				</form>
			</ul>
			</c:when>
			<c:otherwise>
					<ul id="ul2">
						<font color="coral">${reader.username }</font>｜
						<a href="/foreground/reader">个人中心</a>｜
						<a href="/foreground/bookshelf?reader_id=${reader.id }">我的书架</a>｜
						<a href="/foreground/logout" target="self">退出</a>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
		<%-- <ul>
				<b>Hi ${reader.username } </b>，
				<a href="/foreground/reader">个人中心</a>｜
				<a href="/foreground/bookshelf?reader_id=${reader.id }">我的书架</a>｜
				<a href="/foreground/logout" target="self">退出</a>
			</ul> --%>


	</div>
	</div>
	<div class="mlfy_main">
		<div class="container">
			<ul class="links">
				<li><a href="javascript:void(0);" onclick="addBookMark()">标记书签</a>
					|</li>
				<li><a href="/foreground/bookmark?reader_id=${reader.id }">阅读记录</a></li>
			</ul>
			<div class="mlfy_main_l">
				<i class="szk"><em class="icon-cog"></em> <z>阅读</z>设置</i><i
					class="hid">（推荐配合 快捷键[F11] 进入全屏沉浸式阅读）</i>
			</div>
		</div>
		<div id="mlfy_main_text">
			<h1>${chapter.subtitle }</h1>
			<div id="TextContent" class="read-content">
				<dt class="tp"><script>style_tp();</script></dt>
				<dt class="kw"></dt>
				<dt class="rd"><script>theme();</script></dt>
				<br> <br> <br> ${chapter.content }
			</div>
		</div>
	</div>
	<div class="bd"><script>style_bm();</script></div>
	<p class="mlfy_page">
		<a href="/foreground/toChapter?id=${preId }">上一章</a><a
			href="/foreground/toArticle?id=${chapter.articleId }" rel="nofollow">目录</a><a
			href="javascript:void(0);" onclick="addBookMark()">+书签</a><a
			href="/foreground/toChapter?id=${nextId }">下一章</a>
	</p>
	<div class="bd"></div>
	<script>
		function addBookMark(event) {
			let reader_id =
	<%=session.getAttribute("readerId")%>
		;
			console.log(reader_id);
			let chapter_id =
	<%=request.getAttribute("chapterId")%>
		;
			console.log(chapter_id);
			let url = "http://localhost:8080/foreground/addBookMark?reader_id="
					+ reader_id + "&chapter_id=" + chapter_id;
			$.ajax({
				type : "GET",
				url : url,
				success : function(result) {
					alert(result);
				},
				error : function() {
					alert("添加失败");
				}
			})
		}
	</script>
</body>

</html>