<%--
  Created by IntelliJ IDEA.
  User: home-pc
  Date: 2017/6/6
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="mainBodyCss/RegisterPageCss.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="registerContainer">
    <div id="registerBox">
        <div id="black"></div>
        <div id="registerLocation">
            <form action="register" method="post">
                <br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>账户：</b><input type="text"
                    pattern="^\w{6,12}$" required autofocus name="name" id="name" placeholder="您的账户（6到12位英文）" ><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>密码：</b><input type="password"
                                                               required name="password" placeholder="您的密码"><br>
                <br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;<input style="border: 5px ;font-size: large;font-family:微软雅黑;font-weight: bold" type="submit" value="注册">
            </form>
        </div>
    </div>
</div>
</body>
</html>
