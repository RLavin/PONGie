<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 11/15/16
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update New Match</title>
</head>
<body>
Please Edit your Match data and click 'Update'!

<form action="/mvc/match/add" method="post">
    <table>
        <tr> <td>Winner:</td>              <td><input type="text" name="winner" value="<c:out value="${myEdit.winner.name}"/>"></td></tr>
        <tr><td>Winner Score:</td>          <td><input type="text" name="winningScore" value="<c:out value="${myEdit. winningScore}"/>"></td></tr>
        <tr> <td>Loser:</td>    <td><input type="text" name="loser" value="<c:out value="${myEdit.loser.name}"/>"></td></tr>
        <tr> <td>Loser Score:</td>    <td><input type="text" name="loosingScore" value="<c:out value="${myEdit.loosingScore}"/>"></td></tr>
        <tr> <td>Date:</td>              <td><input type="text" name="dates" value="<c:out value="${myEdit.dates}"/>"></td></tr>

    </table>
    <input type="submit" name="Update" />
    <input type="hidden" name="id" value="<c:out value="${myEdit.id}"/>"/>

</form>
</body>
</html>
