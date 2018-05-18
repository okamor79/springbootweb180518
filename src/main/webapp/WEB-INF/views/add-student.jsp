<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp" %>

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
add student

<form:form action="/add/student"
           method="post"
           modelAttribute="studentModel">

    <form:errors path="*" cssClass="error" />
<br>
<form:input path="firstName" /><br>
<form:input path="lastName" /><br>
<form:input path="age" /><br>
<form:select path="country">
    <form:options items="${countries}"  itemLabel="name"/>
</form:select> <br>
    <button type="submit">Add student</button>
</form:form>
</body>
</html>
