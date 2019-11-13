<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<%-- <br>
${user.username}
<br>
${user.password}
<br>
This is an authenticated homepage!
</body>
</html> --%>

<div id="my-home-page">
		<h1>Welcome to Good Vibes, ${user.username}!</h1>
		<a href="${pageContext.request.contextPath}/postForm">
		<button type="button" class="btn btn-secondary">Create a Post</button>
		</a>		
</div>

<jsp:include page="footer.jsp"></jsp:include>