<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<div style="margin: 2px auto;">
	<button class="am-btn am-btn-primary am-btn-sm" id="create-button">
		<i class="am-icon-plus"></i> 新增
	</button>
</div>
<table
	class="am-table am-table-bordered am-table-striped am-table-compact">
	<thead>
		<tr>
			<th>标题</th>
			<th>图片</th>
			<th>创建时间</th>
			<th>预览</th>
			<th>编辑</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="content" items="${list}">
			<tr>
				<td>${content.title}</td>
				<td>${content.image}</td>
				<td>${content.createTime}</td>
				<td><button type="button" class="am-btn am-btn-secondary am-btn-xs" onclick="javascript:view('${content.id}');">预览</button></td>
				<td><button type="button" class="am-btn am-btn-secondary am-btn-xs" onclick="javascript:edit('${content.id}');">编辑</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="am-btn-group">
	<button class="am-btn am-btn-primary am-btn-xs" ${preDisable}
		onclick="javascript:contentList(${menuId},${templetId},1);">
		<i class="am-icon-angle-double-left"></i>首页
	</button>
	<button class="am-btn am-btn-primary am-btn-xs" ${preDisable}
		onclick="javascript:contentList(${menuId},${templetId},${p-1});">
		<i class="am-icon-angle-left"></i>上一页
	</button>
	<button class="am-btn am-btn-primary am-btn-xs" ${nextDisable}
		onclick="javascript:contentList(${menuId},${templetId},${p+1});">
		<i class="am-icon-angle-right"></i>下一页
	</button>
	<button class="am-btn am-btn-primary am-btn-xs" ${nextDisable}
		onclick="javascript:contentList(${menuId},${templetId},${tp})">
		<i class="am-icon-angle-double-right"></i>尾页
	</button>
</div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="create-form">
	<div class="am-modal-dialog">
		<div class="am-modal-hd" style="width:100%;height:30px">
			<span id="modal-title">新增内容</span><a href="javascript: void(0)"
				class="am-close am-close-spin" data-am-modal-close id="modal-close-a">&times;</a>
		</div>
		<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
		<div class="am-modal-bd"  style="width:100%;height:535px;overflow:auto;" id="create-form-content">
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$("#create-button").on("click",function(){
		$.ajax({
			url : BASE+"/content/create/"+${templetId}+"/"+${menuId},
			async : false,
			dataType : 'html',
			success : function(result) {
				$("#create-form-content").html(result);
				$modal=$("#create-form");
				$("#modal-title").html("新建内容");
				var options={
						width:800,
						height:600,
						closeViaDimmer:false
				};
				$modal.modal(options);
			}
		});
	});

	$("#modal-close-a").click(function(){
		var $dimmer=$(".am-dimmer");
    	$dimmer.removeClass("am-active");
    	$dimmer.hide();
	});
});

function view(id){
	var urlV="${BASE}/content/detail/"+id;
	$.ajax({
		url : urlV,
		async : false,
		dataType : 'html',
		success : function(result) {
			$("#create-form-content").html(result);
			$modal=$("#create-form");
			var options={
					width:600,
					height:600,
					closeViaDimmer:false
			};

			$("#modal-title").html("预览");
			$modal.modal(options);
		}
	});
}


function edit(id){
	var urlV="${BASE}/content/edit/"+id;
	$.ajax({
		url : urlV,
		async : false,
		dataType : 'html',
		success : function(result) {
			$("#create-form-content").html(result);
			$modal=$("#create-form");
			var options={
					width:800,
					height:600,
					closeViaDimmer:false
			};

			$("#modal-title").html("编辑");
			$modal.modal(options);
		}
	});
}
</script>