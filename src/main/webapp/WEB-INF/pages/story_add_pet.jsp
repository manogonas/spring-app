<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add Pet To Story</title>
</head>
<body>
<h3><a href="/story">Back</a></h3>
<h2>Enter story id</h2>
<form:form method="post" action="addPet" modelAttribute="pet_story">
    <table>
        <tr>
            <td><form:label path="story_id">Story id</form:label></td>
            <td><form:input path="story_id" /></td>
        </tr>
        <tr>
            <td><form:label path="pet_id">Pet id</form:label></td>
            <td><form:input path="pet_id" /></td>
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