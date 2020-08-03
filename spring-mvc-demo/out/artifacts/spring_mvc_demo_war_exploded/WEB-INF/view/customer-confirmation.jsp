<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Customer Confirmation </title>
</head>
<body>

The Customer is Confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Number of Passes: ${customer.numberOfPasses}

<br><br>

Postal Code: ${customer.postalCode}

Course Code: ${customer.courseCode}


</body>
</html>