<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@attribute name="header" fragment="true" required="false" %>
<%@attribute name="footer" fragment="true" required="false" %>
<%@attribute name="title" fragment="true" required="false" %>


<c:url var = "goToIndex" value="/" scope="request"/>
<c:url var = "goToRegister" value="/register" scope="request"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><jsp:invoke fragment="header"/></title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/site.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/signin.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/register.css"/>" rel="stylesheet">
</head>

<body>
    <div class="wrap">
        <div id="pageheader">
            <nav id="mainLogo" class="navbar-inverse navbar-fixed-top navbar">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainLogo-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <span class="navbar-brand"><a href="${goToIndex}">STARTUP</a></span>
                    </div>
                    <div id="mainLogo-collapse" class="collapse navbar-collapse">
                        <ul class="navbar-nav navbar-right nav">
                            <li class="active"><a href="${goToIndex}">Home</a></li>
                            <sec:authorize access="!isAuthenticated()">
                                <li><a href="/login">Log In</a></li>
                                <li><a id="registerLink" href="${goToRegister}">Registration</a></li>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <li><a href="<c:url value="/logout"/>">Log Out</a></li>
                                <li><sec:authentication property="principal.username" />:<sec:authentication property="principal.role" /></li>
                                <img src="<sec:authentication property="principal.image" />" alt="">
                            </sec:authorize>
                        </ul>
                    </div>
                </div>
            </nav>
            <jsp:invoke fragment="header"/>
        </div>
        <div id="body" class="container">
            <div id="content">
                <jsp:doBody/>
            </div>
        </div>
    </div>

    <footer class="footer">
        <div class="container">
            <jsp:invoke fragment="footer"/>
            <p class="pull-left">&copy; GoIT GROUP # 5</p>
            <p class="pull-right"></p>
        </div>
    </footer>

    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/register.js"/>"></script>
</body>
</html>
