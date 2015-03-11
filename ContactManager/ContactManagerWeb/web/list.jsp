<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.javacourse.contact.entity.Contact" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%--<%@taglib prefix="i18n" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Contact List</title>
</head>
<body>

<c:set var="list" value="${CONTACT_LIST}"/>

<table>
    <c:forEach var="contact" items="${list}" varStatus="status">

        <c:url var="groupUrl" value="GoTo">
            <c:param name="contactId1" value="${contact.surName}"/>
            <c:param name="contactId2" value="${contact.givenName}"/>
            <c:param name="contactId3" value="${contact.email}"/>
        </c:url>

        <c:choose>
            <c:when test="${status.count%2==0}">
                <tr bgcolor="#8a2be2">
            </c:when>
            <c:otherwise>
                <tr bgcolor="yellow">
            </c:otherwise>
        </c:choose>
                <td><a href="${groupUrl}">${status.count}</a></td>
                <td>${contact.contactId}</td>
                <td>${contact.surName}</td>
                <td>${contact.givenName}</td>
                <td>${contact.email}</td>
                <td>${contact.phone}</td>
            </tr>
    </c:forEach>
</table>

<a href="add.jsp">Добавить</a>

</body>
</html>
