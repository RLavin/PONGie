<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 11/14/16
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control","no-store, must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

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
                <li role="presentation"class="active"><a href="/mvc/allmatches">Matches</a></li>
                <li role="presentation"><a href="/mvc/player/selectId">Log A Match</a></li>
                <li role="presentation"><a href="/mvc/logout">Logout</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">Ping Pong Matches</h3>
    </div>



    <div class="row marketing">
        <div class="col-lg-6">
            <h4>List of Matches </h4>

            <p/>

            <table class="table">
                <thead>
                <tr>
                    <th>Edit</th>
                    <th>Winner</th>
                    <th>Winner Score</th>
                    <th>Loser</th>
                    <th>Looser Score</th>
                    <th>Date</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${all_matches}" var="aMatch">
                    <tr>
                        <td><a href="/mvc/match/select?id=<c:out value="${aMatch.id}"/>">Edit Match</a></td>
                        <td><c:out value="${aMatch.winner.name}"/></td>
                        <td><c:out value="${aMatch.winningScore}"/></td>
                        <td><c:out value="${aMatch.loser.name}"/></td>
                        <td><c:out value="${aMatch.losingScore}"/></td>
                        <td><c:out value="${aMatch.dates}"/></td>
                        <td><a href="/mvc/match/delete?id=<c:out value="${aMatch.id}"/>">Remove Match</a></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>

    <footer class="footer">
        <p>&copy; Ping Pong 2016 Company, Inc.</p>
    </footer>

</div> <!-- /container -->


</body>
</html>
