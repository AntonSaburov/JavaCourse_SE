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
    <thead>
    <tr>
        <th>ID</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Email</th>
        <th>Phone</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="contact" items="${list}" varStatus="status">
        <c:url var="delete" value="deleteContact">
            <c:param name="contactId" value="${contact.contactId}"/>
        </c:url>
        <c:url var="update" value="getContact">
            <c:param name="contactId" value="${contact.contactId}"/>
        </c:url>
        <tr>
            <td><a href="${update}">${contact.contactId}</a></td>
            <td>${contact.surName}</td>
            <td>${contact.givenName}</td>
            <td>${contact.email}</td>
            <td>${contact.phone}</td>
            <td><a href="${delete}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<a href="getContact">Добавить</a>

</body>
</html>
