<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<div class="am-g am-g-fixed">
	<c:forEach var="item" items="${list}">
		<div class="am-u-sm-6">
			<div class="am-thumbnail" onclick="javascript:content(this);" onmousemove="" data-toggle="modalhelper" data-title="促销详情" data-url="${BASE}/content/detail/${item.id}">
				<img src="${BASE}/www/upload/${item.image}" alt="" />
				<div class="am-thumbnail-caption">
					<h2 class="jhl-space">${item.title}</h2>
					<p class="jhl-space am-text-secondary">
						促销价<strong>￥${item.discount}</strong>
					</p>
					<p class="jhl-space index-cart">
						原价<s>￥${item.price}</s>
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<%@ include file="next.jsp"%>