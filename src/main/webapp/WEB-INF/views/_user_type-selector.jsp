<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="role-selector-wrapper">
    <form:form id="show_reg_form" action="/registration" method="get">
        <div class="role-selector">
            <div class="role-selector-block">
                <label>
                    <input  type="radio" name="userRole" value="${developer}" checked/>
                    <span>Developer</span>
                </label>
            </div>
            <div class="role-selector-block">
                <label>
                    <input  type="radio" name="userRole" value="${investor}"/>
                    <span>Investor</span>
                </label>
            </div>
        </div>
        <div class="role-selector-submit">
            <button id = "show_reg_form_btn">Submit</button>
        </div>
    </form:form>
</div>
