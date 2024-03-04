<%@ page import="com.training.springmvc.model.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
<h1>Hello from JSP!!</h1>
<hr>
<% List<Product> prodList = (List<Product>)request.getAttribute("prodList");%>
<h2><%= prodList.get(0).getProdName()%></h2>
</body>
</html>
