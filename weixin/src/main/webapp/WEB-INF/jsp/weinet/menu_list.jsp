<%@ page pageEncoding="UTF-8" %>
<%@ include file="../common/global.jsp" %>

<c:forEach var="item" items="${list}">
${item.title}/${item.sex}/${item.price}<p>
</c:forEach>
