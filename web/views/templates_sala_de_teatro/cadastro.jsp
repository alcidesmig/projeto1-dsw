<jsp:include page="../helpers/header.jsp">
    <jsp:param name="title" value="Cadastro de usuários"/>
</jsp:include>
    <body>
        <form class="form-horizontal" action="cadastro" method="post">
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
                 
                <input type="submit" value="Enviar">
            </fieldset>
        </form>

<jsp:include page="../helpers/footer.jsp"/>
