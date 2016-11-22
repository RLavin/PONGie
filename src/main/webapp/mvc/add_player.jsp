<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 11/15/16
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Player</title>
</head>
<body>
Please input your Player data and click 'Save'!

<form action="/mvc/player/add" method="post">
    <table>
        <tr> <td>Name:</td>              <td><input type="text" name="name"></td></tr>
        <tr><td>Nickname:</td>          <td><input type="text" name="nickname"></td></tr>
    </table>
    <input type="submit" name="save" />

</form>
</body>
</html>

