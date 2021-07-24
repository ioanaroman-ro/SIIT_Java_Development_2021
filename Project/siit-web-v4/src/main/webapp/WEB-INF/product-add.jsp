<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Add</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
</head>
<div class="container">
		<h2>Add Product</h2>
		<c:if test="${not empty error}">
            <div class="alert alert-danger">Error: ${error}</div>
        </c:if>

	<form class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" value="<c:out value="${product.name}"/>">
				</div>
		        <label class="control-label col-sm-2" for="weight">Weight:</label>
                 <div class="col-sm-10">
                    <input type="number" step = "0.01" class="form-control" id="weight" name="weight" value="<c:out value="${product.weight}"/>">
                 </div>
		        <label class="control-label col-sm-2" for="price">Price:</label>
                 <div class="col-sm-10">
                    <input type="number" step = "0.01" class="form-control" id="price" name="price" value="<c:out value="${product.price}"/>">
                 </div>
		        <label class="control-label col-sm-2" for="url">Image URL:</label>
                 <div class="col-sm-10">
                    <input type="text" class="form-control" id="url" name="url" value="<c:out value="${product.url}"/>">
                 </div>
            </div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-primary">Save</button>
					<a href="<c:url value="/products"/>" class="btn btn-warning">Cancel</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
