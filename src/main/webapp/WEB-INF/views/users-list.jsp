<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>

</head>
<body>

<div class="container-fluid">

    <c:url var="lastUrl"
           value="/users/pages/search?page=${usersList.totalPages - 1}&search=${searchText.search}&minValue=${searchText.minValue}&maxValue=${searchText.maxValue}&pageSize=${searchText.pageSize}"/>
    <c:url var="nextUrl"
           value="/users/pages/search?page=${currentIndex + 1}&search=${searchText.search}&minValue=${searchText.minValue}&maxValue=${searchText.maxValue}&pageSize=${searchText.pageSize}"/>
    <c:url var="prevUrl"
           value="/users/pages/search?page=${currentIndex - 1}&search=${searchText.search}&minValue=${searchText.minValue}&maxValue=${searchText.maxValue}&pageSize=${searchText.pageSize}"/>



    <div class="col-md-2">
        <div class="row">&nbsp;</div>
        <div class="row">
            <form:form action="/users/pages/search" method="get" modelAttribute="searchText">
                Search text
                <form:input path="search" cssClass="form-control"/><br><br>
                Min <input type="number" name="minValue" min="2000" max="200000" value="${searchText.minValue}" class="form-control"/>
                <br>
                Max <input type="number" name="maxValue" min="2000" max="200000" value="${searchText.maxValue}"
                           class="form-control"/><br><br>
                <fieldset>
                    Row by page<br>
                    <form:radiobutton path="pageSize" value="5"/>5&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="pageSize" value="10" checked="checked"/>10&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="pageSize" value="15"/>15&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="pageSize" value="20"/>20&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="pageSize" value="50"/>50
                </fieldset>
                <br>
                <fieldset class="text-center">
                    <button type="submit" class="btn btn-success">Search</button>
                    <button type="reset" class="btn btn-danger">Crear</button>

                </fieldset>
            </form:form>
        </div>

    </div>
    <div class="col-xs-1"></div>
    <div class="col-md-9">
        <div class="row text-center">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${ currentIndex == 0 }">
                        <li class="disabled"><a href="#">&lt;&lt</a></li>
                        <li class="disabled"><a href="#">&lt</a></li>
                        <li class="active"><a href="${firstUrl}">1</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${firstUrl}">&lt;&lt</a></li>
                        <li><a href="${prevUrl}">&lt;</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="i" begin="${beginIndex}" end="${ endIndex }">
                    <c:url var="pageUrl"
                           value="/users/pages/search?page=${i}&search=${searchText.search}&minValue=${searchText.minValue}&maxValue=${searchText.maxValue}&pageSize=${searchText.pageSize}"/>
                    <c:choose>
                        <c:when test="${i == currentIndex }">
                            <li class="active"><a href="#">${i + 1}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageUrl}">${i + 1}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${ currentIndex + 1 == usersList.totalPages}">
                        <li class="disabled"><a href="#">&gt;</a></li>
                        <li class="disabled"><a href="#">&gt;&gt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${nextUrl}">&gt;</a></li>
                        <li><a href="${lastUrl}">&gt;&gt;</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="row">
            <table class="table table-bordered table-sm">
                <thead>
                <th class="text-center">Username</th>
                <th class="text-center">Full name</th>
                <th class="text-center">Salary</th>
                <th class="text-center">Email</th>
                </thead>
                <tbody>
                <c:forEach items="${usersPageListByPageSize}" var="user">
                    <tr>
                        <td class="text-center">${user.userName}</td>
                        <td>${user.firstName} ${user.lastName}</td>
                        <td class="text-right">${user.salary}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</body>
</html>
