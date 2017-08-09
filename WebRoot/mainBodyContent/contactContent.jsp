<%--
  Created by IntelliJ IDEA.
  User: home-pc
  Date: 2017/6/6
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link  rel="stylesheet" href="mainBodyCss/ContactContentCss.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="teamWork">
    <div id="teamWorkContent">
        <div id="teamWorkContentBlack">
        </div>
        <div id="messageBoard">
            <form action="homePage.jsp" method="post">
                <P>电子邮箱：<input type="email" required name="email" id="email" placeholder="您的电子邮箱  @  .com"></P>
                <P>您的联系电话：<input type="text" required name="phoneNumber" id="phoneNumber" placeholder="您的联系电话"></P>
                留言：<br><br>&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="think" cols="40" rows="6"></textarea>
                <br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" style="border: none" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>
