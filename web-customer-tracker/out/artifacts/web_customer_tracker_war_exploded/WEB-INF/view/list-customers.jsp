<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>Customers List</title>

    <!-- reference our css file -->
    <spring:url value="/resources/css/style.css" var="StyleCSS"/>
    <link type="text/css" rel="stylesheet" href="${StyleCSS}"/>
</head>

<body>
    <div id="wrapper">
        <div id="header">
            <h2><i>CRM - Customer Relationship Manager</i></h2>
        </div>
    </div>

    <div id="container">
        <div id="content">


            <!--  add a search box -->
            <form:form action="search" method="GET">
                <!-- put button: add new customer -->

                <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
                Search customer: <input type="text" name="theSearchName" />

                <input type="submit" value="Search" class="add-button" />
            </form:form>
            <!-- add our html table -->
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>

                    <!-- loop over the List and print Customers -->
                    <c:forEach var="tempCustomer" items="${customers}">

                        <tr>
                            <!-- construct an update link with customer id -->
                            <c:url var="updateLink" value="/customer/showFormForUpdate">
                                <c:param name="customerId" value="${tempCustomer.id}"/>
                            </c:url>

                            <!-- construct a delete link with customer id -->
                            <c:url var="deleteLink" value="/customer/delete">
                                <c:param name="customerId" value="${tempCustomer.id}"/>
                            </c:url>

                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                            <!-- display the Update and Deletelink -->
                            <td><a href="${updateLink}">Update</a> |
                                <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>

            </tr>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </div>

</body>
</html>