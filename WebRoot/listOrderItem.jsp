<%--
  Created by IntelliJ IDEA.
  User: home-pc
  Date: 2017/6/10
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>listOrderItem</title>
</head>
<body>
<div align="center">
    当前用户为：${user.username}
</div>
<h1 align="center">购物车</h1>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
    </tr>
    <c:forEach items="${orderItemList}" var="orderItem" varStatus="st">
        <tr>
            <td>${orderItem.product.name}</td>
            <td>${orderItem.product.price}</td>
            <td>${orderItem.num}</td>
            <td>${orderItem.product.price*orderItem.num}</td>

        </tr>
    </c:forEach>
    <tr>
        <td align="center " colspan="3"><a href="/listProduct">再买点？</a></td>
    </tr>
    <c:if test="${!empty orderItemList}">
        <tr>
            <td colspan="4" align="right">
                <a href="createOrder">生成订单</a>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>
