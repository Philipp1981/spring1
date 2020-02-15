<%--
  Created by IntelliJ IDEA.
  User: Филипп
  Date: 30.08.2019
  Time: 23:16
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


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
   <body>
      <h1>Product Form Result</h1>
      <br>
      Firm: ${product.firmProd}
      <br>
      Model: ${product.productModel}
      <br>
      Price: ${product.price}
      <br>
      Article: ${product.article}
      <br>
      <a href="${pageContext.request.contextPath}/">to Index Page</a>
   </body>
</html>