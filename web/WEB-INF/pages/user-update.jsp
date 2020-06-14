<%--
  Created by IntelliJ IDEA.
  User: nitro
  Date: 14.06.2020
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User update</title>
</head>
<body>
<form action="/users/${id}/update" method="post">
    <input type="text" placeholder="firstName" name="firstName" value="${firstName}"/>
    <input type="text" placeholder="lastName" name="lastName" value="${lastName}"/>
    <input type="text" placeholder="email" name="email" value="${email}"/>
    <button type="submit"> отправить .</button>
</form>
</body>
</html>
