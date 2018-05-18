<%--
  Created by IntelliJ IDEA.
  User: Oleh R. Kaminskyi
  Date: 15.05.2018
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form 
        action="/add/user"
        method="post"
        modelAttribute="saveUser" >
    
    User name: <form:input path="userName" /><form:errors path="userName" /> <br>
    Password: <form:password path="password" /><form:errors path="password" /> <br>
    Confirm password: <form:password path="confirmPassword" /><form:errors path="*" /> <br>
    Email: <form:input path="email" /><form:errors path="email" /> <br>
    <button type="submit">Add user</button>
</form:form>

</body>
</html>
