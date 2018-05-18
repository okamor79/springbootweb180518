<%--
  Created by IntelliJ IDEA.
  User: Oleh R. Kaminskyi
  Date: 16.05.2018
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/students/search"
method="get"
modelAttribute="simpleModel">

    <form:input path="search" />
    <button type="submit">Search</button>

</form:form>

<ul>
    <c:forEach items="${studentsList}" var="student" >
        <li>${student.id}|${student.firstName}|${student.lastName}|${student.age}</li>
    </c:forEach>
</ul>


</body>
</html>
