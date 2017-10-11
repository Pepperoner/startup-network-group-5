<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
    <jsp:attribute name="title">
        STARTUP-SERVICE
    </jsp:attribute>
    <jsp:body>

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
                            <div>${startup.currentsum}</div>
                        </div>
                    </div>
                    <div class="startup-description">
                        <c:set var="descr" value="${startup.description}"/>
                        Description: ${descr.length() > 40 ? descr.substring(0, 40) : descr}...
                    </div>
                    <a class="btn btn-xs btn-primary active" role="button" style="margin: 5px"
                       href="<c:url value='/startup/invest/${startup.id}'/>">Invest</a>
                    <div ><a href="#">See more...</a></div>
                </div>
            </c:forEach>
        </div>



    </jsp:body>
</t:layout>





