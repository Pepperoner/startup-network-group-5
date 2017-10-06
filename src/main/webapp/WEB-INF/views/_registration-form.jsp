<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<div class="container">
    <h2>New ${userRole} Registration</h2>

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>

            <hr />

            <h3>Please fill the following fields:</h3>

            <form:form commandName="${userModel}" autocomplete="off" action="${pageContext.request.contextPath}/register/${userModel}"  method="post" class="m-t" data-toggle="validator">

                <%--<input type="hidden" name="roleList" id="roleList" value="${userRole}"/>--%>

                <div class="form-group input-group has-feedback">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <form:input path="username" placeholder="First Name" class="form-control" required="true" />
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>


                <div class="form-group input-group has-feedback">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                    <form:input path="email" type="email"
                           placeholder="Email Address" class="form-control"
                           data-error="This email address is invalid" required="true" />
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>

                <div class="form-group input-group has-feedback">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <form:input path="password" placeholder="Password" class="form-control" required="true" />
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>

                <button type="submit" class="btn btn-primary block full-width m-b">Register</button>

            </form:form>

        </div>
    </div>
</div>

