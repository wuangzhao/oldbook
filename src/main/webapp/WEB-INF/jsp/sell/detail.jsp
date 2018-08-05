<%--
  Created by IntelliJ IDEA.
  User: angzhao
  Date: 2018/8/5
  Time: 下午7:53
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
            <td>sell.sellId</td>
            <td>sell.sellCreateTime</td>
            <td>sell.sellStatus</td>
            <td>book.bookId</td>
            <td>book.bookISBN</td>
            <td>book.bookName</td>
            <td>sellUserId</td>
            <td>sellUserName</td>
        </tr>
        <tr>
            <td>${sell.sellId}</td>
            <td>${sell.sellCreateTime}</td>
            <td>${sell.sellStatus}</td>
            <td>${book.bookId}</td>
            <td>${book.bookISBN}</td>
            <td>${book.bookName}</td>
            <td>${sellUserId}</td>
            <td>${sellUserName}</td>
        </tr>
    </table>
</form>

</body>
</html>
