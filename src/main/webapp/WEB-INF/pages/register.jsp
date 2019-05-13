<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css"/>
</head>
<body>
    <c:url var="actionUrl" value="/register"/>
<div class="form-horizontal"><h2>Регистрация личного кабинета</h2></div>
<form:form action="${actionUrl}" method="post" cssClass="form-horizontal" modelAttribute="newUser">
    <div class="form-group">
        <label class="control-label col-xs-3" for="lastName">Фамилия:</label>
        <div class="col-xs-9">
                <form:input type="text" class="form-control" id="lastName"
                            required="required" placeholder="Введите фамилию" path="surname"/>
            <br/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" for="name">Имя:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="name" required="required"
                        placeholder="Введите имя" path="name"/>
            <br/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" for="fatherName">Отчество:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="fatherName"
                        placeholder="Введите отчество" path="fathername"/>
            <br/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" for="email">Email:</label>
        <div class="col-xs-9">
            <form:input type="email" class="form-control" id="email"
                        placeholder="Введите Email" path="email"/>
            <br/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" for="login">Логин:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="login" minlength="3" maxlength="20" required="required"
                        placeholder="Введите login" path="login"/>
            <br/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-3" for="password">Пароль:</label>
        <div class="col-xs-9">
            <form:input type="password" class="form-control" id="password" minlength="7" maxlength="20"
                        placeholder="Введите пароль" path="password"/>
            <br/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" for="phoneNumber">Телефон:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="phoneNumber" required="required"
                        placeholder="Введите номер телефона" path="phone"/>
            <br/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" for="adrLocality">Населённый пункт:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="adrLocality" required="required"
                        placeholder="Введите населённый пункт" path="address.locality"/>
            <br/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-xs-3" for="street">Улица:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="street" required="required"
                        placeholder="Введите улицу" path="address.street"/>
            <br/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-xs-3" for="house">Дом:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="house" required="required"
                        placeholder="Введите дом" path="address.house"/>
            <br/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-xs-3" for="house">Квартира:</label>
        <div class="col-xs-9">
            <form:input type="text" class="form-control" id="apartment"
                        placeholder="Введите квартиру" path="address.apartment"/>
            <br/>
        </div>
    </div>


    <br/>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="Выполнить">
            <input type="reset" class="btn btn-default" value="Очистить форму">
        </div>
    </div>
</form:form>
</body>
</html>
