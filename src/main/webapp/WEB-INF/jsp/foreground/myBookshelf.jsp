<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">我的书架</div>
<div class="r_2">
	<div class="casenote">您的书架已收藏 ${reader.getArticles().size() } 本图书</div>
	<c:forEach items="${articleList }" var="article">
		<ul>
			<li class="bookone">
				<div class="bcimg">
					<a href="/book/9132/" target="_blank"><img
						src="${article.image }" alt="${article.title }" height="69"
						width="48"></a>
				</div>
				<div class="bcinfo">
					<div class="casename">
						书名：<a href="/foreground/toArticle?id=${article.id }"
							target="_blank">${article.title }</a>
					</div>
					<div class="upcase">
						类型：<a
							href="/foreground/toCategory?categoryId=${article.categoryId }"
							target="_blank">${article.categoryName } </a>
					</div>
					<div class="upcase">
						最新：<a href="/foreground/toChapter/${article.latestChapterId }"
							target="_blank">${article.latestChapterName} </a>
					</div>
					<div class="casedel">
						<a><i value="${article.id }"
							class="removeFromBookShelf">移除</i></a>
					</div>
				</div>
			</li>
		</ul>
	</c:forEach>
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