<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<t:layout>
    <jsp:attribute name="title">
        CABINET
    </jsp:attribute>
    <jsp:body>
        <h4><b>My Cabinet</b></h4>
        <c:if test="${admin.image != null}">
            <div><img src="/developer/imageDisplay?id=${admin.id}" style="width: 120px" class="media-object pull-left"></div>
        </c:if>
        <div>Name: ${admin.username}</div>
        <div>Email: ${admin.email}</div>
        <div>Password: ${admin.password}</div>
        <div>
            <h3><b>Developers</b></h3>
            <div class="table-responsive">

                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${developers}" var="developer">
                        <tr>

                                <td>${developer.username}</td>
                                <c:if test="${developer.image != null}">
                                    <td><img style="width: 200px" src="/developer/imageDisplay?id=${developer.id}" class="media-object pull-left"></td>
                                </c:if>

                                <td><a class="btn btn-xs btn-primary active delete-user" role="button" style="margin: 5px"
                                       data-id="${developer.id}" href="<c:url value='/admin/delete/developer/'/>">Delete</a></td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div>
            <h3><b>Investors</b></h3>
            <div class="table-responsive">

                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${investors}" var="investor">
                        <tr>
                            <td>${investor.username}</td>
                            <c:if test="${investor.image != null}">
                                <td><img style="width: 200px" src="/investor/imageDisplay?id=${investor.id}" class="media-object pull-left"></td>
                            </c:if>
                            <td><a class="btn btn-xs btn-primary active delete-user" role="button" style="margin: 5px"
                                   data-id="${investor.id}" href="<c:url value='/admin/delete/investor/'/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </jsp:body>
</t:layout>
