<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="br.ufscar.dc.dsw.i18n.text" />
<c:set var="laguage" value="${pageContext.response.locale}"/>
<fmt:setLocale value="${language}"/>

<% String active = request.getParameter("active"); %>

<div class="ui inverted top fixed big menu">
    <div class="ui container">
        <a class="
           <% if(active.equalsIgnoreCase("home")) out.print("active");%>
           item" href="/projeto1_dsw"><fmt:message key="navbar.item.home"/></a>
        <div class="right menu">
            <a class="
               <% if(active.equalsIgnoreCase("login")) out.print("active");%>
               item" href="/projeto1_dsw/login.jsp">
                <fmt:message key="navbar.item.login"/>
            </a>
        </div>
    </div>
</div>
<div style="height: 45.7px; margin-bottom: 20px;"></div>
