<%--
  Created by IntelliJ IDEA.
  User: Oleh R. Kaminskyi
  Date: 18.05.2018
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
</head>
<body>

<div class="container">

    <c:url var="firstUrl" value="/students/pages?page=0" />
    <c:url var="lastUrl" value="/students/pages?page=${ studentsList.totalPages - 1 }"/>
    <c:url var="nextUrl" value="/students/pages?page=${ currentIndex + 1 }" />
    <c:url var="prevUrl" value="/students/pages?page=${ currentIndex - 1 }" />

    <div class="container">

        <div class="row">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${ currentIndex == 0 }">
                        <li class="disabled"><a href="#">&lt;&lt</a></li>
                        <li class="disabled"><a href="#">&lt</a></li>
                        <li class="active"><a href="${firstUrl}">1</a></li>
                    </c:when>

                    <c:otherwise>
                        <li ><a href="${firstUrl}">&lt;&lt</a></li>
                        <li ><a href="${prevUrl}">&lt;</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="i" begin="${beginIndex}" end="${ endIndex }">
                    <c:url var="pageUrl" value="/students/pages?page=${i}"/>

                    <c:choose>
                        <c:when test="${i == currentIndex }">
                            <li class="active"><a href="#">${i + 1}</a></li>
                        </c:when>

                        <c:otherwise>
                            <li><a href="${pageUrl}">${i + 1}</a> </li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

                <c:choose>
                    <c:when test="${ currentIndex + 1 == studentsList.totalPages}">
                        <li class="disabled"><a href="#">&gt;</a></li>
                        <li class="disabled"><a href="#">&gt;&gt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li ><a href="${nextUrl}">&gt;</a></li>
                        <li ><a href="${lastUrl}">&gt;&gt;</a></li>
                    </c:otherwise>

                </c:choose>

            </ul>
        </div>


    <div class="row">
        <table class="table table-bordered tablse-sm">
            <thead>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Age</th>
            </thead>
            <tbody>
            <c:forEach items="${studentPageListByPageSize}" var="student">
                <%--${student}--%>
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.age}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
