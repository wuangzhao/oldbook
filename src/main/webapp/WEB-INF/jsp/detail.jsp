<%--
  Created by IntelliJ IDEA.
  User: angzhao
  Date: 2018/8/4
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/detail" method="get">
    <table width="300px"; border="1">
        <tr>
            <td>Id</td>
            <td>名称</td>
            <td>ISBN</td>
        </tr>
        <c:forEach items="${bookEntityList}" var="book" varStatus="status">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.bookName}</td>
                <td>${book.bookISBN}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
