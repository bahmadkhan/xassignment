<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/WEB-INF/jsp/includes.jsp" %>


<c:url value="/users" var="usersUrl"/>
<c:url value="/logout" var="logoutUrl"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
    </head>

    <body>
        <sec:authorize access="hasRole('ROLE_ADMIN')" >
            <a href="${usersUrl}" >Users</a>
        </sec:authorize>
        <a href="${logoutUrl}">Logout</a> 
        <p>This is landing page</p>        
    </body>
</html>
