<%-- 
    Document   : cadastro_usuario
    Created on : 15/04/2019, 09:09:06
    Author     : alcides
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-horizontal">
            <fieldset>

                <!-- Form Name -->
                <legend>Cadastro de usuário</legend>

                <!-- Text input-->
                <div>
                    <label for="usuario_id">ID</label>  
                    <div >
                        <input id="usuario_id" name="usuario_id" type="text" placeholder="example@gmail.com" required="">
                        <span class="help-block">Insira seu id de usuário</span>  
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

    </body>
</html>
