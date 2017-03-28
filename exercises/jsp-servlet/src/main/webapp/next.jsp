<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% Calendar calendar = Calendar.getInstance(); %>
    <%= calendar.getTime().toString() %>
</body>
</html>
