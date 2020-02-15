<%--
  Created by IntelliJ IDEA.
  User: Филипп
  Date: 30.08.2019
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
   <body>
       <form:form action="processProdForm" modelAttribute="product">
          Firm: <form:input path="firmProd" />
          <br>
          Model: <form:input path="productModel" />
          <br>
          Price: <form:input path="price" />
          <br>
          Article: <form:input path="article" />
          <br>
          <input type="submit" value="Submit" />
       </form:form>
       <br>
       <a href="${pageContext.request.contextPath}/">to Index Page</a>
   </body>
</html>