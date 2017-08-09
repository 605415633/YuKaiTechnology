<%--
  Created by IntelliJ IDEA.
  User: home-pc
  Date: 2017/6/5
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../mainBodyCss/LoginPageCss.css">
<html>
<head>
                                <%--这个是异步AJAX技术，现在还不会具体的应用了--%>
    <%--<script>--%>
        <%--var xmlhttp;--%>
        <%--function check() {--%>
           <%--var name=document.getElementById("name").value;--%>
           <%--var password=document.getElementById("password").value;--%>
           <%--var url="/login?name="+name+"&password="+password;--%>
           <%--xmlhttp=new XMLHttpRequest();--%>
           <%--xmlhttp.onreadystatechange=checkResult;//响应函数--%>
           <%--xmlhttp.open("GET",url,true);//设置访问页面--%>
           <%--xmlhttp.send(null);//执行访问--%>
        <%--}--%>
        <%--function checkResult() {--%>
            <%--if(xmlhttp.readyState==4 && xmlhttp.status==200){--%>

                <%--document.getElementById('warn').innerHTML=xmlhttp.responseText;--%>


            <%--}--%>


        <%--}--%>
    <%--</script>--%>
    <title>Title</title>
</head>
<body>
<div id="bodyContent">
    <div id="Content">
        <div id="blackContent"></div>
        <section class="login">
            <div class="titulo">Login</div>
            <form action="login" method="post" onsubmit="check()" enctype="application/x-www-form-urlencoded">
                <span id="warn"></span>
                <input type="text" name="name" id="name" required title="Username required" placeholder="Username" data-icon="U">

                <input type="password" name="password" id="password" required title="Password required" placeholder="Password" data-icon="x">
                <div class="olvido">
                    <div class="col"><a href="WelcomePage.jsp" title="Ver Carásteres">返回起始页面</a></div>
                    <div class="col"><a href="register.jsp" title="Recuperar Password">还没有账户？To register a !</a></div>
                </div>
                <input type="submit" class="enviar" value="Login">
            </form>
        </section>
    </div>
</div>
</body>
</html>
