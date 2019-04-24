<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Cadastro de Teatros"/>
</jsp:include>
<jsp:include page="../helpers/navbar.jsp">
    <jsp:param name="active" value="teatros"/>
</jsp:include>
<body>
<center>
    <h1>Cadastro Teatro</h1>
    <form class="form-horizontal ui form" action="cadastro" method="post" style="width: 50%;">
        <fieldset>

            <!-- Form Name -->
            <legend><fmt:message key="cadastro.sala_de_teatro.form_title"/></legend>

            <!-- Text input-->
            <div>
                <label for="sala_de_teatro_email">Email</label>  
                <div >
                    <input id="sala_de_teatro_email" name="email" type="text" placeholder="example@gmail.com" required="True">
                    <span class="help-block"><fmt:message key="cadastro.sala_de_teatro.form_help_email"/></span>        
                </div>
            </div>

            <!-- Password input-->
            <div>
                <label  for="password">Senha</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="Password" required="">
                    <span class="help-block"><fmt:message key="cadastro.sala_de_teatro.form_help_senha"/></span>
                </div>
            </div>

            <!-- Text input-->
            <div>
                <label for="nome">Nome</label>  
                <div>
                    <input id="nome" name="nome" type="text" placeholder="Example" required="">
                    <span class="help-block"><fmt:message key="cadastro.sala_de_teatro.form_help_nome"/>
                    </span>
                </div>
            </div>

            <div>
                <label for="cnpj">CNPJ</label>  
                <div>
                    <input id="cnpj" name="cnpj" type="text" placeholder="Example" required="">
                    <span class="help-block"><fmt:message key="cadastro.sala_de_teatro.form_help_cnpj"/>
                    </span>
                </div>
            </div>

            <div>
                <label for="cidade">Cidade</label>  
                <div>
                    <input id="cidade" name="cidade" type="text" placeholder="Example" required="">
                    <span class="help-block"><fmt:message key="cadastro.sala_de_teatro.form_help_cidade"/>
                    </span>
                </div>
            </div>
            <div>
                <label for="site_de_venda_email">E-mail do site de vendas</label>  
                <div >
                    <select id="site_de_venda_email" name="cnpj_teatro">
                        <c:forEach var="x" items="${listaSites}">    
                            <option value="<c:out value="${x.email}" />"><c:out value="${x.email}"/> - <c:out value="${x.nome}"/></option> 
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br>
            <input type="submit" class="ui positive button" value="Enviar">
        </fieldset>
    </form>
</center>
<jsp:include page="../helpers/footer.jsp"/>
