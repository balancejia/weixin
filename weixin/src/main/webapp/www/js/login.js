$(function() {
    var mainURL = BASE + '/admin';

    $('#login_form').ajaxForm({
        type: 'post',
        url: BASE + '/login',
        dataType: 'json',
        beforeSubmit: function() {
            var result = false;
            if (Smart.Validator.checkRequired('login_form')) {
                $('#login_form').find(':input').prop('disabled', true);
                result = true;
            }
            return result;
        },
        success: function(result) {
            if (result.success) {
                location.href = mainURL;
            } else {
                if (result.data == 'captcha_error') {
                    alert(Smart.i18n('common.captcha.error'));
                    $('#captcha').parent().parent().removeClass('am-form-success');
                    $('#captcha').parent().parent().addClass('am-form-error');
                } else {
                    alert(Smart.i18n('login.failure'));
                   var input= $('#login_form .ext-required');
                   input.parent().parent().removeClass('am-form-success');
                   input.parent().parent().find('span').removeClass('am-icon-check');
                   input.parent().parent().addClass('am-form-error');
                   input.parent().parent().find('span').addClass('am-icon-times');
                }
                $('#login_form').find(':input').prop('disabled', false);
                $('#captcha_img').click();
                $('#captcha').val('');
            }
        }
    });
});