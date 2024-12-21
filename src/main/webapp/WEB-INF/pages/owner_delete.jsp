<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Delete Owner</title>
</head>
<body>
<h3><a href="/owner">Back</a></h3>
<h2>Enter owner id</h2>
<form:form method="post" action="deleteOwner" modelAttribute="owner">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
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