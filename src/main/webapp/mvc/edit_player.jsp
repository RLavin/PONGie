<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 11/15/16
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update New Player</title>
</head>
<body>
Please Edit your Player data and click 'Update'!

<form action="/mvc/player/add" method="post">
    <table> 
        <tr> <td>Name:</td>              <td><input type="text" name="name" value="<c:out value="${myEdit.name}"/>"></td></tr> 
        <tr><td>Nickname:</td>          <td><input type="text" name="nickname" value="<c:out value="${myEdit.nickname}"/>"></td></tr> 
        <tr> <td>Wins:</td>    <td><input type="text" name="wins" value="<c:out value="${myEdit.wins}"/>"></td></tr> 
        <tr> <td>Losses:</td>    <td><input type="text" name="losses" value="<c:out value="${myEdit.losses}"/>"></td></tr> 
    </table>
    <input type="submit" name="Update" />
    <input type="hidden" name="id" value="<c:out value="${myEdit.id}"/>"/>

</form>
</body>
</html>
