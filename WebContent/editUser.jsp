<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title>Travel Journal</title> ​
<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
​
<body>

	​
	<div class="row" id="test">

		<div class="card indigo lighten-4" id="loginCard">
			<div class="card-content white-text">

				<span class="card-title" id="cardTitle">Edit User "${user.username}"
					Account</span>
				<form class="col s12" action="updateUserDB.do" method="POST">
					<div class="row">
						<div class="input-field col s10">
							<input id="username" name="username" type="text"
								class="validate" value ="${user.username}" placeholder = "<c:choose>
		<c:when test="${! empty userExist}">
			${userExist}

		</c:when>
	</c:choose>"> <label for="username">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s10">
							<input id="password"  name="password" type="text" class="validate" value ="${user.password}"> <label
								for="password">Password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s10">
							<input id="email"  name="email" type="email" class="validate" value ="${user.email}"> <label
								for="email">Email</label>
						</div>
					</div>


					<button class="btn waves-effect waves-light blue darken-2"
						type="submit">
						Submit <i class="material-icons right">send</i>
					</button>
				</form>


<div class="row">
						<div class="input-field col s12">
							<input id="email" type="hidden" class="validate"> 
						</div>
					</div>

				
			</div>
		</div>

	</div>

​ ​<jsp:include page="background.jsp" />​
</body>
<footer> </footer>