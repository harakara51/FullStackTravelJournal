<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​
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