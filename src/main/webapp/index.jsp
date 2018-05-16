<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="indexBean" type="web.IndexBean" scope="application"/>
<html>
<head>
    <title>Catalogue</title>
</head>
<body>

<h1>Catalogue</h1>

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

    <a href="addIngridient.jsp">Add ingridient</a><br>
    <a href="addCakePart.jsp">Add cake part</a><br>
    <a href="addForm.jsp">Add form</a><br>
    <a href="addRecipeItem.jsp">Add recipe item</a>
</div>
</body>
</html>
