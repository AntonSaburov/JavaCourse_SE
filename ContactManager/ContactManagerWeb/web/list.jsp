<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.javacourse.contact.entity.Contact"%>

<html>
<head>
    <title>Contact List</title>
</head>
<body>

    <table border="1">
<%
    List<Contact> list = (List<Contact>)request.getAttribute("CONTACT_LIST");
    for(Contact cnt : list) {
%>
        <tr>
            <td><%=cnt.getContactId() %></td>
            <td><%=cnt.getSurName() %></td>
            <td><%=cnt.getGivenName() %></td>
            <td><%=cnt.getEmail() %></td>
            <td><%=cnt.getPhone() %></td>
        </tr>
<%
    }
%>
    </table>
    <a href="add.jsp">Добавить</a>

</body>
</html>
