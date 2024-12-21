<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Create Owner</title>
    <link rel="stylesheet" href=
            "https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
</head>
<body>
<h3><a href="/owner">Back</a></h3>
<h2 class="text-center">Enter owner information</h2>
<form:form method="post" action="addOwner" class="container-sm mt-5" modelAttribute="owner">
    <table>
        <tr class="form-group">
            <td><form:label path="fio">Name</form:label></td>
            <td><form:input path="fio" /></td>
            <td><form:errors path="fio" /></td>
        </tr>
        <tr class="form-group mt-2">
            <td><form:label path="number">Phone number</form:label></td>
            <td><form:input path="number" /></td>
            <td><form:errors path="number" /></td>
        </tr>
        <tr class="form-group mt-2">
            <td><label>Add pets</label></td>
            <td><form:checkboxes items="${checkboxOptions}" path="string_pets" class="form-check-input"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" class="btn-dark"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>