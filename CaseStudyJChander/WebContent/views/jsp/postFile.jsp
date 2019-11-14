<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<style>
#my-footer {
	/*	position: absolute;
 	bottom: 0;*/
	width: 100vw;
	color: white;
	text-align: center;
	background: black;
	padding: 1em;
}

#my-post-page {
	/*border: 10px solid red;*/
	text-align: center;
	/*padding: 1em;*/
}

.my-post {
	padding: 1em;
	border: 1px solid red;
	margin-bottom: 1em;
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/goodVibes.css">

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
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/home">Home</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/about">About</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/contact">Contact</a></li>
			</ul>
		</div>
		<div class="container justify-content-end">
			<ul class="nav navbar-nav">
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/login">Login</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/register">Register</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:if>

			</ul>
		</div>
	</nav>
	<!-- End of Navbar -->

	<c:forEach var="myPost" items="${allPosts}">

		<div id="my-post-page">
			<div class="my-post">
				<h1>${ myPost.postTitle }</h1>
				<p>${ myPost.postDescription }</p>
				<a href="${pageContext.request.contextPath}/comingsoon">
					<button type="button" class="btn btn-success">Edit Post</button>
				</a>
				<a href="${pageContext.request.contextPath}/comingsoon">
				<button type="button" class="btn btn-danger">Delete Post</button>
				</a>
				<a href="${pageContext.request.contextPath}/comingsoon">
				<button type="button" class="btn btn-primary">Comment</button>
				</a>
			</div>
		</div>
		<%-- 			<tr>
				<td>${ myPost.postTitle }</td>
				<td>${ myPost.postDescription }</td>
			</tr> --%>
	</c:forEach>


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