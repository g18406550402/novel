<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="top">
		<div class="bar">
			<span class="loginSide">欢迎使用</span>
			 <ul id="ul1">
				<form name="frmlogin" method="post" action="/login.php?do=submit">
					<input type="text" name="username" placeholder="帐号" class="putk">&nbsp;&nbsp;<input
						type="password" name="password" placeholder="密码" class="putk">
					<input type="submit" name="submit" class="logint" value="登录">&nbsp;&nbsp;<a
						href="/register.php">注册</a> <input type="hidden" name="action"
						value="login">
				</form>
			</ul> 
			 <ul id="ul2">
				<font color="coral">不如相忘</font>｜
				<a href="/user.php">个人中心</a>｜
				<a href="/bookcase.php">我的书架</a>｜
				<a href="/history.php">阅读记录</a>｜
				<a href="/logout.php" target="self">退出</a>
			</ul>
<script>
	let readerName=${reader.name};
	console.log(readerName);
	if (readerName != null||readerName!="") {
	document.getElementById("ul1").style.display = "none";
	document.getElementById("ul2").style.display = "block";}
	else{document.getElementById("ul1").style.display = "block";
	document.getElementById("ul2").style.display = "none";}
</script>
		</div>
	</div>
	<div id="header">
		<div class="wrap980">
			<div class="logo">
				<a href="#"><h1>铅笔小说</h1></a>
			</div>
			<div class="search">
				<form id="search" name="t_frmsearch" method="post"
					action="/search.php">
					<span class="searchBox"><input name="searchkey" type="text"
						onblur="if(this.value==''){this.value= '书名｜作者名';}"
						onfocus="if(this.value=='书名｜作者名'){this.value='';}"></span>
					<button type="submit" class="serBtn">搜索</button>
				</form>
				<div class="hot">
					热搜：<a href="http://localhost:8080/article.html?id=1/"
						target="_blank">斗破苍穹</a><a
						href="http://localhost:8080/article.html?id=2/" target="_blank">斗罗大陆</a><a
						href="http://localhost:8080/article.html?id=3/" target="_blank">凡人修仙传</a><a
						href="http://localhost:8080/article.html?id=4/" target="_blank">九州缥缈录</a><a
						href="http://localhost:8080/article.html?id=5/" target="_blank">一念永恒</a>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="nav">
			<ul>
				<li><a id="shouye" href="/">首页</a></li>
				<li><a id="sort1" href="/yanqing/">玄幻奇幻</a></li>
				<li><a id="sort2" href="/xuanhuan/">言情浪漫</a></li>
				<li><a id="sort3" href="/dushi/">青春校园</a></li>
				<li><a id="sort4" href="/wuxia/">武侠仙侠</a></li>
				<li><a id="sort5" href="/danmei/">文学名著</a></li>
				<li><a id="sort6" href="/kehuan/">历史军事</a></li>
				<li><a id="sort7" href="/lightnovel/">人文社科</a></li>
				<li><a id="bookall" href="/book/">书库</a></li>
			</ul>
		</div>
	</div>
</body>
</html>