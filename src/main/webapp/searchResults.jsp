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
    <title>${Title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron" align="center">
        <img class="img-responsive img-rounded" src="images/ateam_header2.png">
    </div>

    <div>
        <h2>Google searched for: <small>${searchItem}</small></h2>
    </div>
    <hr/>
    <div>
        <h3>Link found:
            <small>
                <a href="https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q=${searchItem}">
                    Google Image Search
                </a>
            </small>
        </h3>
    </div>
    <div>
        <h3>Image found:</h3>
        <img src="${imgSrc}"/>
    </div>
    <div>
        <h3>Image Description:</h3>
        <p><small>v2.0?</small></p>
    </div>
    <hr />
    <footer class="footer bg-primary" >
        <span class="align-middle">
            <div class="col-sm-6" align="center">
                <a href="/index" class="btn btn-secondary btn-lg">
                    <span class="glyphicon glyphicon-home"></span> Home
                </a>
            </div>
            <div class="col-sm-6" align="center">
                <img src="images/a_team_20.jpg" height="40%"/>
            </div>
        </span>
    </footer>
</div>
</body>
</html>