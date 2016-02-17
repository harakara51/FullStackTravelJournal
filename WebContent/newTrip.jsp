<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<jsp:include page="navBar.jsp" />​
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
	<script>
	
	var bgColorArray = ['http://d1zlh37f1ep3tj.cloudfront.net/wp/wblob/54592E651337D2/17F2/273DA2/EptXfMQV2NJ71RMfjKxbFg/how-to-quit-your-job.jpg',
	                    'http://paulmason.name/media/demos/full-screen-background-image/background.jpg',
	                    'http://www.travelmediakit.com/wp-content/themes/questex-travel/images/src/bg/travel-agents.jpg'
	                    
	                    ],
    selectBG = bgColorArray[Math.floor(Math.random() * bgColorArray.length)];
 
$('body').css('background', 'url(' + selectBG + ')')
	
	</script>
</body>
<footer> </footer>