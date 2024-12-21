<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Get Pet</title>
</head>
<body>
<h3><a href="/pet">Back</a></h3>
<h2>Enter pet id</h2>
<form:form method="post" action="searchPet" modelAttribute="pet">
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