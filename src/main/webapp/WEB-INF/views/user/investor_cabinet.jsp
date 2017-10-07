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
    </jsp:body>
</t:layout>
