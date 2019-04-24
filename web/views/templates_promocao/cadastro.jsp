<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Cadastro de Promoções"/>
</jsp:include>
<c:if test="${prom != null}">
    <form action="edicao" method="post">
    </c:if>
    <c:if test="${prom == null}">
        <form action="cadastro" method="post">
        </c:if>
        <c:if test="${prom != null}">
            <div>
                <label for="id_promocao">ID</label>  
                <div >
                    <input value="<c:out value='${prom.id_promocao}'/>" id="id_promocao" name="id_promocao" type="text" placeholder="" disabled>
                    <span>Deixe em branco para preenchimento automático</span>        
                </div>
            </div>
        </c:if>
        <div>
            <label for="nome_peca">Nome da peça</label>  
            <div >
                <input value="<c:out value='${prom.nome_peca}'/>" id="nome_peca" name="nome_peca" type="text" placeholder="">
                <span>Nome da peça</span>        
            </div>
        </div>
        <div>
            <label for="preco">Preço</label>  
            <div >
                <input value="<c:out value='${prom.preco}'/>" id="preco" name="preco" type="text" placeholder="Preço em reais" required="">
                <span>Preço da promoção</span>        
            </div>
        </div>
        <div>
            <label for="datetime">Data e hora</label>  
            <div >
                <input value="<c:out value='${prom.datetime}'/>" id="datetime" name="datetime" type="text" placeholder="DD/MM/YY HH:MM:SS" required="">
                <span>Data e hora da promoção</span>        
            </div>
        </div>
        <div>
            <label for="endereco_url">Endereço (URL)</label>  
            <div >
                <input value="<c:out value='${prom.endereco_url}'/>" id="endereco_url" name="endereco_url" type="text" placeholder="https://www.example.dev" required="">
                <span>Endereço da promoção</span>        
            </div>
        </div>
        <div>
            <label for="cnpj_teatro">Salas disponíveis (CNPJ do teatro)</label>  
            <div >
                <select id="cnpj_teatro" name="cnpj_teatro">
                    <c:forEach var="sala" items="${listaSalas}">    
                        <c:choose>
                            <c:when test="${sala.cnpj == prom.cnpj_teatro}">
                                <option selected value="<c:out value="${sala.cnpj}" />"><c:out value="${sala.nome}"/> - <c:out value="${sala.cnpj}"/></option> 
                            </c:when>
                            <c:otherwise>
                                <option value="<c:out value="${sala.cnpj}" />"><c:out value="${sala.nome}"/> - <c:out value="${sala.cnpj}"/></option> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <span>Salas de teatro disponíveis</span>        
            </div>
        </div>
        <div>
            <input type="submit" value="Enviar"/>
        </div>
    </form>
    <jsp:include page="../helpers/footer.jsp"/>
