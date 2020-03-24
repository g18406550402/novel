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
					<li class="user_on"><a href="/user.php">个人中心 ></a></li>
					<li><a href="/bookcase.php">我的书架 ></a></li>
					<li><a href="/history.php">阅读记录 ></a></li>
					<li><a
						href="https://www.x23qb.com/modules/article/applywriter.php">作家申请</a></li>
				</ul>
			</div>
			<div class="user_right">
				<div
					style="background: #F7F7F7; padding: 8px 0px; font-size: 14px; text-align: center; font-weight: bold; border-bottom: 1px solid #E6E6E6;">个人中心</div>
				<div class="r_2">
					<table class="grid" width="100%" align="center"
						style="line-height: 20px;">
						<tr align="left">
							<th class="odd" width="25%">用户名：</th>
							<td class="even" width="35%">不如相忘 <a href="/useredit.php"
								style="color: #208181">修改资料</a></td>
						</tr>
						<tr align="left">
							<th class="odd">Email：</th>
							<td class="even"><a
								href="/cdn-cgi/l/email-protection#fecdcdcec9c7c6c7cec6c7becfc8cdd09d9193"><span
									class="__cf_email__"
									data-cfemail="aa99999a9d9392939a9293ea9b9c9984c9c5c7">[email&#160;protected]</span></a></td>
						<tr align="left">
							<th class="odd">注册日期：</th>
							<td colspan="2" class="even">2020-03-01</td>
						</tr>
					</table>
					<br>
				</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="footer">
		<ul class="loginbottom">
		</ul>
		<p class="copyright">布克小说网</p>
	</div>
	<script type="text/javascript" src="/skin/transform.js"></script>
</body>
</html>