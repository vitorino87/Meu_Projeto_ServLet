<%-- 
    Document   : index2
    Created on : 23/10/2019, 17:15:37
    Author     : tiago.lucas
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>index 2</h1>
        <%= request.getParameter("teste") %>
    </body>
</html>
