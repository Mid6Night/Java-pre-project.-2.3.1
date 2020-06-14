<%--
  Created by IntelliJ IDEA.
  User: nitro
  Date: 14.06.2020
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Create</title>
</head>
<body>
<form action="/users/add" method="post">
    <input type="text" placeholder="имя" name="firstName"/>
    <input type="text" placeholder="фамилия" name="lastName"/>
    <input type="text" placeholder="email" name="email"/>
    <button type="submit"> отправить .</button>

</form>
</body>
</html>
