<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leftdima
  Date: 10.05.2019
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bodypage.css"/>
</head>
<body>
<nav class="top-menu">
    <ul class="menu-main">
        <li class="left-item"><a href="<c:url value="/view"/>">Домой</a></li>
        <li class="left-item"><a href="<c:url value="/myorders"/>">Управление заказами</a></li>
        <li class="right-item"><a href="<c:url value="/edit"/>">Личный Кабинет</a></li>
        <li class="right-item"><a href="">О нас</a></li>
        <li class="right-item"><a href="<c:url value="/exit"/>">Выход</a></li>
    </ul>
    <a class="navbar-logo" href=""><img src="${pageContext.request.contextPath}/resources/images/pizzalogo.png"></a>
</nav>
<form:form modelAttribute="ordersofclient" method="get">
    <h3 class="tableheadfont text-center">Средняя сумма заказа: ${stats.avgCost} Общая сумма заказов: ${stats.sumCost}
        Количество заказов: ${stats.countOfOrders}</h3>
    <h1 class="tableheadfont text-center">Список заказов</h1>
    <table class="table sizepizzas">
        <thead class="tableheadfont">
        <tr>
            <th>Дата Заказа</th>
            <th>Дата Доставки</th>
            <th>Цена</th>
            <th>Обработан</th>
        </tr>
        </thead>
        <tbody class="tablesrcfont">
        <c:forEach items="${ordersofclient}" var="order">
            <tr>
                <td>${order.orderDate}</td>
                <td>${order.deliveryDate}</td>
                <td>${order.orderPrice}</td>
                <c:if test="${order.processed == 0}">
                    <td>
                        <a href="<c:url value="/cancel/${order.id}"/>">Отменить заказ</a>
                    </td>
                </c:if>
                <c:if test="${order.processed != 0}">
                    <td>
                        Заказ уже принят
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form:form>
</body>
</html>
