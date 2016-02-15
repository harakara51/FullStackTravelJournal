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

<body>
	​
	<nav>
		<div class="nav-wrapper indigo">
			<a href="#" class="brand-logo right">Travel Journal</a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li>Hello ${user.username}</li>
				<li><a href="badges.html">View Journal</a></li>
				<li><a href="index.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>
	​
	<div class="row" id="test">

		<div class="card indigo lighten-4" id="newUser"></div>
</div>
		<div class="row" id="tripViewer">

			<ul class="collapsible" data-collapsible="accordion">
				<li>
					<div class="collapsible-header">
						<i class="material-icons">grade</i>First trip
					</div>
					<div class="collapsible-body">
						<p>Stuff for the first trip</p>
					</div>
				</li>
				<li>
					<div class="collapsible-header">
						<i class="material-icons">grade</i>Second
					</div>
					<div class="collapsible-body">
						<p>Stuff for the Second</p>
					</div>
				</li>

			</ul>
		</div>

		<div class="row" id="test">




			<div class="card indigo lighten-4" id="addTrip"">
				<div class="card-content white-text">
					<form action="GetUserTravel.do" method="POST">

						<button class="btn waves-effect waves-light blue darken-2"
							type="submit">
							Add a Trip <i class="material-icons right">send</i>
						</button>
					</form>
				</div>
			</div>
		</div>
		​ ​
		<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="js/materialize.js"></script>
		<script src="js/jquery.lettering.js"></script>
</body>