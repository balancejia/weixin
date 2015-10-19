<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<ul class="am-avg-sm-4 am-text-center index-btns">
	<c:forEach var="menu" items="${menus}">
		<li class="am-padding-xs">
		<a href="javascript:void(0)" onclick="javascript:popList(this);" onmousemove="" data-toggle="modalhelper" data-title="${menu.name}"
		data-url="${BASE}/menu/list/${menu.id}">
				<p class="jhl-space">
					<img class="am-circle" src="${BASE}/www/upload/${menu.image}" width="80" height="80" />
				</p>
				<p class="jhl-space">
					<strong>${menu.name}</strong>
				</p>
		</a></li>
	</c:forEach>
</ul>
