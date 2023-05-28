<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.05.2023
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animals</title>
</head>
<body>
<h2>Animals list</h2>
<p><a href='<c:url value="/createAnimal"/>'>Create new animal</a></p>
<table>
    <tr><th>Animal</th><th>Age</th></tr>
    <c:forEach var="pet" items="${pets}">
        <tr><td>${pet.pet}</td>
            <td>${pet.age}</td>
            <td>
                <a href= '<c:url value="/editAnimal?id=${pet.id}"/> '>Edit</a>
                <form method="post" action='<c:url value="/deleteAnimal"/> ' style="display: inline;">
                    <input type="hidden" name="id" value="${pet.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
