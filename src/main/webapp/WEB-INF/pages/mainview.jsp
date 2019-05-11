<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>ПИЦЦЫ</title>--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bodypage.css"/>--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css"/>--%>
<%--<link rel="stylesheet" href="<c:url value="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>"/>--%>
<%--<script src="https://code.jquery.com/jquery-3.3.1.js"></script>--%>
<%--<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav class="top-menu">--%>
<%--<ul class="menu-main">--%>
<%--<li class="left-item"><a href="<c:url value="/view"/>">Домой</a></li>--%>
<%--<li class="right-item"><a href="<c:url value="/edit"/>">Личный Кабинет</a></li>--%>
<%--<li class="right-item"><a href="">О нас</a></li>--%>
<%--<li class="right-item"><a href="<c:url value="/exit"/>">Выход</a></li>--%>
<%--</ul>--%>
<%--<a class="navbar-logo" href=""><img src="${pageContext.request.contextPath}/resources/images/pizzalogo.png"></a>--%>
<%--</nav>--%>
<%--<c:url var="buyaction" value="/buy"/>--%>
<%--<c:set var="counter" value="0" scope="page"/>--%>
<%--<form:form action="${buyaction}" method="post" modelAttribute="wrapper">--%>
<%--<table id="sort-table" class="table textcolor sizepizzas">--%>
<%--<tr>--%>
<%--<thead class="tableheadfont">--%>
<%--<th>Вид</th>--%>
<%--<th>Название</th>--%>
<%--<th>Цена</th>--%>
<%--<th>Вес (гр.)</th>--%>
<%--<th>Описание</th>--%>
<%--<th>Состав</th>--%>
<%--<th>Заказать</th>--%>
<%--&lt;%&ndash;<th class="col-sm-3">Вид</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th class="col-sm-1">Название</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th class="col-sm-1">Цена</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th class="col-sm-2">Вес (гр.)</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th class="col-sm-2">Описание</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th class="col-sm-2">Состав</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th class="col-sm-1">Заказать</th>&ndash;%&gt;--%>
<%--</thead>--%>
<%--</tr>--%>
<%--<tbody class="tablesrcfont">--%>
<%--<c:forEach items="${wrapper.pizzaTransformList}" var="pizza" varStatus="status">--%>
<%--<tr>--%>

<%--<td><img src="${pageContext.request.contextPath}/resources/images/${pizza.pizza.urlImage}"--%>
<%--alt='${pizza.pizza.urlImage}' class="img-rounded"/></td>--%>
<%--<td>${pizza.pizza.name}</td>--%>
<%--<td>${pizza.pizza.cost.toString()}</td>--%>
<%--<td>${pizza.pizza.size1.weight}</td>--%>
<%--<td>${pizza.pizza.description}</td>--%>
<%--<td>--%>
<%--<c:forEach items="${pizza.pizza.ingredientSet}" var="ingr">--%>
<%--<c:out value="${ingr.name}"/>--%>
<%--</c:forEach>--%>
<%--</td>--%>
<%--<td><form:checkbox cssClass="checkbox" path="pizzaTransformList[${counter}].ordered"/></td>--%>
<%--</tr>--%>
<%--<c:set var="counter" value="${counter + 1}" scope="page"/>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--<input class="center-block btn btn-outline-info btn-lg" type="submit" value="Заказать"/>--%>
<%--</form:form>--%>
<%--<script>--%>
<%--$(document).ready(function () {--%>
<%--$('#sort-table').DataTable();--%>
<%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ПИЦЦЫ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bodypage.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css"/>
    <link rel="stylesheet" href="<c:url value="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>"/>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
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
<c:url var="buyaction" value="/buy"/>
<c:set var="counter" value="0" scope="page"/>
<form:form action="${buyaction}" method="post" modelAttribute="wrapper">
    <table id="sort-table" class="table textcolor sizepizzas">
        <thead class="tableheadfont">
        <th>Вид</th>
        <th>Название</th>
        <th>Цена</th>
        <th>Вес (гр.)</th>
        <th>Описание</th>
        <th>Состав</th>
        <th>Заказать</th>
            <%--<th class="col-sm-3">Вид</th>--%>
            <%--<th class="col-sm-1">Название</th>--%>
            <%--<th class="col-sm-1">Цена</th>--%>
            <%--<th class="col-sm-2">Вес (гр.)</th>--%>
            <%--<th class="col-sm-2">Описание</th>--%>
            <%--<th class="col-sm-2">Состав</th>--%>
            <%--<th class="col-sm-1">Заказать</th>--%>
        </thead>
        <tbody class="tablesrcfont">
        <c:forEach items="${wrapper.pizzaTransformList}" var="pizza" varStatus="status">
            <tr>
                <td><img src="${pageContext.request.contextPath}/resources/images/${pizza.pizza.urlImage}"
                         alt='${pizza.pizza.urlImage}' class="img-rounded"/></td>
                <td>${pizza.pizza.name}</td>
                <td>${pizza.pizza.cost.toString()}</td>
                <td>${pizza.pizza.size1.weight}</td>
                <td>${pizza.pizza.description}</td>
                <td>
                    <c:forEach items="${pizza.pizza.ingredientSet}" var="ingr">
                        <c:out value="${ingr.name}"/>
                    </c:forEach>
                </td>
                <td><form:checkbox cssClass="center-block" path="pizzaTransformList[${counter}].ordered"/></td>
            </tr>
            <c:set var="counter" value="${counter + 1}" scope="page"/>
        </c:forEach>
        </tbody>
    </table>
    <input class="center-block btn btn-outline-info btn-lg" type="submit" value="Заказать"/>
    </br>
</form:form>
<script>
    $(document).ready(function () {
        $('#sort-table').DataTable();
    });
</script>
</body>
</html>
