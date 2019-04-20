<jsp:include page="views/helpers/header.jsp">
    <jsp:param name="title" value="Index"/>
</jsp:include>
<jsp:include page="views/helpers/navbar.jsp">
        <jsp:param name="active" value="login"/>
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
                Não possui uma conta? Clique <a href="">aqui</a>
            </div>
        </div>
        <br><br>
    </center>
<jsp:include page="views/helpers/footer.jsp"/>
