<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Create Story</title>
</head>
<body>
<h3><a href="/story">Back</a></h3>
<h2>Enter story information</h2>
<form:form method="post" action="addStory" modelAttribute="story">
    <table>
        <tr>
            <td><form:label path="story">Story</form:label></td>
            <td><form:input path="story" /></td>
        </tr>
        <tr>
            <td><form:label path="prescriptions">Prescriptions</form:label></td>
            <td><form:input path="prescriptions" /></td>
        </tr>
        <tr>
            <td><form:label path="pet">Pet</form:label></td>
            <td><form:radiobuttons items="${RadiobuttonItems}" path="pet" /></td>
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