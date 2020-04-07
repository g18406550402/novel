<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>我的书架_布克小说</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/book.css?1201" media='all' />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<div id="main">
		<div class="user_all">
			<div class="user_left">
				<ul>
					<li><a href="/foreground/reader">个人中心 ></a></li>
					<li class="user_on"><a href="/foreground/bookshelf?reader_id=${reader.id }">我的书架 ></a></li>
					<li><a href="/foreground/bookmark?reader_id=${reader.id }">阅读记录 ></a></li>
				</ul>
			</div>
			<div class="user_right">
				<div
					style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">我的书架</div>
				<div class="r_2">
					<div class="casenote">您的书架已收藏 ${reader.getArticles().size() } 本图书</div>
					<c:forEach items="${articleList }" var="article">
					<ul>
						<li class="bookone">
							<div class="bcimg">
								<a href="/book/9132/" target="_blank"><img
									src="${article.image }" alt="${article.title }"
									height="69" width="48"></a>
							</div>
							<div class="bcinfo">
								<div class="casename">
									书名：<a href="/foreground/toArticle?id=${article.id }" target="_blank">${article.title }</a>
								</div>
								<div class="upcase">
									类型：<a href="/foreground/toCategory?categoryId=${article.categoryId }" target="_blank">${article.categoryName }
									</a>
								</div>
								<div class="upcase">
									最新：<a href="/foreground/toChapter/${article.latestChapterId }" target="_blank">${article.latestChapterName}
									</a>
								</div>
								<div class="casedel">
									<a><i value="${article.id }" class="removeFromBookShelf">移除</i></a>
								</div>
							</div>
						</li>
					</ul>
					</c:forEach>
				</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<script>
		$(function(){
			console.log($(".user_on a"));
			$(".removeFromBookShelf").click(function(){
				let articleId = $(this).attr("value");
				let readerId = <%=session.getAttribute("readerId")%>;
				let url = "http://localhost:8080/foreground/removeFromBookShelf?readerId="+readerId+"&articleId="+articleId;
				let url1="http://localhost:8080/foreground/toMyBookshelf?reader_id="+readerId;
				$.get(url,function(data){
					console.log(data);
				})
				$(".user_right").load(url1);
			})
		})
	</script>
	
	<div id="footer">
		<p class="copyright">布克小说网</p>
	</div>
</body>
</html>