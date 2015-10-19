$(function() {
	var contentId=$("#contentId").val();

	var submitUrl=BASE + '/content/create';


	if(contentId&&contentId!=null||contentId!="")
		submitUrl=BASE+'/content/update/'+contentId;


    $('#content_create_form').ajaxForm({
        type: 'post',
        url: submitUrl,
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('content_create_form');
        },
        success: function(result) {
            if (result.success) {
            	console.log("列表----------");
            	contentList(result.data.menuId,result.data.templetId,1);
            	console.log("------------列表");
            	$modal.modal('close');
            	var $dimmer=$(".am-dimmer");
            	$dimmer.removeClass("am-active");
            	$dimmer.hide();
            }
        }
    });

    $(".ex-time-input").datetimepicker({
    	  language:  'zh-CN'
    });

  if($('#isAd-checkbox').val()=='1')
	  $('#isAd-checkbox').attr("checked","checked");

  $('#isAd-checkbox').on('click',function(){
	   if( $(this).val()=='0'){
		   $(this).val('1');
	   }else{
		   $(this).val('0');
	   }
  });
});