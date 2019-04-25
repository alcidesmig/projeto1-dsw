<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Gerenciamento de promoções"/>
</jsp:include>

<center>
    <h1>Gerenciamento de Salas de Teatro</h1>
    <h2>
        <a href="cadastro">Adicione Nova Sala de Teatro</a>
        <a href="lista">Lista de Sala de Teatros</a>
        <div>
            <form action="gerenciar">
                <p>Buscar</p>
                <input type="text" id="busca" name="busca"/>
                <input type="submit">
            </form>
        </div>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Salas de Teatro</h2></caption>
        <tr>
            <th>Nome da peça</th>
            <th>Preço</th>
            <th>Endereço (URL)</th>
            <th>CNPJ do Teatro</th> <!-- Mudar para nome do teatro? -->
            <th>Data e horário</th>
            <th>Acões</th>
        </tr>

        <c:forEach var="teatro" items="${listaTeatros}">
            <tr>
                <td><c:out value="${teatro.cidade}" /></td>
                <td><c:out value="${teatro.email}" /></td>
                <td><c:out value="${teatro.cnpj}" /></td>
                <td><c:out value="${teatro.nome}" /></td>
                <td><c:out value="${teatro.site_de_venda_email}" /></td>

                <td>
                    <a href="edicao_form?id=<c:out value='${teatro.cnpj}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="remocao?id=<c:out value='${prom.cnpj}' />"
                       onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../helpers/footer.jsp"/>
