<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Gerenciamento de promoções"/>
</jsp:include>

<center>
    <h1>Gerenciamento de promoções</h1>
    <h2>
        <a href="cadastro">Adicione Novo Livro</a>
        <a href="lista">Lista de Promocoes</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Promoções</h2></caption>
        <tr>
            <th>Nome da peça</th>
            <th>Preço</th>
            <th>Endereço (URL)</th>
            <th>CNPJ do Teatro</th> <!-- Mudar para nome do teatro? -->
            <th>Data e horário</th>
            <th>Acões</th>
        </tr>

        <c:forEach var="prom" items="${listaPromocao}">
            <tr>
                <td><c:out value="${prom.nome_peca}" /></td>
                <td><c:out value="${prom.preco}" /></td>
                <td><c:out value="${prom.endereco_url}" /></td>
                <td><c:out value="${prom.cnpj_teatro}" /></td>
                <td><c:out value="${prom.datetime}" /></td>

                <td>
                    <a href="edicao?id=<c:out value='${prom.id_promocao}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="remocao?id=<c:out value='${prom.id_promocao}' />"
                       onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../helpers/footer.jsp"/>
