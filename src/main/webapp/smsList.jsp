<%--<%@ page import="smsServer.web.sms.SmsRestController" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        .new {color:green}
        /*.old {color: orangered}*/
        .in  {text-align: left;
            color: orangered
        }
        .out {text-align: right;
              color: blue
        }
    </style>
    <title>Sms - server</title>
</head>
<body>

<section>
    <table rules="rows" valign="top"  width=100% border="0" cellpadding="5" cellspacing="5">

        <c:forEach items="${smsList}" var="sms">
            <jsp:useBean id="sms" scope="page" type="model.Sms"/>
            <tr class="${sms.in_out?'in':'out'}">
                <td height="50" class="${sms.readed?'new':'old'}"><h4>${sms.message}</h4>
                    <h6><a href="sms?action=showsmsbyid&id=${sms.clientId}">Показать смски от клиента </a> ${sms.datetime} </h6>
                </td>
            </tr>

        </c:forEach>
    </table>
</section>


<%--<button onclick="window.history.back()">Cancel</button>--%>
</body>
</html>
