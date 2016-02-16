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

				<span class="card-title" id="cardTitle">Create new Trip</span>
				<form class="col s12" action="CreateTripDB.do" method="POST">
					<div class="row">
						<div class="input-field col s10">
							<input id="trip_name" name="trip_name" type="text"
							><label for="trip_name">Trip Name</label>
						</div>
					</div>
					 <div class="row">
						<div class="input-field col s10">
							<input id="date_started"  name="date_started" type="text" > <label
								for="date_started">Date Started</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s10">
							<input id="date_ended"  name="date_ended" type="text"> <label
								for="date_ended">Date Ended</label>
						</div>
					</div>
					<!-- <div class="row">
						<div class="input-field col s10">
							<input id="date_started"  name="date_started" type="date" placeholder = "Date Started" class="datepicker"> 
							<label
								for="date_started">Date Started</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s10">Date Ended
							<input id="date_ended"  name="date_ended" type="date" class="datepicker"> 
						</div>
					</div> -->


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

	​ ​
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/jquery.lettering.js"></script>
</body>
<footer> </footer>