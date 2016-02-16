<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title>Personal website</title> ​
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

		<div class="card indigo lighten-4" id="newUser">Hello
			${user.username}</div>

		<div class="row" id="tripViewer">

			<ul class="collapsible" data-collapsible="accordion">
				<c:choose>
					<c:when test="${! empty user.trips}">
						<table id="triplist">
							<c:forEach var="trip" items="${trip}">
								<li>
									<div class="collapsible-header">
										<i class="material-icons">grade</i>${trip.name}</div> <c:forEach
										var="location" items="${location}">
										<div class="collapsible-body">
											<p>${location.locationName}</p>
										</div>
										<form action="modifylocation.do" method="POST">
											<input type="submit" name="edit" value="Edit"> <input
												type="submit" name="delete" value="Delete"> <input
												type="submit" name="view" value="View">
										</form>
									</c:forEach>
							
							</c:forEach>
						</table>
					</c:when>
				</c:choose>

				</li>
				<li>
					<div class="collapsible-header">
						<i class="material-icons">grade</i>Second
					</div>
					<div class="collapsible-body">
						 
					</div>
				</li>

			</ul>
		</div>

		<div class="row" id="test">

			<div class="card indigo lighten-4" id="addTrip"">
				<div class="card-content white-text">
					<form action="addtrip.do" method="POST">

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