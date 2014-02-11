

<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 09.02.14
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</html>
<!doctype html>
<jsp:useBean id="tenant" scope="request" class="model.Tenant"/>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title> Spend a holiday in New York</title>
    <!--This is a link to external css with relative address.  -->
    <link rel="stylesheet" href="../../css/style.css" />

    <!--This is an internal css. Although external css also
    has rules for tag "body", the internal css overrides them.-->
    <!--the home page background-color is a bit deeper then on other pages to draw visitor`s attention -->
    <style type="text/css">
        body {
            color: purple;
            background-color: #B7B1FA  }
    </style>


    <!--[if IE]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>



<!-- Site navigation menu -->
<ul class="navbar">
    <li><a href="/"> Home </a>
    <li><a href="pages/viewTenants"> View All Tenants </a>
    <li><a href="pages/createTenant"> Create Tenant</a>
</ul>


<!-- Main content -->
<h1>Create Tenant</h1>

<form action="/pages/createTenant" method="GET">
    Name: <input type="text" name="name">
    <br />
    Email: <input type="text" name="email" />
    <input type="submit" value="Submit" />
</form>






</body>
</html>
