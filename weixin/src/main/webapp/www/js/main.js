$(function() {
	$('.jhl-executor').removeClass('jhl-active');

	var first = $('.jhl-executor').first();
	$(first).addClass('jhl-active');
	var firstUrl = $(first).children().first().attr('url-val');

	get2Content(firstUrl);
	$('.jhl-executor').click(function() {
		$('.jhl-executor').removeClass('jhl-active');
		$(this).addClass('jhl-active');
		var url = $(this).children().first().attr('url-val');
		get2Content(url);
	});

	$('.jhl-sub-executor').click(function() {
		$('.jhl-executor').removeClass('jhl-active');
		$('.jhl-sub-executor').removeClass('am-active');
		$(this).addClass('am-active');
		var url = $(this).children().first().attr('url-val');
		// $(this).parent().css('display','none');
		get2Content(url);
	});

});

function get2Content(url) {
	console.log(url);
	$.ajax({
		url : url,
		async : false,
		dataType : 'html',
		success : function(data) {
			$('#2content').html(data);
		}
	});
}

function content(obj) {

	var url = $(obj).attr("data-url");
	var title = $(obj).attr("data-title");

	// alert(url+"<p>"+title);
	var contentView = $("#modal-contentView");
	contentView.find(".am-popup-title").text(title);
	contentView.find(".am-popup-bd").text("");
	contentView.find(".am-popup-bd").load(url);
	contentView.modal("open");
}

function popList(obj) {
	var url = $(obj).attr("data-url");
	var title = $(obj).attr("data-title");

	// alert(url+"<p>"+title);
	var listView = $("#modal-listView");
	listView.find(".am-popup-title").text(title);
	$("#table-list").text("");
	$("#table-list").load(url);
	listView.modal("open");
}

function popSubContent(obj) {
	var url = $(obj).attr("data-url");
	var title = $(obj).attr("data-title");

	// alert(url+"<p>"+title);
	var contentView = $("#modal-subContentView");
	contentView.find(".am-popup-title").text(title);
	contentView.find(".am-popup-bd").text("");
	contentView.find(".am-popup-bd").load(url);
	contentView.modal("open");
}



function more(url) {
	$.ajax({
		beforeSend : function() {
			return true;
		},
		complete : function() {
			return true;
		},
		url : url,
		dataType : "html",
		type : "POST",
		cache : false,
		async : true,
		success : function(html) {
			var container = $('#table-list');
			container.append(html);
			$('#table-script').remove();
		}
	});
}
