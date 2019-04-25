<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="br.ufscar.dc.dsw.i18n.text" />
<c:set var="laguage" value="${pageContext.response.locale}"/>
<fmt:setLocale value="${language}"/>

<jsp:include page="views/helpers/header.jsp">
    <jsp:param name="title" value="login"/>
</jsp:include>
<jsp:include page="views/helpers/navbar.jsp">
        <jsp:param name="active" value="login"/>
</jsp:include>
    <center class="ui text container">
        <div class="ui segment">       
            <h2 class="ui icon header">
                <i class="user icon"></i>
                <div class="content">
                    <fmt:message key="login.text"/>
                </div>
            </h2>
            <form class="ui form" action="/api/login">
                <div class="ui input">
                    <input type="text" placeholder="<fmt:message key="login.placeholder.username"/>">
                </div>
                <br>
                <br>
                <div class="ui input">
                    <input type="password" placeholder="<fmt:message key="login.placeholder.password"/>">
                </div>
                <br><br>
                <button type="submit" class="ui positive button"><fmt:message key="login.text.submit_button"/></button>
            </form>
        </div>
        <br><br>
    </center>
<jsp:include page="views/helpers/footer.jsp"/>
