<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 13.03.2016
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Home</title>
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
                <h1 class="cover-heading">Cover your page.</h1>
                <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
                <p class="lead">
                    <a href="/register" class="btn btn-lg btn-default">Start for free</a>
                </p>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/jquery-2.2.1.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $('#home').addClass('active');

        $.ajax({
            url: '/api/users/signin',
            type: 'POST',
            data: JSON.stringify({
                email: 'ivano.polomani@gmail.com',
                password: 'wergre'
            }),
            beforeSend: function(xhr){
                xhr.setRequestHeader('Content-Type', 'application/json');
            },
            success: function(response){
                console.log(response);
            },
            error: function(xhr){
                console.log(xhr);
            }
        })
    });
</script>
</body>
</html>