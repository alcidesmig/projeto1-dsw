<%-- 
    Document   : login
    Created on : Apr 15, 2019, 8:22:36 AM
    Author     : olivato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta charset="UTF-8"/>

        <title>CRUD 2002</title>
        <link rel="stylesheet" type="text/css" href="semantic/semantic.css">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"
                integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
                crossorigin="anonymous"></script>
        <script src="semantic/semantic.js"></script>
    </head>
    <body>
    <center>
        <h2 class="ui icon header">
  <i class="user icon"></i>
  <div class="content">
      Login
  </div>
</h2>
        <div class="ui six segment" style="width: 50%;">       
            <form action="/api/login">
                <div class="ui input">
                <input type="text" placeholder="ID">
                </div>
                <br><br>
                <div class="ui input">
                <input type="password" placeholder="****">
                </div>
                <br><br>
                <button type="submit" class="ui positive button">Entrar</button>
            </form>
            <br><br>
            <div class="ui segment">
            <%
               String token = request.getParameter("token");
            %>
                Não possui uma conta? Clique <a href="">aqui</a>
            </div>
        </div>
    <br><br>
    </center>
    </body>
</html>

