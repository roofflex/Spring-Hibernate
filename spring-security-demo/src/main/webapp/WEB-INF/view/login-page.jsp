<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login-Page</title>

    <style>
        .failedlogin{
            color: red;
        }
    </style>
</head>
    <body>
        <h3>Custom Login Page</h3>
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

            <!-- Check for login error and inform the user if he entered invalid username/password-->
            <c:if test="${param.error != null}">
                <i class="failedlogin">Sorry! Invalid Username/Password</i>
            </c:if> 
            <p>
                Username: <input type="text" name="username"/>
            </p>
            <p>
                Password: <input type="text" name="password"/>
            </p>
            <input type="submit" value="Log in"/>
        </form:form>
    </body>
</html>
