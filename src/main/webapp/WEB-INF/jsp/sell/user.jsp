<%--
  Created by IntelliJ IDEA.
  User: angzhao
  Date: 2018/8/5
  Time: 下午8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get">
    <table width="300px"; border="1">
        <tr>
            <td>{sell.bookId}</td>
            <td>{sell.sellStatus}</td>
            <td>{sell.sellCreateTime}</td>
            <td>{sell.userId}</td>
            <td>{sell.sellId}</td>
        </tr>
        <c:forEach items="${sellList}" var="sell" varStatus="status">
            <tr>
                <td>${sell.bookId}</td>
                <td>${sell.sellStatus}</td>
                <td>${sell.sellCreateTime}</td>
                <td>${sell.userId}</td>
                <td>${sell.sellId}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
