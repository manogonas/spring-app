<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Create Specialist</title>
</head>
<body>
<h3><a href="/specialist">Back</a></h3>
<h2>Enter specialist information</h2>
<form:form method="post" action="addSpecialist" modelAttribute="specialist">
    <table>
        <tr>
            <td><form:label path="fio">Name</form:label></td>
            <td><form:input path="fio" /></td>
        </tr>
        <tr>
            <td><form:label path="job">Job</form:label></td>
            <td><form:select path="job" items="${SelectItems}" /></td>
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