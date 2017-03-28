<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Titeltje voor alle items</title>
</head>
<body>
    <c:forEach items="${all}" var="current">
        <li>${current.sku}</li>
    </c:forEach>
</body>
</html>
