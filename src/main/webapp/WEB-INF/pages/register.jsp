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
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/resources/css/main_page.css">
</head>
<body>
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <jsp:include page="common/header.jsp"/>

            <div class="inner cover">
                <h1 class="cover-heading">Registration form</h1>
                <p class="lead">
                    <div class="input-group" style="margin-bottom: 10px;">
                        <span class="input-group-addon">Email:</span>
                        <input type="text" class="form-control">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Password:</span>
                        <input type="text" class="form-control">
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

<script src="/resources/js/jquery-2.2.1.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $('#register').addClass('active');
    });
</script>
</body>
</html>
