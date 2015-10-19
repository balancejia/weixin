$(function() {
    $('#content_create_form').ajaxForm({
        type: 'post',
        url: BASE + '/content/create',
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('content_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/admin';
            }
        }
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