<%@ page import="java.util.List" %>
<%@ page import="com.example.webdemo.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26-02-2024
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--<% List<User> userList = (List<User>)request.getAttribute("userList"); %>--%>

        <html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>${key}</h1>--%>
<%
   String userName = null;
  Cookie[] cookies = request.getCookies();
  if(cookies != null){
      for(Cookie cookie : cookies){
          if(cookie.getName().equals("user")){
              userName = cookie.getValue();
          }
      }
  }
%>
<h1>Hello <%=userName%>, Login Successful!!</h1>

<table>
<c:forEach items="${userList}" var = "user">
    <tr>
        <td>User Name: <c:out value="${user.getUserName()}"/></td>
        <td>Password: <c:out value="${user.getPassword()}"/></td>
    </tr>
</c:forEach>
</table>
<h2>
    <c:set var="str" value="jsp tutorial"/>
    ${fn:contains(str, "jsp")}
</h2>
<c:set var = "amount" value="5478200.2315"/>
<h3>
    Formatted Amount in Indian Currency:
    <fmt:setLocale value="en_IN"/>
    <fmt:formatNumber value="${amount}" type="currency"/>
</h3>
<hr>
<form action="<%=request.getContextPath()%>/logout" method="post">
    <input type="submit" value="logout">
</form>
</body>
</html>
