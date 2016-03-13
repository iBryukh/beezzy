<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 13.03.2016
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Register</title>

    <!-- Bootstrap -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/resources/css/main_page.css">
    <style>
        .search-input {
            border-right: 0;
        }

        .search-icon {
            border-left:0 solid transparent;
            background:transparent;
        }
    </style>
</head>
<body>
<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">Cover</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <!-- check here if user logged in -->
                            <li><a href="/">Home</a></li>
                            <li class="active"><a href="/register">Register</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">Registration form</h1>
                <p class="lead">
                    <div class="input-group">
                        <span class="input-group-addon">Email:</span>
                        <input type="text" class="form-control search-input">
                    </div>
                </p>
                <p class="lead">
                    <div class="btn-group btn-group-sm" role="group" aria-label="...">
                <button type="button" class="btn btn-default">Register</button>
                    </div>
                </p>
            </div>

        </div>

    </div>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
