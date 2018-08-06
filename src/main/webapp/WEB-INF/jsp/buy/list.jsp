<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: angzhao
  Date: 2018/8/6
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table width="300px"; border="1">
        <tr>
            <td>{bookAndBuy.book.bookId}</td>
            <td>{bookAndBuy.book.bookName}</td>
            <td>{bookAndBuy.buy.buyId}</td>
            <td>{bookAndBuy.buy.buyCreateTime}</td>
        </tr>
        <c:forEach items="${bBList}" var="bookAndBuy" varStatus="status">
            <tr>
                <td>${bookAndBuy.book.bookId}</td>
                <td>${bookAndBuy.book.bookName}</td>
                <td>${bookAndBuy.buy.buyId}</td>
                <td>${bookAndBuy.buy.buyCreateTime}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
