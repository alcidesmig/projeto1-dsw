<% String active = request.getParameter("active"); %>

<div class="ui inverted top fixed big menu">
    <div class="ui container">
        <a class="
           <% if(active.equalsIgnoreCase("home")) out.print("active");%>
           item" href="/projeto1_dsw">Inicio</a>
        <div class="right menu">
            <a class="
               <% if(active.equalsIgnoreCase("login")) out.print("active");%>
               item" href="/projeto1_dsw/login.jsp">
                Log in
            </a>
        </div>
    </div>
</div>
<div style="height: 45.7px; margin-bottom: 20px;"></div>
