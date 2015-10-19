<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<div class="am-g">
	<c:forEach var="menu" items="${menus}">
		<div class="am-u-sm-6" onclick="javascript:popList(this);" onmousemove=""
		data-toggle="modalhelper" data-title="${menu.name}"
		data-url="${BASE}/menu/list/${menu.id}">
				<img src="${BASE}/www/upload/${menu.image}" style="box-sizing: border-box;max-width: 100%;max-height: 100%;vertical-align: middle;border: 0;">
		</div>
	</c:forEach>
</div>
