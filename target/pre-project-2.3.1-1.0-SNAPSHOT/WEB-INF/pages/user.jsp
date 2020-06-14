<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>SecondName</th>
        <th>Email</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                    ${user.getId()}
            </td>
            <td>
                    ${user.getFirstName()}
            </td>
            <td>
                    ${user.getLastName()}
            </td>
            <td>
                    ${user.getEmail()}
            </td>
            <td>
               <a href="/users/${user.getId()}/update">Update</a>
            </td>
            <td>
                <a href="/users/${user.getId()}/delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form>
<a href="/users/add">Create</a>
</form>
</body>
</html>