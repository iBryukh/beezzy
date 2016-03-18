<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 14.03.2016
  Time: 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>My Shops</title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/resources/css/main_page.css">
    <link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <jsp:include page="../common/header.jsp"/>

            <div class="inner cover">
                <table class="">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                    <tr>
                        <td>1,015</td>
                        <td>sodales</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

</div>

<script src="/resources/js/jquery-2.2.1.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $('#my-shops').addClass('active');
    });
</script>
</body>
</html>
