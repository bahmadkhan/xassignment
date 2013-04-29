<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/WEB-INF/jsp/includes.jsp" %>
<style type="text/css">
    #loginDiv{
        padding: 20px;
    }
</style>
<div id="loginDiv">
    <h1>Login Page</h1>

    <br><br>
    <div class="section">
        <c:if test="${not empty param.login_error}">
            <div class="errors">
                Login Fail <br><br>
                Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
    </div>

    <div class="section">
        <form name="f" action="<c:url value="/loginProcess" />" method="post">
            <div style="border: white solid 1px">
                <div class="field">
                    <div class="label"><label for="j_username">Email:</label></div>
                    <div class="output">
                        <input type="text" name="j_username" id="j_username" />
                    </div>
                </div>
                <div class="field">
                    <div class="label"><label for="j_password">Password:</label></div>
                    <div class="output">
                        <input type="password" name="j_password" id="j_password" />
                    </div>
                </div>
            
                <div class="form-buttons">
                    <div class="button">
                        <input name="submit" id="submit" type="submit" value="Login" />
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>