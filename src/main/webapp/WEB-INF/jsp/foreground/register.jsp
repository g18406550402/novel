<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>布克小说_最值得书友收藏的网络小说阅读网</title>
<meta name="description"
	content="布克小说是广大书友最值得收藏的网络小说阅读网.网站收录了许多经典的网络小说,我们的目的是分享小说,享受阅读乐趣!" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/css/book.css?0901" media='all' />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<div id="main">
		<style>
.loginall {
	margin-top: 10px;
	border: 1px solid #D8D8D8;
	background-color: #fff;
}

.loginall .lc {
	margin: 10px;
}

.loginall .lc td {
	padding-top: 20px;
}

.loginb {
	background-color: #75a4b4;
	padding: 5px 20px;
	color: #fff;
	border: 1px solid #5F91A2;
	border-bottom-width: 2px;
	font-weight: bold
}

.loginb:hover {
	border-bottom: 2px solid #000;
	border-right: 2px solid #000;
	color: #000;
	cursor: pointer
}
</style>
		<style>
@media screen and (max-width:768px) {
	.loginall {
		margin-top: 0px;
	}
	.loginbottom {
		display: none
	}
}
</style>
		<div class="loginall">
			<div class="lc">
				<form name="frmregister" id="frmregister"
					action="/foreground/register" method="post">
					<table class="grid" width="250" align="center">
						<tr>
							<td class="odd" width="25%">用 户 名<span class="hottext">*</span></td>
							<td class="even" style="padding-top: 10px;"><input
								type="text" class="text" name="username" id="username" size="25"
								maxlength="30" style="width: 160px" value=""
								/> 
						</tr>
						<tr>
							<td class="odd" width="25%">密 码<span class="hottext">*</span></td>
							<td class="even"><input type="password" class="text"
								name="password" id="password" size="25" maxlength="20"
								style="width: 160px" value=""
								 /> 
						</tr>
						<tr>
							<td class="odd" width="25%">重复密码<span class="hottext">*</span></td>
							<td class="even"><input type="password" class="text"
								name="repassword" id="repassword" size="25" maxlength="20"
								style="width: 160px" value=""
								 />
						</tr>
						<tr>
							<td class="odd" width="25%">Email<span class="hottext">*</span></td>
							<td class="even"><input type="text" class="text"
								name="email" id="email" size="25" maxlength="60"
								style="width: 160px" value=""
								 /> 
						</tr>
						<tr>
							<td class="odd" width="25%">&nbsp;<input type="hidden"
								name="action" id="action" value="newuser" /></td>
							<td class="even"><input type="submit" class="loginb"
								name="submit" id="submit" value="提 交 注 册" /></td>
						</tr>
					</table>
				</form>
			</div>
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