<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
    <jsp:attribute name="title">
        STARTUP-SERVICE
    </jsp:attribute>
    <jsp:body>
        <h4><b>Startups</b></h4>
        <div class="table-responsive">

            <table class="table table-striped table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Cost</th>
                    <th>CurrentSum</th>
                    <th>Image</th>
                </tr>
                <c:forEach items="${startups}" var="startup">
                    <tr>
                        <td>${startup.name}</td>
                        <td>${startup.description}</td>
                        <td>${startup.cost}</td>
                        <td>${startup.currentsum}</td>
                        <c:if test="${startup.image != null}">
                        <td><img src="/startup/imageDisplay?id=${startup.id}" class="media-object pull-left"></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>

        </div>


        <a href="/add-startup" class="btn btn-primary">Add startup</a>


    </jsp:body>
</t:layout>





