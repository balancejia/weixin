<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>朔州资讯</title>
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp">
<link rel="icon" type="image/png" href="i/favicon.png">
<link rel="manifest" href="manifest.json">
<meta name="mobile-web-app-capable" content="yes">
<meta name="application-name" content="Web Starter Kit">
<link rel="icon" sizes="192x192"
	href="i/touch/chrome-touch-icon-192x192.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title"
	content="Amaze UI Sfavicon.pngtarter Kit">
<link rel="apple-touch-icon" href="i/touch/apple-touch-icon.png">
<meta name="msapplication-TileImage"
	content="i/touch/ms-touch-icon-144x144-precomposed.png">
<meta name="msapplication-TileColor" content="#0e90d2">
<link rel="stylesheet" href="${BASE}/www/css/amazeui.min.css" />
<link rel="stylesheet" href="${BASE}/www/css/main.css" />
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-one">
		<div class="am-header-left am-header-nav">
			<img class="am-header-icon-custom" style="height: auto;"
				src="${BASE}/www/html/i/logo.jpg">
		</div>
		<h4 class="am-header-title" style="font-size: 12px; color: #fcc000">朔州百姓生活服务好帮手！</h4>
		<div class="am-header-right am-header-nav">
			<a href="#search-link"><i class="am-header-icon am-icon-search"></i></a>
		</div>
	</header>
	<div class="content">
		<div data-am-widget="slider" class="am-slider am-slider-c2"
			data-am-slider='{"directionNav":false}'>
			<ul class="am-slides">
				<c:forEach var="content" items="${actContents}">
					<li onclick="javascript:content(this);" onmousemove=""
						data-toggle="modalhelper" data-title="活动详情"
						data-url="${BASE}/content/detail/${content.id}"><img
						src="${BASE}/www/upload/${content.image}"
						style="max-width: 500px; max-height: 300px">
						<div class="am-slider-desc">${content.summary}</div></li>
				</c:forEach>
			</ul>
		</div>
		<ul class="jhl-nav am-nav-pills jhl-nav-justify">
			<c:forEach var="menuBean" items="${menuList1}">
				<c:set var="menu" value="${menuBean.menu}" />
				<c:choose>
					<c:when test="${menu.isLeaf=='0'&&menu.submenuStyle=='0'}">
						<li class="am-dropdown" data-am-dropdown><a
							class="am-dropdown-toggle" data-am-dropdown-toggle
							href="javascript:void(0);"> ${menu.name}<span
								class="am-icon-caret-down"></span>
						</a>
							<ul class="am-dropdown-content">
								<c:forEach var="subMenu" items="${menuBean.subMenuList}">
									<li class="jhl-sub-executor"><a href="javascript:void(0);"
										url-val="${BASE}/menu/list/${subMenu.id}">${subMenu.name}</a></li>
								</c:forEach>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="jhl-executor"><c:choose>
								<c:when test="${menu.isLeaf=='1'}">
									<c:set var="path" value="list" />
								</c:when>
								<c:otherwise>
									<c:set var="path" value="submenu" />
								</c:otherwise>
							</c:choose> <a href="javascript:void(0);"
							url-val="${BASE}/menu/${path}/${menu.id}"> ${menu.name} </a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		<ul class="jhl-nav am-nav-pills jhl-nav-justify">
			<c:forEach var="menuBean" items="${menuList2}">
				<c:set var="menu" value="${menuBean.menu}" />
				<c:choose>
					<c:when test="${menu.isLeaf=='0'&&menu.submenuStyle=='0'}">
						<li class="am-dropdown" data-am-dropdown><a
							class="am-dropdown-toggle" data-am-dropdown-toggle
							href="javascript:void(0);"> ${menu.name}<span
								class="am-icon-caret-down"></span>
						</a>
							<ul class="am-dropdown-content">
								<c:forEach var="subMenu" items="${menuBean.subMenuList}">
									<li class="jhl-sub-executor"><a href="javascript:void(0);"
										url-val="${BASE}/menu/list/${subMenu.id}">${subMenu.name}</a></li>
								</c:forEach>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="jhl-executor"><c:choose>
								<c:when test="${menu.isLeaf=='1'}">
									<c:set var="path" value="list" />
								</c:when>
								<c:otherwise>
									<c:set var="path" value="submenu" />
								</c:otherwise>
							</c:choose> <a href="javascript:void(0);"
							url-val="${BASE}/menu/${path}/${menu.id}"> ${menu.name}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		<hr data-am-widget="divider" class="am-divider am-divider-dotted">
		<div id="2content">
			<div id="gc" style="display: none;"></div>
		</div>
	</div>
	<div class="am-popup" id="modal-contentView" style="display: none;">
		<div class="am-popup-inner">
			<div class="am-popup-hd">
				<h4 class="am-popup-title"></h4>
				<span data-am-modal-close="" class="am-close">×</span>
			</div>
			<div class="am-popup-bd"></div>
		</div>
	</div>
	<div class="am-popup" id="modal-listView" style="display: none;">
		<div class="am-popup-inner">
			<div class="am-popup-hd">
				<h4 class="am-popup-title"></h4>
				<span data-am-modal-close="" class="am-close">×</span>
			</div>
			<div class="am-popup-bd">
				<table class="am-table">
					<thead>
						<tr>
							<th>名称</th>
							<th>电话</th>
							<th>地址</th>
							<th>点击进入</th>
						</tr>
					</thead>
					<tbody id="table-list">
					</tbody>
				</table>
				 <tfoot>
					<a class="am-list-news-more am-btn am-btn-default am-text-center" style="display:none"
						href="javascript:void(0);"  id="table-list-more">查看更多
						&raquo;</a>
					<div class="am-g am-text-center" style="display:none" id="table-list-no-more">
			没有更多啦....</div>
				</tfoot>
			</div>
		</div>
	</div>
	<div class="am-popup" id="modal-subContentView" style="display: none;">
		<div class="am-popup-inner">
			<div class="am-popup-hd">
				<h4 class="am-popup-title"></h4>
				<span data-am-modal-close="" class="am-close">×</span>
			</div>
			<div class="am-popup-bd"></div>
		</div>
	</div>
	<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
		<a href="#top" title="回到顶部"><span class="am-gotop-title">回到顶部</span>
			<i class="am-gotop-icon am-icon-chevron-up"></i></a>
	</div>
	<div id="browser-info"></div>
	<script type="text/javascript"
		src="${BASE}/www/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${BASE}/www/lib/amazeui/amazeui.min.js"></script>
	<script type="text/javascript" src="${BASE}/www/js/main.js"></script>
</body>
</html>