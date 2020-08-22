<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <h2> Spring Security Demo - HomePage</h2>
    <hr>
    <p>
        User: <security:authentication property="principal.username"/>
    </p>
    <p>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>
    <!-- Show this content only for people with "MANAGER" role -->
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <!-- Add a link for the managers' page -->
            <a href="/managers">Managers Meeting</a>
        </p>
    </security:authorize>
    <!-- Show this content only for people with "Admin" role -->
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <!-- Add a link for the admins' page -->
            <a href="/admins">Admins Meeting</a>
        </p>
    </security:authorize>
    </hr>
    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Log out"/>
    </form:form>
</body>
</html>
