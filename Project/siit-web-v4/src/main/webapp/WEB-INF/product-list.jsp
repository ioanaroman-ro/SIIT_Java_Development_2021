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
  			Welcome ${logged_user}! This is a list of all products.
  			<a href="/logout" class="btn btn-primary">Logout</a>
  			<a href="/users" class="btn btn-primary">Back to users list</a>
  		</div>
  		<div class="clearfix"></div>
  	</div>

        <table class="table table-hover">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Weight</th>
                <th>Price</th>
                <th>Image</th>

            </tr>
            <c:forEach items="${products}" var="products">
                <tr>
                    <td><c:out value="${products.id}" /></td>
                    <td><c:out value="${products.name}" /></td>
                    <td><c:out value="${products.weight}" /></td>
                    <td><c:out value="${products.price}" /></td>
                    <td><img src=<c:out value="${products.url}" /> width="150px height=150px" class="img-fluid rounded-pill"/>

                </tr>
            </c:forEach>

            <a href="<c:url value="/products/AddNewProduct"/> " class="btn btn-info">Add New Product</a>

        </table>
  </body>
</html>
