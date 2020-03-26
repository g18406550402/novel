<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>好看的${articleList[1].categoryName }小说</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>布克小说_最值得书友收藏的网络小说阅读网</title>
<meta name="description"
	content="布克小说是广大书友最值得收藏的网络小说阅读网.网站收录了许多经典的网络小说,我们的目的是分享小说,享受阅读乐趣!" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/book.css?0901" media='all' />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	
	<div class="clearfix"></div>
	<div id="main">
	<div class="list_center">
		<div class="update_title">
			<span class="update_icon">${articleList[1].categoryName }·小说列表</span>
		</div>
		<div id="sitebox">
			<c:forEach items="${articleList }" var="article">
			<dl>
				<dt>
					<a href="/foreground/toArticle?id=${article.id }"><img
						src="${article.image }"
						alt="${article.title }" height="150" width="107"></a><span>${article.categoryName }</span>
				</dt>
				<dd>
					<h3>
						<span class="uptime">${article.updateDate }</span><a
							href="/foreground/toArticle?id=${article.id }">${article.title }</a>
					</h3>
				</dd>
				<dd class="book_other">
					子类：<span>${article.categoryName }</span>状态：<span>${article.state}</span>字数：<span>${article.words}万</span>
				</dd>
				<dd class="book_des">
					${article.intro}
				</dd>
				<dd class="book_other">
					最新章节：<a href="/book/188238/72708509.html">046 要人不知，除非莫为（加更）</a>
				</dd>
			</dl>
			</c:forEach>
	</div>
	</div>
	</div>
	<div id="footer">
		<ul class="loginbottom">
		</ul>
		<p class="copyright">布克小说网</p>
	</div>
</body>
</html>