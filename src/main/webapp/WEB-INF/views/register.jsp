<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Registration</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/register.css"/>" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="container">

    <div class="role-selector-wrapper">
        <div class="role-selector">
            <div class="role-selector-block">
                <label>
                    <input type="radio" name="userRole" value="1" checked>
                    <span>Developer</span>
                </label>
            </div>
            <div class="role-selector-block">
                <label>
                    <input type="radio" name="userRole" value="2">
                    <span>Investor</span>
                </label>
            </div>
        </div>
        <div class="role-selector-submit">
            <button id = "show_reg_form">Submit</button>
        </div>
    </div>




</div>


<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/register.js"/>"></script>

</body>
</html>
