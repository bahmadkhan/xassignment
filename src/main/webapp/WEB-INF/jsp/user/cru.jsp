<%-- 
    Document   : cru
    Created on : Apr 27, 2013, 11:17:35 AM
    Author     : bilalahmad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>
<c:url value="/logout" var="logoutUrl"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Create / Update</title>
    </head>
    <body>

        <c:if test="${user.id == null}"> <%-- Check for PUT and POST --%>
            <c:set var="method" value="POST" />
        </c:if>
        <c:if test="${user.id != null}"> <%-- Check for PUT and POST --%>
            <c:set var="method" value="PUT" />
        </c:if>

        <a href="${logoutUrl}">Logout</a> 
        <h1>Create User</h1>
        <form:form method="${method}" commandName="user">

            <input type="hidden" name="_method" value="${method}"/>
            <form:hidden path="id"/>
            Name:
            <form:input path="name"/><form:errors path="name" cssClass="error"/><br />
            Email:
            <form:input path="email"/><form:errors path="email" cssClass="error"/><br />
            <c:if test="${user.id == null}"> <%-- User Canno Change Password --%>
                Password:
                <form:password path="password"/><br />
            </c:if>
            Authority:
            <form:select path="authority">
                <form:options/>
            </form:select><br />

            <input type="submit" value="Save" />
        </form:form>
    </body>
</html>
