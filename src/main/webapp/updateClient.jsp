
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Client</title>
</head>
<body>
<section>
<hr>
<jsp:useBean id="client" type="model.Client" scope="request"/>
<form method="post" action="client?action=update">
    <input type="hidden" name="id" value="${client.id}">
    <input type="hidden" name="phonenumber" value="${client.phoneNumber}">

    <dl>
        <dt>Name of client:</dt>
        <dd><input type="text" value="${client.name}" name="name"></dd>
    </dl>
    <dl>
        <dt>Description:</dt>
        <dd><input type="text" value="${client.descripment}" name="descripment"></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
</section>
</body>
</html>
