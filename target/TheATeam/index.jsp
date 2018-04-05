<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${Title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
    <img src="images/ateam.png" height="200px"/>
    </div>
    <form action="searchServlet" method="get">
        <div class="form-inline">
            <div class="form-group">
                <input type="text" name="imageName" value="" required id="imageName" class="form-control input-lg" placeholder="Search for Image">
                <input type="submit" value="Submit" class="btn btn-info btn-lg">
            </div>
        </div>
    </form>
    </div>
</div>
</body>
</html>

