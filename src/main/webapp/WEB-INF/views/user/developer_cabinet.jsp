<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
    <jsp:attribute name="title">
        CABINET
    </jsp:attribute>
    <jsp:body>
        <h4><b>My Cabinet</b></h4>
        <c:if test="${developer.image != null}">
            <div><img src="/developer/imageDisplay?id=${developer.id}" style="width: 120px" class="media-object pull-left"></div>
        </c:if>
        <div>Name: ${developer.username}</div>
        <div>Email: ${developer.email}</div>
        <div>Password: ${developer.password}</div>
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
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${developer.startup}" var="startup">
                        <tr>
                            <td>${startup.name}</td>
                            <td>${startup.description}</td>
                            <td>${startup.cost}</td>
                            <td>${startup.currentsum}</td>
                            <c:if test="${startup.image != null}">
                                <td><img style="width: 200px" src="/startup/imageDisplay?id=${startup.id}" class="media-object pull-left"></td>
                            </c:if>
                            <td><a class="btn btn-xs btn-primary active" role="button" style="margin: 5px"
                                   href="<c:url value='/startup/edit/${startup.id}'/>">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>


            <a href="/add-startup" class="btn btn-primary">Add startup</a>
        </div>

    </jsp:body>
</t:layout>
