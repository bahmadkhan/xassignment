<%-- 
    Document   : list
    Created on : Apr 27, 2013, 11:51:14 AM
    Author     : bilalahmad
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>

<c:url value="/logout" var="logoutUrl"/>
<c:url value="/users/create" var="createUserUrl"/>
<c:url value="/users" var="usersUrl"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <a href="${logoutUrl}">Logout</a> 
        <h1>Users</h1>
        <a href="${createUserUrl}">Create User</a>
        <display:table id="user" name="userList" >            
            <display:column property="name" title="Name" />
            <display:column property="email" title="Email" />
            <display:column property="authority" title="Authority" />
            <display:column title="Edit">
                <a href="${usersUrl}/${user.id}/update"> Edit
                </a>
            </display:column>
            <display:column title="Delete">
                <form action="${usersUrl}/${user.id}/delete" method="POST">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" value="Delete" />
                </form>
            </display:column>
        </display:table>   
    </body>
</html>
