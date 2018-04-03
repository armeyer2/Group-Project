<%--
  Created by IntelliJ IDEA.
  User: real_
  Date: 4/3/2018
  Time: 03:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

</head>
<body>
<%-- TODO not sure if array is correct. --%>
<h2>Google searched for:</h2>
<a>${searchItem}</a>

<h3>Link found:</h3>
<%--<a>${imgList[2]}</a>--%>

<h3>Image found:</h3>
<img src="${imgSrc}"/>

<h3>Image Description:</h3>
<a>${imgSrc}</a>

</body>
</html>