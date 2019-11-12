<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="/resources/app.css" rel="stylesheet" type="text/css" />
<title>Examination</title>
</head>

<body>
	<nav class="navbar navbar-expand fixed-top justify-content-between">

		<ul class="navbar-nav mr-auto d-flex flex-row ">
			<li class="nav-item mr-3 btn"><a href="/blog/admin">Admin</a></li>
			<li class="nav-item mr-3 btn"><a href="/blog/registration">Registration</a></li>

			<li class="nav-item mr-3 btn"><a href="<c:url value="/logout"/>">Logout</a></li>

		</ul>

	</nav>


	<div class="mt-5">
		<form:form method="POST" modelAttribute="Oldentry">
			<div class="container d-flex flex-column">
				<div>
					<label>Title</label>
				</div>
				<div>
					<%-- <form:input path="title" type="text" value="${Oldentry.title}"/> --%>
					<form:input path="title" type="text"/>
				</div>
				<div>

					<label>Text</label>
				</div>
				<div>
					<form:textarea rows="10" cols="100" path="text" type="text"/>
			
				</div>
				<div>
					<input class="btn" type="submit" value="Done" />
				</div>
			</div>
		</form:form>
	</div>



</body>
</html>