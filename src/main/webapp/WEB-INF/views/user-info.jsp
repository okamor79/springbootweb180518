<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
<style>
    .container {
        padding: 45px;
    }
</style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <img src="data:image/png; base64, ${imageSrc}" width="250px"/>
        </div>
        <div class="col-md-6">
                <table class="table">
                    <tr>
                        <td>User name</td>
                        <td>${userInfo.userName}</td>
                    </tr>
                    <tr>
                        <td>First name</td>
                        <td>${userInfo.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last name</td>
                        <td>${userInfo.lastName}</td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${userInfo.email}</td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td>${userInfo.salary}</td>
                    </tr>
                </table>
        </div>
    </div>

</div>

</body>
</html>
