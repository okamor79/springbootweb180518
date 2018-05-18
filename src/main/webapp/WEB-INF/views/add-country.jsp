<%--
  Created by IntelliJ IDEA.
  User: Oleh R. Kaminskyi
  Date: 11.05.2018
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>

    <style>
        .error {
            color:red;
        }
    </style>
</head>
<body>
add country
<form:form action="/add/country"
           method="post"
           modelAttribute="countryModel" >
    <form:input path="name" /><form:errors path="name" cssClass="error"/> <br>
    <form:input path="shortName"/><form:errors path="shortName" cssClass="error"/><br>
    <button type="submit">Add country</button>
</form:form>

</body>
</html>
