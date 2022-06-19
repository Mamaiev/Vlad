<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>List of ingredients</title>
</head>
<body>
<div align="left">
    <table border="1" cellpadding="1">
        <caption><h2>List of ingredients</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="ing" items="${ingredients}" varStatus="status">
            <tr>
                <td><c:out value="${ing.id}" /></td>
                <td><c:out value="${ing.name}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
<%--@elvariable id="ingredient" type="ua.vlad.models.Ingredients"--%>
<form:form method="POST" action="/add" modelAttribute="ingredient">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<br/>
<a class="button" href="/">Back</a>
</body>
</html>

