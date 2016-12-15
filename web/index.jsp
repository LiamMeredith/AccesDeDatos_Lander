<%-- 
    Document   : index
    Created on : 14-nov-2016, 19:09:03
    Author     : Liam-Portatil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style type="text/css">
        body {
            background-image:
                url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
        }
    </style>
    <script>
        $(document).ready(function () {
            $.get('LogInServlet', function () {
            });
        });
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
