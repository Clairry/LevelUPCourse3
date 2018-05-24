<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addCartItemBean" type="pastryApp.web.AddCartItemBean" scope="request"/>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<form method="post" action="/add-items-to-cart" enctype="application/x-www-form-urlencoded">
    <h1>Add cakes to cart</h1>
    <p>Cake:
        <select name="cake">
            <c:forEach var="cake" items="${addCartItemBean.cakes}">
                <option value="${cake.id}">${cake.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>Form:
        <select name="form">
            <c:forEach var="form" items="${addCartItemBean.forms}">
                <option value="${form.id}">${form.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>Amount: <input required type="text" name="amount"/></p>
    <input type="submit"/>
</form>
<hr>
<div>
    <table>
        <tbody>
        <c:forEach var="cartItem" items="${addCartItemBean.cartItems}">
        <tr>
            <td>${cartItem.cake.name}</td>
            <td>${cartItem.form.name}</td>
            <td>${cartItem.amount}</td>
            <td>${cartItem.price}</td>
            <td>${cartItem.user}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<a href="/">Home</a><br>
<a href="/add-order">Add order</a>
</body>
</html>
