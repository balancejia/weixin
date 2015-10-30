(function($) {
  'use strict';

  $(function() {
    var $fullText = $('.admin-fullText');
    $('#admin-fullscreen').on('click', function() {
      $.AMUI.fullscreen.toggle();
    });

    $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
      $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
    });

    $('.ext-admin-menu').on('click',function(){
    	var url=$(this).attr('url-val');
    	$.ajax({
    		url : url,
    		async : true,
    		dataType : 'html',
    		success : function(data) {
    			$('#admin-content').html(data);
    		}
    	});
    });

    // 绑定注销事件
    $('.ext-synmenu').click(function() {
    	$('#my-modal-loading-hd').html('正在向微信公众平台同步自定义菜单......');
    	$('#my-modal-loading-img').removeClass("dispaly-none");
    	$('#my-modal-loading-close').addClass("dispaly-none");
    	$('#my-modal-loading').modal();
            $.ajax({
                type: 'get',
                url: BASE + '/wechat/synmenu',
                success: function(result) {
                    if (result.success) {
                    	$('#my-modal-loading-hd').html('同步成功');
                    }else{
                    	$('#my-modal-loading-hd').html('同步失败');
                    }

                    $('#my-modal-loading-img').addClass("dispaly-none");
                	$('#my-modal-loading-close').removeClass("dispaly-none");
                }
            });
    });

    $('#my-modal-loading-close').click(function(){
    	$('#my-modal-loading').modal('close');
    });

    $('#index-a').click();
  });
})(jQuery);