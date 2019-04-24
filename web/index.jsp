<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="br.ufscar.dc.dsw.i18n.text" />
<c:set var="laguage" value="${pageContext.response.locale}"/>
<fmt:setLocale value="${language}"/>

<jsp:include page="views/helpers/header.jsp">
    <jsp:param name="title" value="home"/>
</jsp:include>
<jsp:include page="views/helpers/navbar.jsp">
    <jsp:param name="active" value="home"/>
</jsp:include>

<div class="ui text container ">
    <marquee><h1><fmt:message key="index.h1"/></h1></marquee>
    
    <p><fmt:message key="index.p1"/></p>
    
    <p><fmt:message key="index.p2"/>:<a href="http://sou.gohorseprocess.com.br/extreme-go-horse-xgh/">como fazer softwares com um mínimo de senso</a></p>


</div>

<jsp:include page="views/helpers/footer.jsp"/>
