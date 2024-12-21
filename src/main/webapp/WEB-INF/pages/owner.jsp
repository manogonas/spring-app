<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Owner menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h3><a href="/">Back</a></h3>
<table>
    <caption><h2>Owners</h2></caption>
    <tr>
        <th>ID</th>
        <th>FIO</th>
        <th>Number</th>
        <th>Pets</th>
    </tr>
    <c:forEach var="ow" items="${owners}">
        <tr>
            <td><c:out value="${ow.id}" /></td>
            <td><c:out value="${ow.fio}" /></td>
            <td><c:out value="${ow.number}" /></td>
            <td><c:out value="${ow.pets}" /></td>
        </tr>
    </c:forEach>
</table>
<h3><a href="/owner/create">Create owner</a></h3>
<h3><a href="/owner/get">Get owner</a></h3>
<h3><a href="/owner/update">Update owner</a></h3>
<h3><a href="/owner/add-pet">Add pet</a></h3>
<h3><a href="/owner/remove-pet">Remove pet</a></h3>
<h3><a href="/owner/delete">Delete owner</a></h3>
</body>
</html>