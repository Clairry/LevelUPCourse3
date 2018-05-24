<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="indexBean" type="pastryApp.web.IndexBean" scope="request"/>
<html>
<head>
    <title>Catalogue</title>
</head>
<body>

<h1>Catalogue</h1>

<div>
    <p>
        <c:choose>
            <c:when test="${not empty userName}">
                Hello, ${userName}!
                <a href="/logout">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="/login">Login</a>
            </c:otherwise>
        </c:choose>
    </p>
</div>

<div>
    <table>
        <tbody>

        <c:forEach var="cake" items="${indexBean.cakes}">
            <tr>
                <td>${cake.name}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <a href="/add-ingridient">Add ingridient</a><br>
    <a href="/add-cake-part">Add cake part</a><br>
    <a href="/add-form">Add form</a><br>
    <a href="/add-recipe-item">Add recipe item</a><br>
    <a href="/add-items-to-cart">Add cart item</a><br>
    <a href="/add-order">Add order</a>
</div>
</body>
</html>
