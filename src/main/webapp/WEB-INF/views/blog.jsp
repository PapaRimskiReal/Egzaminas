<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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

	<div class="container d-flex flex-column">
		<c:forEach items="${entryList}" var="entryList">
			<div class="d-flex flex-column">

				<div class="jumbotron">
					<h1 class="display-4 tb">${entryList.title}</h1>

					<hr class="my-4">
					<p class="tb">${entryList.text}</p>
					<a
							href=" <spring:url value="/blog/user/showEntry?id=${entryList.id}" /> "><button
								class="btn">Show more</button></a>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>