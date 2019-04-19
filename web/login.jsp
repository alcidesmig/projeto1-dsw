<%-- 
    Document   : login
    Created on : Apr 15, 2019, 8:22:36 AM
    Author     : olivato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="helpers/header.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
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
<jsp:include page="helpers/footer.jsp"/>

