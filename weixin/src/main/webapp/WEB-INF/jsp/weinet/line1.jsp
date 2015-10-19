<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<c:forEach var="item" items="${list}">
	<div class="am-g" onclick="javascript:content(this);" onmousemove=""
		data-toggle="modalhelper" data-title="动态详情"
		data-url="${BASE}/content/detail/${item.id}">
		<div class="am-u-sm-4">
			<img class="am-thumbnail" style="margin-bottom: 0.5rem;max-width:150px;max-height:120px" src="${BASE}/www/upload/${item.image}" alt=""/>
		</div>
		<div class="am-u-sm-8">
			<div class="am-thumbnail-caption">
				<h2 class="jhl-space am-text-truncate">${item.title}</h2>
				<p class="jhl-space am-text-truncate">${item.summary}</p>
			</div>
		</div>
	</div>
	<hr data-am-widget="divider" style=""
		class="am-divider am-divider-dashed" />
</c:forEach>
<%@ include file="next.jsp"%>