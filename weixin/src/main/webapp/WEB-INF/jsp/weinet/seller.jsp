<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<c:set var="content" value="${contentMap}" />

<div class="am-text-center">
	<img src="${BASE}/www/upload/${content.image}" style="max-width:100%">
</div>
<hr>
<div class="am-list-news-hd am-cf">
	<a href="###" class="">
		<h2>${content.title}</h2>
	</a>
</div>
<p>${content.address}</p>
<hr>
<p>${content.phone}</p>
<hr>
<p>${content.summary}</p>
<hr>
<p>${content.detail}</p>
