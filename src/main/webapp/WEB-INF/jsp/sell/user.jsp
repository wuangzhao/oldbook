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
            <td>userSell.sell.sellStatus</td>
            <td>userSell.sell.CreateTime</td>
            <td>userSell.sell.userId</td>
            <td>userSell.sell.sellId</td>
            <td>userSell.book.bookId</td>
            <td>userSell.book.bookName</td>
            <td>userSell.book.bookISBN</td>

        </tr>
        <c:forEach items="${userSellList}" var="userSell" varStatus="status">
            <tr>
                <td>${userSell.sell.sellStatus}</td>
                <td>${userSell.sell.sellCreateTime}</td>
                <td>${userSell.sell.userId}</td>
                <td>${userSell.sell.sellId}</td>
                <td>${userSell.book.bookId}</td>
                <td>${userSell.book.bookName}</td>
                <td>${userSell.book.bookISBN}</td>
            </tr>
        </c:forEach>
    </table>
</form>

<form action="/sell/newSell" method="post">
    <table width="300px"; border="1">
        <tr>
            <td>Id</td>
            <td>名称</td>
            <td>ISBN</td>
        </tr>
        <tr>
            <td><input type="text" name="bookId"></td>
            <td><input type="text" name="bookName"></td>
            <td><input type="text" name="bookISBN"></td>
        </tr>

    </table>
    <input type="submit">
</form>
</body>
</html>
