<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Story menu</title>
</head>
<body>
<h3><a href="/">Back</a></h3>
<table>
    <caption><h2>Stories</h2></caption>
    <tr>
        <th>ID</th>
        <th>Story</th>
        <th>Prescriptions</th>
        <th>Pet</th>
    </tr>
    <c:forEach var="s" items="${stories}">
        <tr>
            <td><c:out value="${s.id}" /></td>
            <td><c:out value="${s.story}" /></td>
            <td><c:out value="${s.prescriptions}" /></td>
            <td><c:out value="${s.pet}" /></td>
        </tr>
    </c:forEach>
</table>
<h3><a href="/story/create">Create story</a></h3>
<h3><a href="/story/get">Get story</a></h3>
<h3><a href="/story/update">Update story</a></h3>
<h3><a href="/story/add-pet">Add pet</a></h3>
<h3><a href="/story/remove-pet">Remove pet</a></h3>
<h3><a href="/story/delete">Delete story</a></h3>
</body>
</html>