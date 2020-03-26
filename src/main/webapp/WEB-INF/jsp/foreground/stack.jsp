<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>布克小说书库</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/book.css?0901" media='all' />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<div class="clearfix"></div>
	<div id="main">
		<div class="listlie">
			<h2>${categoryName1 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList1}" var="article">
				<li><span class="zilei">[${categoryName1 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="listlie">
			<h2>${categoryName2 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList2}" var="article">
				<li><span class="zilei">[${categoryName2 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="listlie">
			<h2>${categoryName3 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList3}" var="article">
				<li><span class="zilei">[${categoryName4 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="listlie">
			<h2>${categoryName4 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList4}" var="article">
				<li><span class="zilei">[${categoryName4 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="listlie">
			<h2>${categoryName5 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList5}" var="article">
				<li><span class="zilei">[${categoryName5 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="listlie">
			<h2>${categoryName6 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList6}" var="article">
				<li><span class="zilei">[${categoryName6 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="listlie">
			<h2>${categoryName7 }小说｜全部图书</h2>
			<ul>
				<c:forEach items="${articleList7}" var="article">
				<li><span class="zilei">[${categoryName7 }]</span><a
					href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a><span
					class="zz">${article.author }</span></li>
				</c:forEach>
			</ul>
		</div>
	</div> 
	<div id="footer">
		<ul class="loginbottom">
		</ul>
		<p class="copyright">布克小说网</p>
	</div>
</body>
</html>