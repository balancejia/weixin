<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<c:set var="content" value="${contentMap}" />
<h1 class="title">${content.title}</h1>
<div class="meta">
	<span class="time">${content.ptime}</span>
	<span class="author">${content.origin}</span>
</div>
<article data-am-widget="paragraph"
	class="am-paragraph am-paragraph-default"
	data-am-paragraph="{tableScrollable:true,pureview:true}">
	<p class="paragraph-default-p">　　${content.summary}</p>
	<img src="${BASE}/www/upload/${content.image}">
	<p class="paragraph-default-p">　　${content.detail}</p>
</article>
