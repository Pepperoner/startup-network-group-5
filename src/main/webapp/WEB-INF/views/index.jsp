<%@ page import="ua.goit.java.startup.bom.UserRole" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:layout>
    <jsp:attribute name="title">
        STARTUP-SERVICE
    </jsp:attribute>
    <jsp:body>
        <div>
            <form action="/search" class="navbar-form" role="search">
                <div class="input-group add-on">
                    <input class="form-control" placeholder="Search" name="keyword" id="keyword">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </form>
        </div>
        <h4><b>Startups</b></h4>
        <div id="startup-item-wrapper">
            <c:forEach items="${startups}" var="startup">
                <div class="startup-item">
                    <div class="startup-item-img">
                        <img src="/startup/imageDisplay?id=${startup.id}" class="media-object" title="Startup image">
                    </div>
                    <div class="startup-item-name">${startup.name}</div>
                    <div class="ratio-wrapper"><div class="ratio"></div></div>
                    <div class="row startup-item-footer">
                        <div class="col-sm-6 test">
                            <div class="cost-wrapper"><div class="cost-label">Cost:</div></div>
                            <div class="cost-wrapper"><div class="cost-label">${startup.cost}</div></div>
                        </div>
                        <div class="col-sm-6 test">
                            <div>Current Sum:</div>
                            <div>${startup.currentSum}</div>
                        </div>
                    </div>
                    <div class="startup-description">
                        <c:set var="descr" value="${startup.description}"/>
                        Description: ${descr.length() > 40 ? descr.substring(0, 40) : descr}...
                    </div>
                    <div>
                        <a href="<c:url value='/startup/${startup.id}'/>" class="pull-left">See more...</a>
                        <sec:authorize access="isAuthenticated()">
                            <sec:authentication property="principal.role" var="userRole"/>
                            <c:if test="${userRole.equals(UserRole.INVESTOR)}">
                                <a class="btn btn-xs btn-primary active pull-right" role="button" style="margin: 5px"
                                   href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a>
                            </c:if>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <a class="btn btn-xs btn-primary active pull-right" role="button" style="margin: 5px"
                               href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a>
                        </sec:authorize>
                    </div>
                </div>
            </c:forEach>
        </div>



    </jsp:body>
</t:layout>





