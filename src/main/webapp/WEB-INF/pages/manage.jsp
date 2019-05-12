<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leftdima
  Date: 11.05.2019
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
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
<h1>Manager</h1>
<form:form modelAttribute="orders" method="post">
    <table class="table-bordered twidth">
        <thead class="headertable">
        <tr>
            <th>Номер</th>
            <th>Заказ</th>
            <th>Доставка</th>
            <th>Цена</th>
            <th>ФИО</th>
            <th>Состав</th>
            <th>Статус обработки</th>
            <th>Статус доставки</th>
            <th>Отмена</th>
        </tr>
        </thead>
        <tbody class="bodytable">
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.orderDate}</td>
                <td>${order.deliveryDate}</td>
                <td>${order.orderPrice}</td>
                <td>${order.user.fullName}</td>
                <td>
                    <c:forEach items="${order.checkSet}" var="check">
                        <c:out value="${check.toString()}"/>
                        </br>
                    </c:forEach>
                </td>
                <c:if test="${order.processed == 0}">
                    <td><a href="<c:url value="/process/${order.id}"/>">Обработать</a></td>
                    <td>Не доставлен</td>
                </c:if>
                <c:if test="${order.processed == 1 && order.delivered == 0}">
                    <td>Обработан</td>
                    <td><a href="<c:url value="/delivery/${order.id}"/>">Завершить</a></td>
                </c:if>
                <c:if test="${order.processed == 1 && order.delivered == 1}">
                    <td>Обработан</td>
                    <td>Доставлен</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form:form>
</body>
</html>
