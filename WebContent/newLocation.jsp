<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​

	​
	<div class="row" id="test">

		<div class="card indigo lighten-4" id="loginCard">
			<div class="card-content white-text">

				<span class="card-title" id="cardTitle">Create new Location</span>
				<form class="col s12" action="CreateLocationDB.do" method="POST">
					<div class="row">
						<div class="input-field col s10">
							<input id="location_name" name="location_name" type="text"
							><label for="location_name">Location Name</label>
						</div>
					</div>
				
					<div class="row">
						<div class="input-field col s5">
							<input id="city" name="city" type="text"
							><label for="city">City</label>
						</div>
						
						<div class="input-field col s5">
							<input id="country" name="country" type="text"
							><label for="country">Country</label>
						</div>
					</div>
		
					<div class="row">
						<div class="input-field col s5">
						<p>Date started </p>
							<input id="date_started"  name="date_started" type="date" placeholder = "Date Started" class="datepicker"> 
							<label
								for="date_started"></label>
						</div>
					
				
						<div class="input-field col s5">
						<p>Date Ended</p>
							<input id="date_ended"  name="date_ended" type="date" class="datepicker"> 
						</div>
					</div>
				
<input type ="hidden" name ="trip_id" value="${trip_id}">

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
<!-- 	<script>
	$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
	</script> -->
</body>
<footer> </footer>