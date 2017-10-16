<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>
    <jsp:attribute name="title">
        STARTUP-SERVICE
    </jsp:attribute>
    <jsp:body>

        <h1><b> Startup name: ${startup.name}</b></h1>
        <div class="startup-item-img">
            <img style="width: 50%; height: auto" src="/startup/imageDisplay?id=${startup.id}" class="media-object" title="Startup image">
        </div>

        <div class="col-sm-6 test">
            <div class="cost-wrapper">
                <div class="cost-label">Cost:</div>
            </div>
            <div class="cost-wrapper">
                <div class="cost-label">${startup.cost}</div>
            </div>
        </div>
        <div class="col-sm-6 test">
            <div class="cost-wrapper">
                <div>Current Sum:</div>
                <div>${startup.currentsum}</div>
            </div>
        </div>

        <div class="startup-description">${startup.description}</div>

        <a class="btn btn-xs btn-primary active" role="button" style="margin: 5px"
           href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a>

        <h3><b>Developers</b></h3>
        <div class="table-responsive">

            <table class="table table-striped <%--table-bordered--%>">
                <tr>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Email</th>
                </tr>
                <c:forEach items="${developers}" var="developer">
                    <tr>
                        <td>${developer.username}</td>
                        <c:if test="${developer.image != null}">
                            <td><img style="width: 30px" src="/developer/imageDisplay?id=${developer.id}"
                                     class="media-object pull-left"></td>
                        </c:if>
                        <td>${developer.email}</td>

                    </tr>
                </c:forEach>
            </table>
        </div>


    </jsp:body>
</t:layout>





