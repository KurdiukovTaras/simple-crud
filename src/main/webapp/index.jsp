<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Главная страница смс-сервера</title>
</head>
<body>

<div id="forSearch">
    Поиск по номеру или имени
    <form  action="client" method="post">
        <input type="text" name="phoneNumber"><br/>
        <button type="submit">Выбрать</button>
        <br>
    </form>
</div>

<div id="clients">
    <iframe src="ClientImport.jsp" name="clientsName" width="240" height="600" align="left">
        Ваш браузер не поддерживает встроенные фреймы!
    </iframe>

</div>
<div id="sms">
    <iframe name="smsName" src="SmsImport.jsp" width="600" height="600" >
        Ваш браузер не поддерживает встроенные фреймы!
    </iframe>
</div>

<div id="writeSms">
    <iframe src="writeSms.jsp" name="writeSmsName" width="840" height="140" align="left">
        Ваш браузер не поддерживает встроенные фреймы!
    </iframe>
</div>



</body>
</html>
