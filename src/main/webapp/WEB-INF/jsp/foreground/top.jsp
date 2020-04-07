<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="top">
		<div class="bar">
			<span class="loginSide">欢迎使用</span>
			<c:set var="username" value="${reader.username}"/>
			<c:choose>
			<c:when test="${empty username}">
			 <ul id="ul1">
				<form name="frmlogin" method="post" action="/foreground/login">
					<input type="text" name="username" placeholder="帐号" class="putk">&nbsp;&nbsp;
					<input type="password" name="password" placeholder="密码" class="putk">
					<input type="submit" name="submit" class="logint" value="登录">&nbsp;&nbsp;
					<a href="/foreground/toRegister">注册</a> 
					<input type="hidden" name="action" value="login">
				</form>
			</c:when>
			<c:otherwise>
			</ul> 
			 <ul id="ul2">
				<font color="coral">${reader.username }</font>｜
				<a href="/foreground/reader">个人中心</a>｜
				<a href="/foreground/bookshelf?reader_id=${reader.id }">我的书架</a>｜
				<a href="/foreground/bookmark?reader_id=${reader.id }">阅读记录</a>｜
				<a href="/foreground/logout" target="self">退出</a>
			</ul>
			</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div id="header">
		<div class="wrap980">
			<div class="logo">
				<a href="#"><h1>布克小说</h1></a>
			</div>
			<div class="search">
				<form id="search" name="t_frmsearch" method="get"
					action="/foreground/toSearch">
					<span class="searchBox"><input name="searchKey" type="text" value="书名｜作者名"
						onblur="if(this.value==''){this.value= '书名｜作者名';}"
						onfocus="if(this.value=='书名｜作者名'){this.value='';}"></span>
					<button type="submit" class="serBtn">搜索</button>
				</form>
				<div class="hot">热搜：
					<c:forEach items="${hotSearch }" var="article">
					<a href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a>
					</c:forEach>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="nav">
			<ul>
				<li><a id="shouye" href="/foreground/toIndex">首页</a></li>
				<li><a id="sort1" href="/foreground/toCategory?categoryId=1">玄幻奇幻</a></li>
				<li><a id="sort2" href="/foreground/toCategory?categoryId=2">言情浪漫</a></li>
				<li><a id="sort3" href="/foreground/toCategory?categoryId=3">青春校园</a></li>
				<li><a id="sort4" href="/foreground/toCategory?categoryId=4">武侠仙侠</a></li>
				<li><a id="sort5" href="/foreground/toCategory?categoryId=5">文学名著</a></li>
				<li><a id="sort6" href="/foreground/toCategory?categoryId=6">历史军事</a></li>
				<li><a id="sort7" href="/foreground/toCategory?categoryId=7">人文社科</a></li>
				<li><a id="bookall" href="/foreground/toStack">书库</a></li>
			</ul>
		</div>
	</div>
</body>
</html>