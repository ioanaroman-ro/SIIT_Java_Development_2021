<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
<style>
body, html {
  height: 100%;
}
.bg {
  /* The image used */
  background-image: url("https://mdbootstrap.com/img/Photos/Horizontal/Nature/full page/img(20).jpg");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body>
    <div class="bg">
	<div class="container">
		<form class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">User:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="user" name="user" value="">
				</div>
				<label class="control-label col-sm-2" for="name">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password" value="">
				</div>
			</div>
			
			<c:if test="${not empty error}">
				<div class="alert alert-danger">Error: ${error}</div>
			</c:if>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-primary">Login</button> 
				</div>
			</div>
			<div>
				<div class="col-sm-offset-2 col-sm-10">
					<a href="<c:url value="/register"/> " class="btn btn-info">Register User</a>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>
