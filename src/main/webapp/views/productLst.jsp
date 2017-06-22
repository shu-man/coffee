<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ProductList</title>
</head>
<body>
<p>List of all products</p>

<c:forEach var="product" items="${products}">
    <table>

        <th>Name</th>
        <tr>
            <td>${product.productName}</td>
        </tr>
    </table>
</c:forEach>
</body>
</html>