<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Gerenciamento de promoções"/>
</jsp:include>

<center>
    <h1>Gerenciamento de Site De Venda</h1>
    <h2>
        <a href="cadastro">Adicione Novo Site De Venda</a>
        <a href="lista">Lista de Site De Venda</a>
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
        <caption><h2>Lista de Site De Venda</h2></caption>
        <tr>
            <th></th>
            <th>Email</th>
            <th>URL</th>
            <th>Nome</th> <!-- Mudar para nome do teatro? -->
            <th>Telefone</th>
        </tr>

        <c:forEach var="site" items="${listaSite}">
            <tr>
                <td><c:out value="${site.email}" /></td>
                <td><c:out value="${site.url}" /></td>
                <td><c:out value="${site.nome}" /></td>
                <td><c:out value="${site.telefone}" /></td>

                <td>
                    <a href="edicao_form?id=<c:out value='${site.email}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="remocao?id=<c:out value='${site.email}' />"
                       onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../helpers/footer.jsp"/>
