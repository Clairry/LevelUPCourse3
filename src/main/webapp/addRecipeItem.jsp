
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addRecipeItemBean" type="web.AddRecipeItemBean" scope="application"/>
<html>
<head>
    <title>RecipeItems</title>
</head>
<body>
<form method="post" action="/add-recipeItem" enctype="application/x-www-form-urlencoded">
    <h1>Add cake part</h1>
    <p>Cake:
        <select name="cake">
            <c:forEach var="cake" items="${addRecipeItemBean.cakes}">
                <option value="${cake.id}">${cake.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>Cake part:
        <select name="cakePart">
            <c:forEach var="cakePart" items="${addRecipeItemBean.cakeParts}">
                <option value="${cakePart.id}">${cakePart.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>Ingridient:
        <select name="ingridient">
            <c:forEach var="ingridient" items="${addRecipeItemBean.ingridients}">
                <option value="${ingridient.id}">${ingridient.name}</option>
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
        <c:forEach var="recipeItem" items="${addRecipeItemBean.recipeItems}">
            <tr>
                <td>${recipeItem.cake.name}</td>
                <td>${recipeItem.cakePart.name}</td>
                <td>${recipeItem.ingridient.name}</td>
                <td>${recipeItem.amount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a href="/">На главную</a>
</body>
</html>
