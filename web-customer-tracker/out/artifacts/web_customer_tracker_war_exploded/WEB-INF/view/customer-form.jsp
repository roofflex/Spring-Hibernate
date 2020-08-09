<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Save Customer</title>

    <!-- reference our css file -->
    <spring:url value="/resources/css/style.css" var="StyleCSS"/>
    <link type="text/css" rel="stylesheet" href="${StyleCSS}"/>
    <spring:url value="/resources/css/add-customer-style.css" var="CustomerStyleCSS"/>
    <link type="text/css" rel="stylesheet" href="${CustomerStyleCSS}"/>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2><i>CRM - Customer Relationship Manager</i></h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="post" >

            <!-- need to associate data with customer id -->
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last Name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

        <p>
            <a href="/customer/list" class="backlink">Back to List</a>
        </p>

    </div>

</body>
</html>