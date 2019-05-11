<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leftdima
  Date: 01.05.2019
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оформление заказа</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/test.css"/>
    <style>
        .headertable {
            color: #269abc;
            font-size: 25px;
        }
        .bodytable {
            color: #31b0d5;
            font-size: 18px;
        }
    </style>
</head>
<body>
<c:url var="orderaction" value="/order"/>
<c:set var="counter" value="0" scope="page"/>
<h1 class="text-center">Оформите заказ</h1>
<form:form cssClass="container" action="${orderaction}" method="post" modelAttribute="wrapper">
    <table class="table-bordered twidth">
        <thead class="headertable">
        <th class="col-md-6">Название Пиццы</th>
        <th class="col-md-3">Цена за пиццу</th>
        <th class="col-md-3">Количество</th>
        </thead>
        <tbody class="bodytable">
        <c:forEach var="item" items="${wrapper.pizzaTransformList}">
            <tr>
                <td>
                    <c:out value="${item.pizza.name}"/>
                </td>
                <td>
                    <c:out value="${item.pizza.cost.toString()}"/>
                </td>
                <td><form:input type ="number"
                                min = "1"
                                required = "true"
                                value="1"
                                cssClass="filterInput"
                                path="pizzaTransformList[${counter}].count"/>
                </td>
            </tr>
            <c:set var="counter" value="${counter + 1}" scope="page"/>
        </c:forEach>
        </tbody>
    </table>
    </br>
    <input class="btn btn-default center-block" type="submit" value="Подтвердить"/>
</form:form>


</body>
</html>
