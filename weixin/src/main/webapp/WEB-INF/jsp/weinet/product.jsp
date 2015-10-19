<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<c:set var="content" value="${contentMap}" />

<div class="am-text-center">
	<img src="${BASE}/www/upload/${content.image}">
</div>
<hr>
<div class="i-title">
	<p>${content.title}</p>
	<p>
		<strong class="strong-color">￥${content.discount}</strong>&nbsp;&nbsp;<s>￥${content.price}</s>
	</p>
</div>
<hr>
<p>${content.detail}</p>
<hr>
<p>${content.detail}</p>
