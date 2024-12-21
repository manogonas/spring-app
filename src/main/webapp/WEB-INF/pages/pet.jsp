<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet menu</title>
</head>
<body>
<h3><a href="/">Back</a></h3>
<table>
    <caption><h2>Pets</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Specialist</th>
        <th>History</th>
        <th>Owners</th>
    </tr>
    <c:forEach var="p" items="${pets}">
        <tr>
            <td><c:out value="${p.id}" /></td>
            <td><c:out value="${p.name}" /></td>
            <td><c:out value="${p.specialist}" /></td>
            <td><c:out value="${p.history}" /></td>
            <td><c:out value="${p.owners}" /></td>
        </tr>
    </c:forEach>
</table>
<h3><a href="/pet/create">Create pet</a></h3>
<h3><a href="/pet/get">Get pet</a></h3>
<h3><a href="/pet/update">Update pet</a></h3>
<h3><a href="/pet/delete">Delete pet</a></h3>
</body>
</html>