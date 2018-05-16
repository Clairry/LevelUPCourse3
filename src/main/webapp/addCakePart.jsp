<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addCakePartBean" type="web.AddCakePartBean" scope="application"/>
<html>
<head>
    <title>Cake parts</title>
</head>
<body>
<form method="post" action="/add-cakePart" entype="application/x-www-form-urlencoded">
   <h1>Add Cake Part</h1>
   <p>Name: <input required type="text" name="name"/> </p>

    <input type="submit"/>
</form>

<hr>

<div>
    <table>
        <tbody>
        <c:forEach var="part" items="${addCakePartBean.parts}">
            <tr>
                <td>${part.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a href="/">На главную</a>

</body>
</html>
