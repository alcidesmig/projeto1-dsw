<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Lista de Teatros"/>
</jsp:include>
<jsp:include page="../helpers/navbar.jsp">
    <jsp:param name="active" value="teatros"/>
</jsp:include>
<style>
    p{
        cursor: pointer;
        font-size: 24px;
    }    
</style>
<center>
    <h1>Listagem Das Salas de Teatro</h1>
</center>
<br>
<br>
<div align="center">
    <table border="1" cellpadding="5" id="java_is_terrible" class="ui sortable celled table" style="width: 80%;">
         <div class="ui icon input">
        <input type="text" placeholder="Filtre os teatros por cidade!" id="java_is_horrible" onkeyup="filter()">
        <i class="search icon"></i>
        </div>
        <tr>
            <th><p onclick="sortTable(0)" class="ui labeled icon primary full-width"> <i class="sort alphabet down icon"></i>URL</p></th>
            <th><p onclick="sortTable(1)" class="ui labeled icon primary full-width"> <i class="sort alphabet down icon"></i>Nome</p></th>
            <th><p onclick="sortTable(2)" class="ui labeled icon primary full-width"> <i class="sort alphabet down icon"></i>Telefone</p></th>
            <th><p onclick="sortTable(3)" class="ui labeled icon primary1 full-width"> <i class="sort alphabet down icon"></i>Email</p></th>  
        </tr>  
        <c:forEach var="site" items="${listaSite}">
            <tr>
                <td><c:out value="${site.url}" /></td>
                <td><c:out value="${site.nome}" /></td>
                <td><c:out value="${site.telefone}" /></td>
                <td><c:out value="${site.email}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
function sortTable(index) {
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
      x = rows[i].getElementsByTagName("TD")[index];
      y = rows[i + 1].getElementsByTagName("TD")[index];
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
