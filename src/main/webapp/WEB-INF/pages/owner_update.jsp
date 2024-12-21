<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Update Owner</title>
</head>
<body>
<h3><a href="/owner">Back</a></h3>
<h2>Enter owner information</h2>
<form:form method="post" action="updateOwner" modelAttribute="owner">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td><form:label path="fio">Name</form:label></td>
            <td><form:input path="fio" /></td>
        </tr>
        <tr>
            <td><form:label path="number">Phone number</form:label></td>
            <td><form:input path="number" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>