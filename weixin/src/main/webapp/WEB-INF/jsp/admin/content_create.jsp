<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<div class="am-g">
	<div class="am-u-sm-centered">
		<form class="am-form am-form-horizontal" id="content_create_form"
			enctype="multipart/form-data">
			<input type="hidden" name="templetId" value="${templetId}" />
			<input type="hidden" name="menuId" value="${menuId}" />
			<input type="hidden" name="contentId" value="${contentId}" id="contentId" />
			<c:forEach var="field" items="${fields}">
				<div class="am-form-group am-form-icon am-form-feedback">
					<label class="am-u-sm-2 am-form-label">${field.name}</label>
					<div class="am-u-sm-10">
						<c:choose>
							<c:when test="${field.type=='file'}">
							   <c:choose>
							    <c:when test="${contentId==null||contentId==''}">
                                 <input type="file" class="am-form-field" id="${field.key}"
									name="${field.key}" value="${field.value} required"/>
							   </c:when>
							   <c:otherwise>
								 <img class="am-radius" src="${BASE}/www/upload/${field.value}" width="80px" height="80px" />
							     <input type="file" class="am-form-field" id="${field.key}"
									name="${field.key}" value="${field.value}"/>
							  </c:otherwise>
							   </c:choose>
							</c:when>
							<c:when test="${field.type=='time'}">
								<input type="text" class="am-form-field ex-time-input" id="${field.key}" name="${field.key}" value="${field.value}" data-date-format="yyyy-mm-dd hh:ii" readonly required/>
							</c:when>
							<c:when test="${field.type=='longtext'}">
								<textarea id="${field.key}" name="${field.key}" required>${field.value}</textarea>
							</c:when>
							<c:when test="${field.type=='int'}">
								<input type="number" class="" id="${field.key}"
									name="${field.key}" value="${field.value}" required />
							</c:when>
							<c:otherwise>
								<input type="text" id="${field.key}" name="${field.key}" value="${field.value}" class="am-form-field">
							</c:otherwise>
						</c:choose>
					</div>
					<span></span>
				</div>
			</c:forEach>

			<div class="am-form-group">
				<div class="am-checkbox am-center">
					<div class="am-u-sm-2">&nbsp;&nbsp;</div>
					<label class="am-u-sm-3"> <input type="checkbox"
						name="isAd" value="0" id="isAd-checkbox"> 是否显示在首页广告位
					</label>
					<div class="am-u-sm-4">&nbsp;</div>
				</div>
			</div>


			<div class="am-form-group">
				<div class="am-u-sm-offset-2">
					<button type="submit" class="am-btn am-btn-primary">保存</button>
				</div>
			</div>
		</form>

	</div>
</div>
<script type="text/javascript" src="${BASE}/www/js/content_create.js"></script>