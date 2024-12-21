<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specialist menu</title>
</head>
<body>
<h3><a href="/">Back</a></h3>
<table>
    <caption><h2>Specialists</h2></caption>
    <tr>
        <th>ID</th>
        <th>FIO</th>
        <th>Job</th>
        <th>Pets</th>
    </tr>
    <c:forEach var="s" items="${specialists}">
        <tr>
            <td><c:out value="${s.id}" /></td>
            <td><c:out value="${s.fio}" /></td>
            <td><c:out value="${s.job}" /></td>
            <td><c:out value="${s.pets}" /></td>
        </tr>
    </c:forEach>
</table>
<h3><a href="/specialist/create">Create specialist</a></h3>
<h3><a href="/specialist/get">Get specialist</a></h3>
<h3><a href="/specialist/update">Update specialist</a></h3>
<h3><a href="/specialist/add-pet">Add pet</a></h3>
<h3><a href="/specialist/remove-pet">Remove pet</a></h3>
<h3><a href="/specialist/delete">Delete specialist</a></h3>
</body>
</html>