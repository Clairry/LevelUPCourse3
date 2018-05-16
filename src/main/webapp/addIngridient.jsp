
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addIngridientBean" type="web.AddIngridientBean" scope="application"/>
<html>
<head>
    <title>Ingridients</title>
</head>
<body>
<form method="post" action="/add-ingridient" enctype="application/x-www-form-urlencoded">
<h1>New Ingridient</h1>
<p>Name: <input required type="text" name="name"/>  </p>

<input type="submit">
</form>

<hr>

<div>
    <table>
        <tbody>

        <c:forEach var="ingridient" items="${addIngridientBean.ingridients}">
            <tr>
                <td>${ingridient.name}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<a href="/">На главную</a>

</body>
</html>
