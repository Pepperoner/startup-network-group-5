<%@ page import="ua.goit.java.startup.bom.UserRole" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:layout>
    <jsp:attribute name="title">
        ${startup.name}
    </jsp:attribute>
    <jsp:body>

        <h1>Startup name: ${startup.name}</h1>

        <div class="row">
            <div class="col-sm-6">
                <c:if test="${startup.image != null}">
                    <div><img src="/startup/imageDisplay?id=${startup.id}" style="width: 300px" class="media-object pull-left" title="Startup image"></div>
                </c:if>
            </div>
            <div class="col-sm-6">
                <div>Cost: ${startup.cost}</div>
                <div>Current Sum: ${startup.currentSum}</div>
                <div>
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.role" var="userRole"/>
                        <c:if test="${userRole.equals(UserRole.INVESTOR)}">
                            <a class="btn btn-xs btn-primary active" role="button" style="margin: 5px"
                               href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a>
                        </c:if>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a class="btn btn-xs btn-primary active" role="button" style="margin: 5px"
                           href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="startup-description">${startup.description}</div>
        </div>


        <h3><b>Developers</b></h3>
        <div class="table-responsive">

            <table class="table table-striped">
                <tr>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Email</th>
                </tr>
                <c:forEach items="${developers}" var="developer">
                    <tr>
                        <td>${developer.username}</td>
                        <c:if test="${developer.image != null}">
                            <td>
                                <img style="width: 30px" src="/developer/imageDisplay?id=${developer.id}" class="media-object pull-left">
                            </td>
                        </c:if>
                        <td>${developer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>


    </jsp:body>
</t:layout>





