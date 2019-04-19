<jsp:include page="helpers/header.jsp">
    <jsp:param name="title" value="Cadastro de usu�rios"/>
</jsp:include>
    <body>
        <form class="form-horizontal" action="cadastro" method="post">
            <fieldset>

                 <!-- Form Name -->
                <legend>Cadastro de usu�rio</legend>

                 <!-- Text input-->
                <div>
                    <label for="usuario_id">ID</label>  
                    <div >
                        <input id="usuario_id" name="usuario_id" type="text" placeholder="example@gmail.com" required="">
                        <span class="help-block">Insira seu id de usu�rio</span>        
                    </div>
                </div>

                 <!-- Password input-->
                <div>
                    <label  for="password">Senha</label>
                    <div class="col-md-4">
                        <input id="password" name="password" type="password" placeholder="Password" required="">
                        <span class="help-block">Insira sua senha</span>
                    </div>
                </div>

                 <!-- Text input-->
                <div>
                    <label for="name">Nome</label>  
                    <div>
                        <input id="name" name="name" type="text" placeholder="Example" required="">
                        <span class="help-block">Insira seu nome</span>  
                    </div>
                </div>
                <input type="submit" value="Enviar">
            </fieldset>
        </form>

<jsp:include page="helpers/footer.jsp"/>
