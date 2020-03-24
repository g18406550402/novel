<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/book.css?1201" media='all' />
</head>
<body>
	<%@ include file="top.jsp"%>

	<div id="main">
		<div class="user_all">
			<div class="user_left">
				<ul>
					<li><a href="/user.php">个人中心 ></a></li>
					<li><a href="/bookcase.php">我的书架 ></a></li>
					<li class="user_on"><a href="/history.php">阅读记录 ></a></li>
				</ul>
			</div>
			<div class="user_right">
				<div
					style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">阅读记录</div>
				<div class="r_2">
					<div id="history">
						<ul>
						<li class="bookone"><div class="bcimg">
								<a href="/book/186625/" target="_blank"><img
									src="/files/article/image/186/186625/186625s.jpg"
									src="/files/article/image/186/186625/186625s.jpg"
									style="display: inline;" width="48" height="69"></a>
							</div>
							<div class="bcinfo">
								<div class="casename" style="line-height: 35px;">
									书名：<a href="/book/186625/" target="_blank">从火影开始掌控时间</a>
								</div>
								<div class="upcase" style="height: 36px;">
									记录：<a href="/book/186625/72699053.html" target="_blank">第二百七十二章
										一剑天地分裂【4/7】</a>
								</div>
								<div class="casedel">
									<a href="javascript:removebook('186625')">移除</a>
								</div>
							</div></li>
						<li class="bookone"><div class="bcimg">
								<a href="/book/176505/" target="_blank"><img
									src="/files/article/image/176/176505/176505s.jpg"
									src="/files/article/image/176/176505/176505s.jpg"
									style="display: inline;" width="48" height="69"></a>
							</div>
							<div class="bcinfo">
								<div class="casename" style="line-height: 35px;">
									书名：<a href="/book/176505/" target="_blank">我师兄实在太稳健了</a>
								</div>
								<div class="upcase" style="height: 36px;">
									记录：<a href="/book/176505/72692220.html" target="_blank">第357章
										其实可以有</a>
								</div>
								<div class="casedel">
									<a href="javascript:removebook('176505')">移除</a>
								</div>
							</div>
						</li>
						</ul>
					</div>

				</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="footer">

		<p class="copyright">布克小说网</p>
	</div>
</body>
</html>