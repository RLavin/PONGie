<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 11/15/16
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<form action="/mvc/match/add" method="post">
    <table>
        <tr> <td>Winner:</td>              <td><input type="text" name="winner" value="<c:out value="${myEdit.winner.name}"/>"></td></tr>
        <tr><td>Winner Score:</td>          <td><input type="text" name="winningScore" value="<c:out value="${myEdit. winningScore}"/>"></td></tr>
        <tr> <td>Loser:</td>    <td><input type="text" name="loser" value="<c:out value="${myEdit.loser.name}"/>"></td></tr>
        <tr> <td>Loser Score:</td>    <td><input type="text" name="loosingScore" value="<c:out value="${myEdit.loosingScore}"/>"></td></tr>
        <tr> <td>Date:</td>              <td><input type="text" name="dates" value="<c:out value="${myEdit.dates}"/>"></td></tr>

    </table>
    <input type="submit" name="Update" />
    <input type="hidden" name="id" value="<c:out value="${myEdit.id}"/>"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Latest compiled and minified CSS -->
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a href="/mvc/allplayers">Players</a></li>
                <li role="presentation"><a href="/mvc/allmatches">Matches</a></li>
                <li role="presentation"><a href="/mvc/logout">Logout</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">Update This Match</h3>
    </div>


    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Edit Match</h4>

            <form method="post" action="/mvc/match/add">
                <table class="table">
                    <tr>
                        <td>Winner:</td>
                        <td><input type="text" name="winner" value="<c:out value="${myEdit.winner.name}"/>"></td>
                    </tr>
                    <tr>
                        <td>Winner Score:</td>
                        <td><input type="text" name="winningScore" value="<c:out value="${myEdit.winningScore}"/>"></td>
                    </tr>
                    <tr>
                        <td>Loser:</td>
                        <td><input type="text" name="loser" value="<c:out value="${myEdit.loser.name}"/>"></td>
                    </tr>
                    <tr>
                        <td>Loser Score:</td>
                        <td><input type="text" name="loosingScore" value="<c:out value="${myEdit.loosingScore}"/>"></td>
                    </tr>
                    <tr>
                        <td>Date:</td>
                        <td><input type="text" name="dates" value="<c:out value="${myEdit.dates}"/>"></td>
                    </tr>

                </table>
                <div>
                    <input type="submit" name="Save"/>
                    <input type="hidden" name="id" value="<c:out value="${myEdit.id}"/>"/>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>


