<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Startups</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/site.css"/>" rel="stylesheet">
</head>
<body>



    <div class="wrap">

        <nav id="mainLogo" class="navbar-inverse navbar-fixed-top navbar">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainLogo-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <span class="navbar-brand" href="/">STARTUP</span>
                </div>
                <div id="mainLogo-collapse" class="collapse navbar-collapse">
                    <ul class="navbar-nav navbar-right nav">
                        <li class="active"><a href="#">Home</a></li>
                        <sec:authorize access="!isAuthenticated()">
                            <li><a href="<c:url value="/login"/>">Log In</a></li>
                            <li><a href="<c:url value="/register"/>">Registration</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li><a href="<c:url value="/logout"/>">Log Out</a></li>
                            <li><sec:authentication property="principal.username" />:<sec:authentication property="principal.role" /></li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </nav>



        <div class="container">
            Some info
            <h4><b>Startups</b></h4>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Cost</th>
                        <th>CurrentSum</th>
                    </tr>
                    <c:forEach items="${startups}" var="startup">
                        <tr>
                            <td>${startup.name}</td>
                            <td>${startup.description}</td>
                            <td>${startup.cost}</td>
                            <td>${startup.currentsum}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <a href="/add-startup" class="btn btn-primary">Add startup</a>
        </div>


    </div>
    <footer class="footer">
        <div class="container">
            <p class="pull-left">&copy; GoIT GROUP # 5</p>
            <p class="pull-right"></p>
        </div>
    </footer>


    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>
