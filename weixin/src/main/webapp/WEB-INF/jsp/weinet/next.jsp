<%@ page pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${next!='end'}">
		<div class="am-g am-text-center" id="next-page" url="${next}">
			<i class="am-icon-arrow-circle-o-down"></i>&nbsp; 加载中 <i
				class="am-icon-spinner am-icon-spin"></i>...
			<script type="text/javascript">
				$('#next-page').scrollspy({
					animation : 'slide-top',
					repeat : false
				});
				$('#next-page').on('inview.scrollspy.amui', function() {
					var url = $(this).attr('url');
					if ('end' !== url) {
						$.ajax({
							beforeSend : function() {
								return true;
							},
							complete : function() {
								return true;
							},
							url : "${BASE}/" + $(this).attr('url'),
							dataType : "html",
							type : "POST",
							cache : false,
							async : true,
							success : function(html) {
								var container=$('#next-page').parent();
								$('#next-page').remove();
								container.append(html);
							}
						});
					}
				});
			</script>
		</div>
	</c:when>
	<c:otherwise>
		<div class="am-g am-text-center">
			没有更多啦....</div>
	</c:otherwise>
</c:choose>