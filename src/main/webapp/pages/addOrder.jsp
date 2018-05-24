
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addOrderBean" type="pastryApp.web.AddOrderBean" scope="request"/>
<html>
<head>
    <title>Order</title>
</head>
<body>
<div>
    <table>
        <tbody>
        <c:forEach var="cartItem" items="${addOrderBean.cartItems}">
            <tr>
                <td>${cartItem.cake.name}</td>
                <td>${cartItem.form.name}</td>
                <td>${cartItem.amount}</td>
                <td>${cartItem.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<hr>
<form method="post" action="/add-order" enctype="application/x-www-form-urlencoded">
    <p>Date of delivery: <input required type="date" name="date"/></p>
    <p>Telephone: <input required type="text" name="telephone"/></p>
    <input type="submit"/>
</form>
<a href="/">На главную</a>
</body>
</html>
