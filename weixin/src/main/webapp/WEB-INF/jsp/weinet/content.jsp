<%@ page pageEncoding="UTF-8" %>
<%@ include file="../common/global.jsp" %>

<c:set var="content" value="${contentMap}"/>

${content.title}<p>
${content.summary}<p>
${content.detail}<p>
${content.price}<p>
${content.discount}<p>
<img src="${BASE}/www/html/i/${content.image}"/>
