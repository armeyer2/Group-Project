<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <h2>IT'S THE A-TEAM!</h2>
    <title>${Title}</title>
</head>
<body>
<img src="images/ateam.png" height="200px"/>
<form action="searchServlet" method="get">
    Search for image: <br>
    <input type="text" name="imageName" value="" required><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

