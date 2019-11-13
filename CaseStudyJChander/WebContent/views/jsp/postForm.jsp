<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<style type="text/css">
#my-post-form h1 {
	text-align: center;
}

#my-post-form button {
	margin-top: 10px;
	margin-bottom: 4.3em;
}

#my-footer {
	/*	position: absolute;
 	bottom: 0;*/
	width: 100vw;
	color: white;
	text-align: center;
	background: black;
	padding: 1em;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Regular CSS comes after bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="form.css">

<!-- This is needed in order to use font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">

<title>Good Vibes: Spreading Positivity</title>
</head>

<body>

	<!-- Start of Navbar -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a href=" " class="navbar-brand"><i class="fas fa-smile-beam mr-2"></i>Good
			Vibes</a>
		<div class="container justify-content-start">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/home">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/about">About</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/contact">Contact</a></li>
			</ul>
		</div>
		<div class="container justify-content-end">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/login">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/register">Register</a></li>

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:if>

			</ul>
		</div>
	</nav>
	<!-- End of Navbar -->

	<br>
	<div id="my-post-form">
		<h1>Post Form</h1>
		<div class="container-fluid mt-1">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<form:form id="postForm" modelAttribute="postFormObj"
								action="${pageContext.request.contextPath}/savePostForm"
								method="post" role="form">
								<div class="form-group mb-2">

									<label for="title"> Title </label> <input type="text"
										name="postTitle" class="form-control" id="title"
										placeholder="title" />
								</div>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">Description</span>
									</div>
									<textarea class="form-control" name="postDescription" aria-label="With textarea"></textarea>
								</div>


								<div class="form-check">
									<input class="form-check-input" name="happy" type="checkbox"
										value="" id="defaultCheck1"> <label
										class="form-check-label" for="defaultCheck1"> Happy </label>
								</div>

								<div class="form-check">
									<input class="form-check-input" name="motivational"
										type="checkbox" value="" id="defaultCheck2"> <label
										class="form-check-label" for="defaultCheck2">
										Motivational </label>
								</div>


								<div class="form-check">
									<input class="form-check-input" name="inspirational"
										type="checkbox" value="" id="defaultCheck3"> <label
										class="form-check-label" for="defaultCheck3">
										Inspirational </label>
								</div>


								<div class="form-check">
									<input class="form-check-input" name="feel-good"
										type="checkbox" value="" id="defaultCheck4"> <label
										class="form-check-label" for="defaultCheck4">
										Feel-Good </label>
								</div>


								<div class="form-check">
									<input class="form-check-input" name="positive" type="checkbox"
										value="" id="defaultCheck5"> <label
										class="form-check-label" for="defaultCheck5"> Positive
									</label>
								</div>


								<button type="submit" class="btn btn-primary">Post</button>
							</form:form>
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>







	<div id="my-footer">
		<p>&copy; Good Vibes 2019</p>
		<p>Designed by Jatin Chander</p>
	</div>

	<!-- Optional JavaScript -->

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>






































<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="header.jsp"></jsp:include>


<br>
<div id="my-post-form">
	<h1 id="pf">Post Form</h1>
	<div class="container-fluid mt-1">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<form role="form">
							<div class="form-group mb-2">

								<label for="title"> Title </label> <input type="text"
									name="postTitle" class="form-control" id="title"
									placeholder="title" />
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">Description</span>
								</div>
								<textarea class="form-control" aria-label="With textarea"></textarea>
							</div>


							<div class="form-check">
								<input class="form-check-input" name="happy" type="checkbox"
									value="" id="defaultCheck1"> <label
									class="form-check-label" for="defaultCheck1"> Happy </label>
							</div>

							<div class="form-check">
								<input class="form-check-input" name="motivational"
									type="checkbox" value="" id="defaultCheck2"> <label
									class="form-check-label" for="defaultCheck2">
									Motivational </label>
							</div>


							<div class="form-check">
								<input class="form-check-input" name="inspirational"
									type="checkbox" value="" id="defaultCheck3"> <label
									class="form-check-label" for="defaultCheck3">
									Inspirational </label>
							</div>


							<div class="form-check">
								<input class="form-check-input" name="feel-good" type="checkbox"
									value="" id="defaultCheck4"> <label
									class="form-check-label" for="defaultCheck4"> Feel-Good
								</label>
							</div>


							<div class="form-check">
								<input class="form-check-input" name="positive" type="checkbox"
									value="" id="defaultCheck5"> <label
									class="form-check-label" for="defaultCheck5"> Positive
								</label>
							</div>


							<button type="submit" class="btn btn-primary">Post</button>
						</form>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp"></jsp:include> --%>