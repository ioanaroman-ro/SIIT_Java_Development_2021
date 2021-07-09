<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Register User</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
</head>
<body>
<p>Welcome to our registration page, follow the following steps to create your account</p>
	<div class="container">
		<form class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="userName">User Name :</label>
				   <div class="col-sm-10">
					 <input type="text" class="form-control" id="userName" name="userName" value="<c:out value="${user.userName}"/>" >
			       </div>

				<label class="control-label col-sm-2" for="password">Password: </label>
				   <div class="col-sm-10">
					 <input type="password" class="form-control" id="password" name="password" value="<c:out value="${user.password}"/>" >
				   </div>
			</div>

			<c:if test="${not empty error}">
				<div class="alert alert-danger">Error: ${error}</div>
			</c:if>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

               <input type="submit" value="Submit" >

				</div>
			</div>
		</form>
	</div>

</body>
</html>
