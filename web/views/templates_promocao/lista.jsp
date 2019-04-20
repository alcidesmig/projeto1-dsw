<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Lista de promoções"/>
</jsp:include>

<center>
    <h1>Listagem de promoções</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Listagem de Promoções</h2></caption>
        <tr>
            <th>Nome da peça</th>
            <th>Preço</th>
            <th>Endereço (URL)</th>
            <th>CNPJ do Teatro</th> <!-- Mudar para nome do teatro? -->
            <th>Data e horário</th> <!-- Mudar para nome do teatro? -->
        </tr>

        <c:forEach var="prom" items="${listaPromocao}">
            <tr>
                <td><c:out value="${prom.nome_peca}" /></td>
                <td><c:out value="${prom.preco}" /></td>
                <td><c:out value="${prom.endereco_url}" /></td>
                <td><c:out value="${prom.cnpj_teatro}" /></td>
                <td><c:out value="${prom.datetime}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../helpers/footer.jsp"/>
