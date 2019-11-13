<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp"></jsp:include>
<br>
<div id="my-register-form">
	<h1>Register</h1>
	<div class="container-fluid mt-1">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<form:form id="userCredentialForm"
							modelAttribute="userRegistrationObj"
							action="processUserCredentials" method="POST" role="form">
							<div class="form-group mb-2">

								<form:label path="userProfile.firstName" for="firstName">
								First Name
							</form:label>
								<form:input path="userProfile.firstName" type="text"
									class="form-control" id="firstName" placeholder="first name" />
							</div>
							<div class="form-group mb-2">

								<form:label path="userProfile.lastName" for="lastName">
								Last Name
							</form:label>
								<form:input path="userProfile.lastName" type="text"
									class="form-control" id="lastName" placeholder="last name" />
							</div>
							<div class="form-group mb-2">

								<form:label path="userProfile.email" for="email">
								Email
							</form:label>
								<form:input path="userProfile.email" type="email"
									class="form-control" id="email" placeholder="email" />
							</div>
							<div class="form-group mb-2">

								<form:label path="username" for="username">
								Username
							</form:label>
								<form:input path="username" type="text"
									class="form-control" id="username" placeholder="username" />
							</div>
							<div class="form-group mb-2">

								<form:label path="password" for="password">
								Password
							</form:label>
								<form:input path="password" type="password" class="form-control"
									id="password" placeholder="password" />
							</div>
							<div class="form-group mb-2">

								<label for="confirmPassword"> Re-Type Password </label> <input
									type="password" class="form-control" name="confPassword"
									id="confirmPassword" placeholder="Confirm password" />
							</div>
							<form:button name="Login" id="Login" type="submit"
								class="btn btn-primary">
							Register
						</form:button>
						</form:form>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<!-- </body>
</html> -->