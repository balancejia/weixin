jQuery(function($) {

	var $myTree = $('#myTreeSelectableFolder');
	$myTree.tree({
		dataSource : function(options, callback) {

			var urlVal = BASE + "/menu/root";
			if (options.attr && options.attr.id) {
				console.log(options.attr.id);
				urlVal = BASE + "/menu/submenu/json/" + options.attr.id;
			}

			$.ajax({
				url : urlVal,
				async : false,
				dataType : 'json',
				success : function(result) {
					var _data = $.parseJSON(result.data);
					callback({
						data : _data
					});
				}
			});
		},
		cacheItems : true,
		folderSelect : false,
		multiSelect : false
	}).on('selected.tree.amui', function(e, selected) {
		console.log('Select Event: ', selected);
		console.log($myTree.tree('selectedItems'));
		contentList($myTree.tree('selectedItems')[0].attr.id,$myTree.tree('selectedItems')[0].attr.templetId,1);
	});
});

function contentList(menuId,templetId,pageNum) {
	$.ajax({
		url : BASE+"/content/list/"+menuId+"/"+templetId+"/"+pageNum,
		async : false,
		dataType : 'html',
		success : function(result) {
			$("#content-list").html(result);
		}
	});
}
