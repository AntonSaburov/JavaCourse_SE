<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Contact</title>
</head>
<body>
    <form action="addContact" method="POST">
        SurName:<input type="text" name="surName"/><br/>
        GivenName:<input type="text" name="givenName"/><br/>
        Email:<input type="text" name="email"/><br/>
        Phone:<input type="text" name="phone"/><br/>
        <input type="submit">Add</input>
    </form>
</body>
</html>
