<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: leftdima
  Date: 12.05.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обработка заказа</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/test.css"/>
    <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script>
    <style>

        body {
            color: #afd9ee;
        }

        #map-canvas {
            width: 100%;
            height: 350px;
        }
    </style>
</head>
<body>
<div id="map-canvas"></div>
<h2 class="text-center">Адрес Клиента</h2>
<h3 class="text-center">${orderClient.user.address.fullAddress}</h3>
<h1 class="text-center">Выберите пиццерию</h1>
<table class="table-bordered twidth">
    <thead>
    <tr>
        <td>Имя</td>
        <td>Адрес</td>
        <td>Выбрать пиццерию</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pizzerias}" var="p">
        <tr>
            <td>${p.name}</td>
            <td>${p.address.fullAddress}</td>
            <td><a href="<c:url value="/processorder/${p.id}"/>">Выбрать</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script type="text/javascript">

    function initialize() {

        //центральные координаты
        var Minsk = new google.maps.LatLng(53.911553, 27.595795);

        //заполнение координат заказа
        var arrOrder = [];

        arrOrder.push(<c:out value="${orderClient.user.address.latitude}"/>);
        arrOrder.push(<c:out value="${orderClient.user.address.longitude}"/>);

        var pizzeriaObject;
        var pizzeriasObjects = [];

        <c:forEach var="pizzeria" items="${pizzerias}">
        pizzeriaObject = {
            latitude: ${pizzeria.address.latitude},
            longitude: ${pizzeria.address.longitude},
            name: '${pizzeria.name}'
        };
        pizzeriasObjects.push(pizzeriaObject);
        </c:forEach>

        //параметры карты
        var mapOptions = {
            center: Minsk,
            zoom: 13,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        //создание карты
        var map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);

        //добавление маркера заказа
        var Order = new google.maps.LatLng(arrOrder[0], arrOrder[1]);
        var markerOrder = new google.maps.Marker({
            position: Order,
            map: map,
            title: 'Адрес клиента',
        });

        markerOrder.setIcon('http://maps.google.com/mapfiles/ms/icons/blue-dot.png');

        //добавление маркеров пиццерий
        var i;

        var pizzasMarkers = [];

        for (i = 0; i < pizzeriasObjects.length; ++i) {
            pizzasMarkers.push(new google.maps.Marker({
                position: new google.maps.LatLng(pizzeriasObjects[i].latitude, pizzeriasObjects[i].longitude),
                map: map,
                title: pizzeriasObjects[i].name
            }));
            pizzasMarkers[i].setIcon('http://maps.google.com/mapfiles/ms/icons/yellow-dot.png');
        }

    }

    google.maps.event.addDomListener(window, 'load', initialize);
</script>
</body>
</html>
