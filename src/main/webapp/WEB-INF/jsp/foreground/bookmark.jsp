<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>阅读记录_布克小说</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/css/book.css?1201" media='all' />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>	
</head>
<body>
	<%@ include file="top.jsp"%>

	<div id="main">
		<div class="user_all">
			<div class="user_left">
				<ul>
					<li><a href="/foreground/reader">个人中心 ></a></li>
					<li><a href="/foreground/bookshelf?reader_id=${reader.id }">我的书架 ></a></li>
					<li class="user_on"><a href="/foreground/bookmark?reader_id=${reader.id }">阅读记录 ></a></li>
				</ul>
			</div>
			<div class="user_right">
				<div
					style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">阅读记录</div>
				<div class="r_2">
					<div id="history">
						<ul>
						<c:forEach items="${chapterList }" var="chapter">
						<li class="bookone"><div class="bcimg">
								<a href="/foreground/toArticle?id=${chapter.articleId }"" target="_blank"><img
									src="${chapter.articleImage }"
									style="display: inline;" width="48" height="69"></a>
							</div>
							<div class="bcinfo">
								<div class="casename" style="line-height: 35px;">
									书名：<a href="/foreground/toArticle?id=${chapter.articleId }" target="_blank">${chapter.articleTitle }</a>
								</div> 
								<div class="upcase" style="height: 36px;">
									记录：<a href="/book/186625/72699053.html" target="_blank">${chapter.subtitle }</a>
								</div>
								<div class="casedel">
									<a><i value="${chapter.id}" class="deleteBookMark">移除</i></a>
								</div>
							</div></li>
							</c:forEach>
						</ul>
					</div>

				</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<script>
		$(function(){
			$(".deleteBookMark").click(function(){
				let chapterId = $(this).attr("value");
				let readerId = <%=session.getAttribute("readerId")%>;
				let url = "http://localhost:8080/foreground/deleteBookMark?readerId="+readerId+"&chapterId="+chapterId;
				$.get(url,function(data){
					
				})
				let url1 = "http://localhost:8080/foreground/toMyBookmark?reader_id="+readerId;
				$(".user_right").load(url1);
			})
		})
	</script>
	<div id="footer">
		<p class="copyright">布克小说网</p>
	</div>
</body>
</html>