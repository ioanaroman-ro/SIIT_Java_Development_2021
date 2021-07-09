<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Users</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
  </head>

  <body>
  	<div class="page-header">
  		<div class="pull-left">
  			Welcome ${logged_user}! This is a list of all users.
  			<a href="/logout" class="btn btn-primary">Logout</a>
  		</div>
  		<div class="clearfix"></div>
  	</div>

        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
                <th>Status</th>

            </tr>
            <c:forEach items="${users}" var="users">
                <tr>
                    <td><c:out value="${users.userid}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value="${users.userName}" /></td>
                    <td><c:out value="${users.status}" /></td>
                    <td>
                        <a href="<c:url value="/users/${users.userid}/status"/> " class="btn btn-info">Change Status</a>
                        <a href="<c:url value="/users/${users.userid}/personaldata"/> " class="btn btn-info">Change Personal Data</a>
                        <a href="<c:url value="/users/${users.userid}/resetpass"/> " class="btn btn-info">Reset password</a>
                    </td>
                </tr>
            </c:forEach>
    </table>
  </body>
</html>
