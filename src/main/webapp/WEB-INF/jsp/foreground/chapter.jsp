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
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script src="http://localhost:8080/js/jquery.cookie.js"></script>
<script>
		$(function() {
			if($.cookie("xszjsz")!=null){
				console.log($.cookie("xszjsz"));
				let a = $.cookie("xszjsz").split(',');
				//背景
				$("body").removeClass().addClass(a[0]);
				//字体
				$("#mlfy_main_text").removeClass().addClass(a[1]);
				//字号
				$(".mlfy_main_sz.b2 ul li .dxc").text(a[2]);
				$("#mlfy_main_text").css("font-size", a[2]+"px");
				//页面宽度
				$(".bar,.mlfy_main,.mlfy_add,.mlfy_page").css("width", a[3]+"px");
				$(".kdc").text(a[3]);
			}
			$(".szk").click(function(){
				$(".mlfy_main_sz").addClass("hover");
				$(this).addClass("hover");
			});
			$(".close").click(function(){
				$(".mlfy_main_sz").removeClass("hover");
				$(".szk").removeClass("hover");
			});
			$(".mlfy_main_sz ul li:first").children("i").click(function(){
				$(this).addClass("hover").siblings().removeClass("hover");
				var a = $(this).index();
				var bga = "bg"+a;
				$("body").removeClass().addClass(bga);
			});
			$(".mlfy_main_sz ul li:eq(1)").children("span.zt").click(function(){
				$(this).addClass("hover").siblings().removeClass("hover");
				var a = $(this).index();
				var zta = "zt"+a;
				$("#mlfy_main_text").removeClass().addClass(zta);
			}); 
			$(".mlfy_main_sz ul li:eq(2)").children("span:eq(1)").click(function(){
				var a = parseInt($(".mlfy_main_sz.b2 ul li .dxc").text());
				a > 12 && (a -= 2, $(".mlfy_main_sz.b2 ul li .dxc").text(a), $("#mlfy_main_text").css("font-size", a))
			});
			$(".mlfy_main_sz ul li:eq(2)").children("span:eq(3)").click(function(){
				var a = parseInt($(".mlfy_main_sz.b2 ul li .dxc").text());
				  48 > a && (a += 2, $(".mlfy_main_sz.b2 ul li .dxc").text(a), $("#mlfy_main_text").css("font-size", a))
			});
			$(".mlfy_main_sz ul li:eq(3)").children(".kdl").click(function(){
				var a = parseInt($(".mlfy_main_sz.b2 ul li .kdc").text());
				var e;
				var de;
				switch(a){
				case 640:
					de=640;
					break;
				case 800:
					de=640;
					break;
				case 990:
					de=800;
					break
				case 1200:
					de=990;
					break
				case 1400:
					de=1200;
					break;
				}
				$(".bar,.mlfy_main,.mlfy_add,.mlfy_page").css("width",de+"px");
				$(".kdc").text(de);
			});
			$(".mlfy_main_sz ul li:eq(3)").children(".kdr").click(function(){
				var a = parseInt($(".mlfy_main_sz.b2 ul li .kdc").text());
				var e;
				var de;
				switch(a){
				case 640:
					de=800;
					break;
				case 800:
					de=990;
					break;
				case 990:
					de=1200;
					break
				case 1200:
					de=1400;
					break
				case 1400:
					de=1400;
					break
				}
				$(".bar,.mlfy_main,.mlfy_add,.mlfy_page").css("width",de+"px");
				$(".kdc").text(de)
			})
			$(".mlfy_main_sz .btn-wrap .red-btn").click(function(){
				$.cookie("xszjsz", null, {
				    expires: 7,
				    path: "http://localhost:8080/foreground/toChapter"
				});
				var a = [];
				a.push($("body").attr("class")), a.push($("#mlfy_main_text").attr("class")), a.push($(".mlfy_main_sz.b2 ul li .dxc").text()), a.push($(".mlfy_main_sz.b2 ul li .kdc").text()), a.push($("#zd_bg").attr("class")), 
				$.cookie("xszjsz", a.join(","), {
				   expires: 7,
				   path: "http://localhost:8080/foreground/toChapter"
				 })
			});
			$(".mlfy_main_sz .btn-wrap .grey-btn").click(function(){
				$("body").removeClass().addClass("bg6");
				$(".mlfy_main_sz.b2 ul li i").eq(0).addClass("hover").siblings().removeClass("hover");
				$(".mlfy_main_sz.b2 ul li .zt").eq(0).addClass("hover").siblings().removeClass("hover");
				$("#mlfy_main_text").removeClass();
				$(".mlfy_main_sz.b2 ul li .dxc").text("20");
				$("#mlfy_main_text").css("font-size", "20px");
				$(".bar,.mlfy_main,.mlfy_add,.mlfy_page").css("width", "990px");
				$(".kdc").text("990");
			});
				
		});
	</script>
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
									class="putk"> <input type="submit" name="submit"
									class="logint" value="登录">&nbsp;&nbsp;<a
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
	</div>
	<div class="mlfy_main">
		<div class="container">
			<ul class="links">
				<li><a href="javascript:void(0);" onclick="addBookMark()">标记书签</a>
					|</li>
				<li><a href="/foreground/bookmark?reader_id=${reader.id }">阅读记录</a></li>
			</ul>
			<div class="mlfy_main_l">
				<i class="szk"><em class="icon-home3"></em> <z>阅读</z>设置</i> <i
					class="hid">（推荐配合 快捷键[F11] 进入全屏沉浸式阅读）</i>
			</div>
		</div>
		<div class="mlfy_main_sz b2" style="margin-left: -485px;">
			<p class="ml">
				<span class="txt">设置</span><span class="close">X</span>
			</p>
			<ul>
				<li><span class="fl">阅读主题</span><i class="c1 hover"></i><i
					class="c2"></i><i class="c3"></i><i class="c4"></i><i class="c5"></i><i
					class="c6"></i><i class="c7"></i><i class="c8"></i></li>
				<li class="hid"><span class="fl">正文字体</span><span
					class="zt hover">雅黑</span><span class="zt">宋体</span><span
					class="zt">楷体</span><span class="zt" title="方正启体简体">细明</span><span
					class="zt" title="思源黑体 CN">黑体</span><span class="zt" title="苹方字体">正黑</span></li>
				<li><span class="fl">字体大小</span><span class="dx dxl">A-</span><span
					class="dx dxc">20</span><span class="dx dxr">A+</span></li>
				<li class="hid"><span class="fl">页面宽度</span>
				<p class="dx kdl">
						<span class="icon"></span><span class="fl">-</span>
					</p>
					<p class="dx kdc">990</p>
					<p class="dx kdr">
						<span class="icon"></span><span class="fl">+</span>
					</p></li>
			</ul>
			<div class="btn-wrap">
				<a class="red-btn" href="javascript:">保存</a>
				<a class="grey-btn" href="javascript:">恢复默认</a>
			</div>
		</div>
		<div id="mlfy_main_text">
			<h1>${chapter.subtitle }</h1>
			<div id="TextContent" class="read-content">
				<br> <br> <br> ${chapter.content }
			</div>
		</div>
	</div>
	<p class="mlfy_page">
		<a href="/foreground/toChapter?id=${preId }">上一章</a>
		<a href="/foreground/toArticle?id=${chapter.articleId }" rel="nofollow">目录</a>
		<a href="javascript:void(0);" onclick="addBookMark()">+书签</a>
		<a id="nextChapter" href="/foreground/toChapter?id=${nextId }">下一章</a>
	</p>
	<div class="bd"></div>
	<script>
		function addBookMark(event) {
			let reader_id =
	<%=session.getAttribute("readerId")%>
		;
			let chapter_id =
	<%=request.getAttribute("chapterId")%>
		;
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