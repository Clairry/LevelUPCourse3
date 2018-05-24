
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addFormBean" type="pastryApp.web.AddFormBean" scope="request"/>
<html>
<head>
    <title>Forms</title>
</head>
<body>

<form method="post" action="/add-form" enctype="application/x-www-form-urlencoded">
    <h1>Add form</h1>
    <p>Name: <input required type="text" name="name"/> </p>
    <p>Coefficient: <input required type="text" name="coeff"/></p>
    <p>Price: <input required type=text" name="price"/></p>

    <input type="submit"/>
</form>

<hr>

<div>
    <table>
        <tbody>
        <c:forEach var="form" items="${addFormBean.forms}">
            <tr>
                <td>${form.name}</td>
                <td>${form.coeff}</td>
                <td>${form.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a href="/">На главную</a>

</body>
</html>
