<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div
	style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">阅读记录</div>
<div class="r_2">
	<div id="history">
		<ul>
			<c:forEach items="${chapterList }" var="chapter">
				<li class="bookone"><div class="bcimg">
						<a href="/foreground/toArticle?id=${chapter.articleId }"
							" target="_blank"><img src="${chapter.articleImage }"
							style="display: inline;" width="48" height="69"></a>
					</div>
					<div class="bcinfo">
						<div class="casename" style="line-height: 35px;">
							书名：<a href="/foreground/toArticle?id=${chapter.articleId }"
								target="_blank">${chapter.articleTitle }</a>
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