<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Lista de Teatros"/>
</jsp:include>
<jsp:include page="../helpers/navbar.jsp">
    <jsp:param name="active" value="teatros"/>
</jsp:include>

<center>
    <h1><fmt:message key="sala_teatros.title"/></h1>
</center>
<br>
<div align="center">
    <table border="1" cellpadding="5" id="java_is_terrible" class="ui celled table" style="width: 80%;">
        <caption><h2>Listagem de Salas de Teatro</h2></caption>
        <tr>
            <th><button onclick="sortTable()" class="ui labeled icon positive button"> <i class="sort alphabet down icon"></i>Cidade</button></th>
            <th>Email</th>
            <th>CNPJ</th>
            <th>Nome</th>  
            <th>Site de venda (e-mail)</th>  
        </tr>
        <c:forEach var="teatro" items="${listaTeatros}">
            <tr>
                <td><c:out value="${teatro.cidade}" /></td>
                <td><c:out value="${teatro.email}" /></td>
                <td><c:out value="${teatro.cnpj}" /></td>
                <td><c:out value="${teatro.nome}" /></td>
                <td><c:out value="${teatro.site_de_venda_email}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
function sortTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("java_is_terrible");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[0];
      y = rows[i + 1].getElementsByTagName("TD")[0];
      //check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        //if so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>
<jsp:include page="../helpers/footer.jsp"/>
