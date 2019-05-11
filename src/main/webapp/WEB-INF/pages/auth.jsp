<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
</head>
<body>
<c:url var="actionUrl" value="/auth"/>
<nav class="top-menu">
    <ul class="menu-main">
        <li class="right-item"><a href="<c:url value="/register"/>">Регистрация</a></li>
    </ul>
    <a class="navbar-logo" href=""><img src="${pageContext.request.contextPath}/resources/images/pizzalogo.png"></a>
</nav>
<div class="container">
    <div class="row">
        <div class="form-horizontal">
            <form:form id ="form" action="${actionUrl}" modelAttribute="user" method="POST" acceptCharset="UTF-8"
                       cssClass="center-block">
                <span class="heading">АВТОРИЗАЦИЯ</span>
                <div class="form-group">
                    Логин: <form:input path="login" cssClass="col-xs-3 form-control" id="inputLogin" minlength="3" maxlength="20"
                                       required="required"/>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    Пароль: <form:password path="password" cssClass="col-xs-3 form-control" id="inputPass" minlength="7"
                                           maxlength="20" required="required"/>
                    <i class="fa fa-lock"></i>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">ВХОД</button>
                </div>
            </form:form>
        </div>
    </div>

</div>
</div>
</body>
</html>
