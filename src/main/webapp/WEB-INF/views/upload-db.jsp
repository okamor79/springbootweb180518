<%--
  Created by IntelliJ IDEA.
  User: Oleh R. Kaminskyi
  Date: 21.05.2018
  Time: 19:23
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
 <form action="/upload/db" method="post" enctype="multipart/form-data">
     <input type="file" name="imageFile" />
     <button type="submit">Upload</button>
 </form>
</body>
</html>
