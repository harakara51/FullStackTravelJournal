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
					<h3>${user.username} Trips</h3>
						
						
								
								<c:forEach var="trip" items="${user.trips}">
								<li>
									<div class="collapsible-header">
										<i class="material-icons">grade</i>${trip.trip_name}
										</div>
								
										<div class="collapsible-body">
											test
										<c:forEach var="location" items="${trips.locations}">	
												<p>Add location</p>	
										</c:forEach>	
										
										<form action="addlocation.do" method="POST">

						<button class="btn waves-effect waves-light blue darken-2"
							type="submit">
							Add a Location <i class="material-icons right">send</i>
						</button>
					</form>	
										</div>
									</li>
								</c:forEach>
							</table>
					</c:when>
					<c:otherwise>
						<h1>List is empty</h1>
					</c:otherwise>
				</c:choose>

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