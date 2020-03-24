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
					<li class="user_on"><a href="/bookcase.php">我的书架 ></a></li>
					<li><a href="/history.php">阅读记录 ></a></li>
				</ul>
			</div>
			<div class="user_right">
				<div
					style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">我的书架</div>
				<div class="r_2">
					<div class="casenote">您的书架已收藏 2 本图书</div>
					<ul>
						<li class="bookone">
							<div class="bcimg">
								<a href="/book/9132/" target="_blank"><img
									src="/files/article/image/9/9132/9132s.jpg" alt="诡秘之主"
									height="69" width="48"></a>
							</div>
							<div class="bcinfo">
								<div class="casename">
									书名：<a href="/book/9132/" target="_blank">诡秘之主</a>
								</div>
								<div class="upcase">
									更新：<a href="/book/9132/72706277.html" target="_blank">第六十四章
										入住 <span style="color: red;">(新)</span>
									</a>
								</div>
								<div>
									书签：<a href="/book/9132/5380876.html" target="_blank">第二章 情况</a>
								</div>
								<div class="casedel">
									<a
										href="javascript:if(confirm('确定要将本书移出书架么？')) document.location='/modules/article/bookcase.php?delid=585186';">移除</a>
								</div>
							</div>
						</li>
					</ul>
					<ul>
						<li class="bookone">
							<div class="bcimg">
								<a href="/book/180813/" target="_blank"><img
									_src="/files/article/image/180/180813/180813s.jpg" alt="史上第一密探"
									height="69" width="48"></a>
							</div>
							<div class="bcinfo">
								<div class="casename">
									书名：<a href="/book/180813/" target="_blank">史上第一密探</a>
								</div>
								<div class="upcase">
									更新：<a href="/book/180813/72704141.html" target="_blank">第267章:皇帝之天诛!云中鹤归来!
										<span style="color: red;">(新)</span>
									</a>
								</div>
								<div>
									书签：<a href="#" target="_blank"></a>
								</div>
								<div class="casedel">
									<a
										href="javascript:if(confirm('确定要将本书移出书架么？')) document.location='/modules/article/bookcase.php?delid=585179';">移除</a>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="footer">
		<ul class="loginbottom">
			<script>
				login();
			</script>
		</ul>
		<p class="copyright">铅笔小说网</p>
	</div>
	<script type="text/javascript" src="/skin/transform.js"></script>
</body>
</html>