
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client List</title>
</head>
<body>
<%--//метод doGet в сервлете ClientServlet (action=client - маппинг был в web.xml)--%>
<%--<form method="get" action="client">--%>
    <%--<button type="submit">Отобразить клиентов</button>--%>
<%--</form>--%>
        <section>
            <table rules="rows" border="0" cellpadding="8" cellspacing="0">
                <c:forEach items="${clientList}" var="client">
                    <jsp:useBean id="client" scope="page" type="model.Client"/>
                    <tr>
                        <td><a href="sms?action=showsmsbyid&id=${client.id}" target="smsName">${client.phoneNumber}</a></td>
                        <td><a href="client?action=updateclientbyid&id=${client.id}" target="smsName">${client.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>

<%--<button onclick="window.history.back()">Cancel</button>--%>
</body>
</html>
