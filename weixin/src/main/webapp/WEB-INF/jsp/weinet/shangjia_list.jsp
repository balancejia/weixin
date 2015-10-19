<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>

<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.title}</td>
		<td>${item.phone}</td>
		<td>${item.address}</td>
		<td><i class="am-icon-arrow-circle-right" onclick="javascript:popSubContent(this);" onmousemove="" data-toggle="modalhelper" data-title="详情" data-url="${BASE}/content/detail/${item.id}"></i></td>
	</tr>
</c:forEach>
<tr id="table-script" style="display:none;">
	<td></td>
	<td></td>
	<td></td>
	<td>
	<script type="text/javascript">
		if ('end' !== '${next}') {
			$("#table-list-more").css('display','block');
			$("#table-list-no-more").css('display','none');
			$("#table-list-more").attr("onclick","javascript:more('${BASE}/${next}');");
		}else{
			$("#table-list-more").css('display','none');
			$("#table-list-no-more").css('display','block');
		}
	</script>
	</td>
</tr>