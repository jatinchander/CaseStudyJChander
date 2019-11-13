<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<div id="my-login-form">
	<h1>Login Form</h1>
	<%-- <form action='<spring:url value="/loginAction"/>' method="post">

		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" name="submit"></td>
			</tr>
		</table>
	</form> --%>
	<div class="container-fluid mt-5">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<form role="form" action='<spring:url value="/loginAction"/>'
							method="post">
							<div class="form-group">
								<label for="exampleInputEmail1"> Username </label> <input
									type="text" name="username" class="form-control"
									placeholder="username">
							</div>
							<div class="form-group">

								<label for="exampleInputPassword1"> Password </label> <input
									type="password" name="password" class="form-control"
									placeholder="password">
							</div>
							<div class="form-group"></div>
							<input type="submit" id="my-login-btn" value="submit" name="submit"
								class="btn btn-primary">
						</form>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>

<img alt="logo" src="${pageContext.request.contextPath}/images/logo.png">



	<form action='<spring:url value="/loginAction"/>' method="post">

		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html> --%>