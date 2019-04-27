<%@page import="br.ufscar.dc.dsw.controller.AuthController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="br.ufscar.dc.dsw.i18n.text" />
<c:set var="laguage" value="${pageContext.response.locale}"/>
<fmt:setLocale value="${language}"/>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="teatros_list"/>
</jsp:include>
<jsp:include page="../helpers/navbar.jsp">
    <jsp:param name="active" value="teatros"/>
</jsp:include>
<center>
    <h1><fmt:message key="teatro.list.h1"/></h1>
    <div class="ui icon input">
        <input type="text" placeholder="Filtre os teatros por cidade!" id="java_is_horrible" onkeyup="filter()">
        <i class="search icon"></i>
    </div>
    <br>
    <br>
</center>
<div class="ui container">
    <table id="java_is_terrible" class="ui sortable celled table">
        <thead>
            <tr>
                <th><fmt:message key="teatro.list.cidade"/></th>
                <th><fmt:message key="teatro.list.email"/></th>
                <th><fmt:message key="teatro.list.cnpj"/></th>
                <th><fmt:message key="teatro.list.nome"/></th>
                <th><fmt:message key="teatro.list.email_vendas"/></th>
            </tr> 
        </thead>
        <tbody>
            <c:forEach var="teatro" items="${listaTeatros}">
                <tr>
                    <td><c:out value="${teatro.cidade}" /></td>
                    <td><c:out value="${teatro.email}" /></td>
                    <td><c:out value="${teatro.cnpj}" /></td>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.site_de_venda_email}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script>
    $(document).ready(function () {
        $('table').tablesort();
    });

function filter() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("java_is_horrible");
  filter = input.value.toUpperCase();
  table = document.getElementById("java_is_terrible");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

</script>
<jsp:include page="../helpers/footer.jsp"/>
