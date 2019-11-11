<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="/resources/app.css" rel="stylesheet" type="text/css" />
<title>Registracija</title>
</head>
<body>

	<section class="container">

		<form:form method="POST" modelAttribute="newLogin">
		<form:errors path="*" element="div"/>
			<fieldset>
				<legend>Naujas Vartotojas:</legend>

				<div>
					<label for="login">Login</label>
					<form:input id="login" path="login" type="text" />
				</div>
				
				<div>
					<label for="password">Password</label>
					<form:input id="password" path="password" type="text" />
					<form:errors path="password" />
				</div>

				<input type="submit" value="Done" />


			</fieldset>

		</form:form>

	</section>

</body>
</html>