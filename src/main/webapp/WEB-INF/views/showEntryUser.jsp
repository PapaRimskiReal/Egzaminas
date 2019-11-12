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

	<div class="container d-flex flex-column">
		<div class="jumbotron">
			<h1 class="display-4 tb">${showEntry.title}</h1>

			<hr class="my-4">
			<p class="tb">${showEntry.text}</p>
		</div>
	<c:forEach items="${EntryPropertiesList}" var="EntryPropertiesList">
	<fieldset class="comment">
		<legend class="ml-3">${EntryPropertiesList.userName}</legend>
		<p class="ml-5">${EntryPropertiesList.comment}</p>
	</fieldset>
	<c:if test="${EntryPropertiesList.answer != null}">
		<fieldset class="answer ml-5">
		<legend  class="ml-3">${EntryPropertiesList.entry.author}</legend>
		<p class="ml-5">${EntryPropertiesList.answer}</p>
		</fieldset>
	</c:if>
	</c:forEach>

	</div>
	<div class="container d-flex flex-column mt-3">
		<form:form method="POST" modelAttribute="newEntryProperties">
		<form:textarea rows="5" cols="50" path="comment" />
		<input class="btn" type="submit" value="Comment" />
		</form:form>
	</div>


</body>
</html>