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
            <div><img src="/developer/imageDisplay?id=${developer.id}" class="media-object pull-left"></div>
        </c:if>
        <div>Name: ${developer.username}</div>
        <div>Email: ${developer.email}</div>
        <div>Password: ${developer.password}</div>
    </jsp:body>
</t:layout>
