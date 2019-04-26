<%@page import="br.ufscar.dc.dsw.model.Usuario"%>
<%@page import="br.ufscar.dc.dsw.controller.AuthController"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="br.ufscar.dc.dsw.i18n.text" />
<c:set var="laguage" value="${pageContext.response.locale}"/>
<fmt:setLocale value="${language}"/>

<% 
    String active = request.getParameter("active"); 
    Usuario user = AuthController.getUser(request);
%>

<div class="ui inverted top fixed big menu">
    <div class="ui container">
        <a class="
           <% if(active.equalsIgnoreCase("home")) out.print("active");%>
           item" href="/projeto1_dsw"><fmt:message key="navbar.item.home"/></a>
        
        <% if (AuthController.hasRole(request, "administrador")) { %>
            <div class="ui simple dropdown item" id="user">
                <fmt:message key="navbar.item.user"/>
                <i class="dropdown icon"></i>
                <div class="inverted menu">
                    <a class="item" href="/projeto1_dsw/usuario/lista"><fmt:message key="navbar.item.user.list"/></a>
                    <a class="item" href="/projeto1_dsw/usuario/cadastro"><fmt:message key="navbar.item.user.register"/></a>
                </div>
            </div>
        <% } %>
        
        <div class="right menu">
            <% if (user == null) { %>
            <a class="
               <% if(active.equalsIgnoreCase("login")) out.print("active");%>
               item" href="/projeto1_dsw/login.jsp">
                <fmt:message key="navbar.item.login"/>
            </a>
            <% } else { %>
            <a class="item"><%= user.getNome() %></a>
            <a class="item" href="/projeto1_dsw/auth/">
                <fmt:message key="navbar.item.logout"/>
            </a>
            <% } %>
        </div>
    </div>
</div>
<div style="height: 45.7px; margin-bottom: 20px;"></div>
