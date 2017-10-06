<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>


<t:layout>
    <jsp:attribute name="title">
        ADD STARTUP
    </jsp:attribute>
    <jsp:body>
        <h2>Adding New Startup</h2>

        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>

                <hr />

                <h3>Please fill the following fields:</h3>
                <form:form commandName="startup" autocomplete="off" action="/add-startup"  method="post" class="m-t" data-toggle="validator">

                    <div class="form-group input-group has-feedback">
                        <form:input path="name" placeholder="Startup Name" class="form-control" required="true" />
                        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    </div>


                    <div class="form-group input-group has-feedback">
                        <form:input path="description" placeholder="Startup Description" class="form-control" required="true" />
                        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    </div>

                    <div class="form-group input-group has-feedback">
                        <form:input path="cost" placeholder="Cost" class="form-control" required="true" />
                        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    </div>



                    <button type="submit" class="btn btn-primary block full-width m-b">Add My Startup</button>

                </form:form>

            </div>
        </div>
    </jsp:body>
</t:layout>


