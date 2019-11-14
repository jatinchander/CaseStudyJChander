<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
	<br>
	<div id="my-contact-form">
		<h1 style="text-align: center;">Contact Form</h1>
		<div class="container-fluid mt-1">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<form:form id="contactForm" modelAttribute="contactFormObj"
								action="${pageContext.request.contextPath}/saveContactForm"
								method="post" role="form">
								<div class="form-group mb-2">

									<label for="title"> Full Name </label> <input type="text"
										name="postTitle" class="form-control" id="title"
										placeholder="full name" />
								</div>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">Description</span>
									</div>
									<textarea class="form-control" name="postDescription" aria-label="With textarea"></textarea>
								</div>
								<button style="margin-bottom: 9em;" type="submit" class="btn btn-primary">Contact</button>
							</form:form>
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
