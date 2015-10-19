<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="/security" %>

<div id="header">
    <div class="logo">
        <a href="${BASE}/"><f:message key="common.title"/></a>
    </div>
    <div class="menu">
        <a href="${BASE}/products">粉丝管理</a>
        <a href="${BASE}/products">抽奖设置</a>
        <a href="${BASE}/products">中奖用户</a>
        <a href="${BASE}/products">话费活动设置</a>
        <a href="${BASE}/products">活动用户</a>
        <security:hasRole name="admin">
            <a href="${BASE}/users"><f:message key="user"/></a>
        </security:hasRole>
    </div>
    <div class="oper">
        <span><f:message key="common.user"/>: <security:principal/></span>
        <button type="button" id="logout"><f:message key="common.logout"/></button>
    </div>
</div>