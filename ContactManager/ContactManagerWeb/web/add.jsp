<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Contact</title>
</head>
<body>
    <form action="addContact" method="POST">
        <input type="hidden" name="contactId" value="${CONTACT.contactId}">
        SurName:<input type="text" name="surName" value="${CONTACT.surName}"/><br/>
        GivenName:<input type="text" name="givenName"  value="${CONTACT.givenName}"/><br/>
        Email:<input type="text" name="email" value="${CONTACT.email}"/><br/>
        Phone:<input type="text" name="phone" value="${CONTACT.phone}"/><br/>
        <input type="submit" value="Add/Update"/>
    </form>
</body>
</html>
