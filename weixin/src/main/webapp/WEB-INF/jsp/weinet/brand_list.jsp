<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<div class="am-g">
	<c:forEach var="item" items="${list}">
		<div class="am-u-sm-6" onclick="javascript:content(this);" onmousemove=""
		data-toggle="modalhelper" data-title="品牌展示"
		data-url="${BASE}/content/detail/${item.id}">
				<img src="${BASE}/www/upload/${item.image}" style="box-sizing: border-box;max-width: 100%;max-height: 100%;vertical-align: middle;border: 0;">
		</div>
	</c:forEach>
</div>
<%@ include file="next.jsp"%>
