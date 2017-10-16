<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
    <jsp:attribute name="title">
        CABINET
    </jsp:attribute>
    <jsp:body>
        <h4><b>My Cabinet</b></h4>
        <c:if test="${investor.image != null}">
            <div><img src="/investor/imageDisplay?id=${investor.id}" class="media-object pull-left"></div>
        </c:if>
        <div>Name: ${investor.username}</div>
        <div>Email: ${investor.email}</div>
        <div>Password: ${investor.password}</div>
        <div>Total amount of the invest: ${investor.paidCost}</div>


        <div>
            <h3><b>My Startups</b></h3>
            <div class="table-responsive">

                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Cost</th>
                        <th>CurrentSum</th>
                        <th>Image</th>
                        <th>Invest</th>
                    </tr>
                    <c:forEach items="${investor.startup}" var="startup">
                        <tr>
                            <td>${startup.name}</td>
                            <td>${startup.description}</td>
                            <td>${startup.cost}</td>
                            <td>${startup.currentSum}</td>
                            <c:if test="${startup.image != null}">
                                <td><img style="width: 200px" src="/startup/imageDisplay?id=${startup.id}" class="media-object pull-left"></td>
                            </c:if>
                            <td><a class="btn btn-xs btn-primary active" role="button" style="margin: 5px"
                                   href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>

    </jsp:body>
</t:layout>
