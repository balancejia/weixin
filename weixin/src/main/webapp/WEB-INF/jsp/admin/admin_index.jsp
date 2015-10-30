<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<%@ include file="amaze-css.jsp"%>
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<header class="am-topbar admin-header">
		<div class="am-topbar-brand">
			<strong>朔州资讯后台管理系统</strong> <small>欢迎你！</small>
		</div>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 管理员 <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
						<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
						<li class="ext-logout"><a href="javascript:void(0);"><span
								class="am-icon-power-off"></span> 退出</a></li>
					</ul></li>
				<li class="am-hide-sm-only"><a href="javascript:;"
					id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
						<span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<ul class="am-list admin-sidebar-list">
					<li><a class="ext-admin-menu" href="javascript:void(0);"
						url-val="${BASE}/admin/index" id="index-a"><span
							class="am-icon-home"></span> 首页</a></li>
					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav-weinet'}"><span
							class="am-icon-file"></span> 微网站管理 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub am-in"
							id="collapse-nav-weinet">
							<!--<li><a class="ext-admin-menu am-cf" href="javascript:void(0);" url-val="${BASE}/content/create/4/1"><span class="am-icon-check"></span> 栏目管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>-->
							<li><a class="ext-admin-menu" href="javascript:void(0);"
								url-val="${BASE}/content/manage"><span
									class="am-icon-puzzle-piece"></span> 内容管理</a></li>
						</ul></li>
					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav-wechat'}"><span
							class="am-icon-file"></span> 公众号管理 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub am-in"
							id="collapse-nav-wechat">
							<li><a class="ext-admin-menu" href="javascript:void(0);"
								url-val="${BASE}/www/html/404.html"><span
									class="am-icon-check"></span> 粉丝管理<span
									class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
							<li><a class="ext-admin-menu" href="javascript:void(0);"
								url-val="${BASE}/www/html/404.html"><span
									class="am-icon-puzzle-piece"></span> 关键字管理</a></li>
							<li class="ext-synmenu"><a href="javascript:void(0);"><span
									class="am-icon-puzzle-piece"></span> 自定义菜单管理</a></li>
						</ul></li>
					<li class="ext-logout"><a href="javascript:void(0);"><span
							class="am-icon-sign-out"></span> 注销</a></li>
				</ul>



				<div class="am-panel"></div>
			</div>
		</div>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content" style="min-height: 560px;"
			id="admin-content"></div>
		<!-- content end -->

	</div>

	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd" id="my-modal-loading-hd">正在载入...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin" id="my-modal-loading-img"></span>
				<button type="button" class="am-btn am-btn-success" id="my-modal-loading-close">关闭</button>
			</div>
		</div>
	</div>

	<a href="#" class="am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"> <span
		class="am-icon-btn am-icon-th-list"></span>
	</a>

	<footer>
		<hr>
		<p class="am-padding-left">© 2015 balanceJia.</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="${BASE}/www/lib/jquery/jquery.min.js"></script>
	<!--<![endif]-->
	<%@ include file="amaze-js.jsp"%>
</body>
</html>
