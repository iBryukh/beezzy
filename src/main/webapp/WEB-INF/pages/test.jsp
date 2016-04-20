<%--
  Created by IntelliJ IDEA.
  User: oleh_kurpiak
  Date: 20.04.16
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery-2.2.1.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#upload').click(function(){
                var url = $('#url').val();
                var formData = new FormData();
                formData.append('file', $('#file')[0].files[0]);
                formData.append('id', 1);
                $.ajax({
                    url: '/api/storage/'+url,
                    type: 'POST',
                    data: formData,
                    enctype: 'multipart/form-data',
                    processData: false,
                    contentType:false,
                    success : function(response){
                        console.log(response);
                        alert('saved');
                    },
                    error : function(xhr){
                        console.log(xhr);
                        alert('error in console');
                    }
                });
            });
        });
    </script>
</head>
<body>
File: <input id="file" type="file"><br />
URL: <input id="url" type="text">('goods' or 'category')<br />
<button id="upload">Upload</button>
</body>
</html>
