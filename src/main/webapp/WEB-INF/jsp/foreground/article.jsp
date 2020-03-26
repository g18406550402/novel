<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${articl.title }在线阅读</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/book.css?1201" media='all' />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<div id="main">
		<div id="maininfo">
			<div class="coverecom w_770 left">
				<div class="tabstit">
					<span class="label"></span><a href="/foreground/index">布克小说</a><i>＞</i><a
						href="/foreground/toCategory?categoryId=${categoryId }">${article.categoryName }</a><em>＞</em><em>${article.title }</em>
				</div>
				<img src="${article.image }" class="book-cover-blur hide"
					alt="${article.title }">
				<div id="bookinfo">
					<div class="bookleft">
						<div id="bookimg">
							<img alt="${article.title }" src="${article.image }" width="152"
								height="195" />
						</div>
					</div>
					<div class="bookright">
						<div class="d_title">
							<h1>${article.title }</h1>
							<span class="p_author">作者：<a
								href="/foreground/toSearch?searchKey=${article.author }"
								target="_blank">${article.author }</a></span>
						</div>
						<div id="count">
							<ul>
								<li><strong>分类：</strong><span>${article.categoryName }</span></li>
								<li><strong>字数：</strong><span>${article.words } 万</span></li>
								<li><strong>状态：</strong><span>${article.state }</span></li>
								<li id="uptime"><strong>更新：</strong><span>${article.updateDate }</span></li>
							</ul>
						</div>
						<div style="clear: both"></div>
						<div id="bookintro" class="hm-scroll">${article.intro}</div>
						<div style="clear: both"></div>
					</div>
					<div id="button_all">
						<ul>
							<li class="b1"><a rel="nofollow" href="/foreground/toChapter?id=${chapterList[1].id }">全文阅读</a></li>
							<li class="b2"><a href="javascript:void(0);" onclick="addToBookShelf()">放入书架</a></li>
						</ul>
						<div style="clear: both"></div>
					</div>
				</div>
			</div>
		</div>
		<script>
		function addToBookShelf(event){
			let reader_id = <%=session.getAttribute("readerId")%>;
			console.log(reader_id);
			let article_id = <%=request.getAttribute("articleId")%>;
			console.log(article_id);
			let url="http://localhost:8080/foreground/addToBookShelf?reader_id="+reader_id+"&article_id="+article_id;
			$.ajax({
				type:"GET",
				url:url,
				success:function(result){
					alert(result);
					console.log(result);
				},
				error:function(){
	                consoel.log("failed");
	            }
			})
		}
		</script>
		<div class="list_center w_200 right">
			<div class="update_title">
				<span class="update_icon">新书推荐</span>
			</div>
			<div class="hotlist">
				<ul>
					<li><strong>唐颖小</strong><span>[言情]</span><a
						href="/foreground/toArticle?id=8">城府</a></li>
					<li><strong>北枝寒</strong><span>[言情]</span><a
						href="/foreground/toArticle?id=9">鬼医毒妾</a></li>
					<li><strong>施定柔</strong><span>[言情]</span><a
						href="/foreground/toArticle?id=10">结爱·异客逢欢</a></li>
					<li><strong>墨宝非宝</strong><span>[言情]</span><a
						href="/foreground/toArticle?id=11">密室困游鱼</a></li>
					<li><strong>梅子黄时雨</strong><span>[言情]</span><a
						href="/foreground/toArticle?id=14">有生之年，狭路相逢</a></li>
					<li><strong>缪娟</strong><span>[青春]</span><a
						href="/foreground/toArticle?id=15">翻译官</a></li>
					<li><strong>明前雨后</strong><span>[青春]</span><a
						href="/foreground/toArticle?id=16">忽而今夏</a></li>
					<li><strong>郭敬明</strong><span>[青春]</span><a
						href="/foreground/toArticle?id=17">爵迹·风津道</a></li>
					<li><strong>八月长安</strong><span>[青春]</span><a
						href="/foreground/toArticle?id=19">你好，旧时光</a></li>
					<li><strong>八月长安</strong><span>[青春]</span><a
						href="/foreground/toArticle?id=">这么多年</a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="newlist">
			<div class="newrap">
				<h2>${article.title}最新章节</h2>
			</div>
			<ul class="chaw">
				 <c:forEach items="${updateList}" var="chapter">
				<li><a href="/foreground/toChapter?id=${chapter.id }">${chapter.subtitle}</a></li>
				</c:forEach> 
			</ul>
			<div class="newrap_c">
				<h2>${article.title}全文阅读</h2>
				<span onclick="#">倒序 ↑</span>
			</div>
			<ul class="chaw_c" id="chapterList">
				<c:forEach items="${chapterList }" var="chapter">
				<li><a href="/foreground/toChapter?id=${chapter.id }">${chapter.subtitle }</a></li>
				</c:forEach>
			</ul>
		</div>
		<i class="lbxxyx_s">章节目录</i>
	</div>
	<div id="footer">
		<p class="copyright">布克小说网</p>
	</div>
	
</body>

</html>