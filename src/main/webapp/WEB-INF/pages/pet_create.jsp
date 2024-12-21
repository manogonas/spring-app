<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Create Pet</title>
</head>
<body>
<h3><a href="/pet">Back</a></h3>
<h2>Enter owner information</h2>
<form:form method="post" action="addPet" modelAttribute="pet">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
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