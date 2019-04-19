
 
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Teatros</h2></caption>
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Ano</th>
            <th>Preço</th>
            <th>Acões</th>
        </tr>
        <c:forEach var="livro" items="${listaLivros}">
            <tr>
                <td><c:out value="${livro.id}" /></td>
            <td><c:out value="${livro.titulo}" /></td>
            <td><c:out value="${livro.autor}" /></td>
            <td><c:out value="${livro.ano}" /></td>
            <td><c:out value="${livro.preco}" /></td>
            <td><a href="edicao?id=<c:out value='${livro.id}' />">Edição</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="remocao?id=<c:out value='${livro.id}' />"
                   onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                    Remoção
                </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
