<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<%@ taglib prefix="security" uri="/security" %>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>朔州资讯</title>
<%@ include file="amaze-css.jsp"%>
<style>
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，管理系统 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<security:user>
		<c:redirect context="${BASE}" url="/admin" />
	</security:user>
	<div class="header">
		<div class="am-g">
			<h1>朔州资讯网后台管理系统</h1>
			<p>
				<br />
			</p>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<h3>登录</h3>
			<hr>
			<form class="am-form am-form-horizontal" id="login_form">
				<div class="am-form-group am-form-icon am-form-feedback">
					<label class="am-u-sm-2 am-form-label">用户名</label>
					<div class="am-u-sm-10">
						<input type="text" id="username" name="username" class="am-form-field ext-required"
							placeholder="输入用户名">
					</div>
					<span></span>
				</div>

				<div class="am-form-group am-form-icon am-form-feedback">
					<label class="am-u-sm-2 am-form-label">密码</label>
					<div class="am-u-sm-10">
						<input type="password" id="password" name="password"
							placeholder="输入密码" class="am-form-field ext-required">
					</div>
					<span></span>
				</div>

				<div class="am-form-group am-form-feedback">
					<label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">验证码</label>
					<div class="am-u-sm-10">
						<input type="text" id="captcha" name="captcha"
							style="width: 120px; display: inline-block;" class="am-form-field ext-required"> <img
							id="captcha_img" src="${BASE}/captcha"
							class="css-cursor-pointer ext-captcha"
							style="height: 35px; display: inline-block; margin-left: 50px;">
					</div>
				</div>

				<div class="am-form-group">
					<div class="am-u-sm-10 am-u-sm-offset-2">
						<button type="submit" class="am-btn am-btn-primary">登录</button>
					</div>
				</div>
			</form>
			<hr>
			<p>© 2015 balanceJia</p>
		</div>
	</div>
	<%@ include file="amaze-js.jsp"%>
	<script type="text/javascript" src="${BASE}/www/js/login.js"></script>
</body>
</html>