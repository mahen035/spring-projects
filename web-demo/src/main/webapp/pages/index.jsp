<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Registration Page!" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form action="<%=request.getContextPath()%>/registration" method="post">
    Username: <input type="text" name="username" placeholder="Enter user name"><br>
    <br>
    Password: <input type="password" name="pwd" placeholder="Enter password"><br><br>
    <input type="submit" value="Register">
</form>

</body>
</html>
<%-- JSP implicit objects
1. request
2. response
3. out
4. session
5. application
6. config
7. pageContext
8. page (this)
9. exception
--%>