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

<form:form action="/add/student-dto"
           method="post"
           modelAttribute="studentDTOModel">

    <form:errors path="*" cssClass="error" />
    <br>
    firstName<form:input path="firstName" /><br>
    lastName<form:input path="lastName" /><br>
    age<form:input path="age" /><br>
    password<form:password path="password" /><br>
    re-paccword<form:password path="passwordConfirm" /><br>

    <button type="submit">Add student</button>
</form:form>
</body>
</html>
