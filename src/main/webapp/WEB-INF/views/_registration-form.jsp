<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>New ${userRole} Registration</h2>

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>

            <hr />

            <h3>Please fill the following fields:</h3>

            <form autocomplete="off" action="/register" name="user" method="post" class="m-t" data-toggle="validator">

                <input type="hidden" name="roleList" id="roleList" value="${userRole}"/>

                <div class="form-group input-group has-feedback">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <input name="firstName" id="firstName" placeholder="First Name" class="form-control" required />
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>


                <div class="form-group input-group has-feedback">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                    <input type="email" name="email" id="email"
                           placeholder="Email Address" class="form-control"
                           data-error="This email address is invalid" required />
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>

                <div class="form-group input-group has-feedback">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <input name="password" id="password" placeholder="Password" class="form-control" required />
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>

                <button type="submit" class="btn btn-primary block full-width m-b">Register</button>

            </form>

        </div>
    </div>
</div>

