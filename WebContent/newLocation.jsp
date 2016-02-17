<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​ ​
<div class="row" id="test">
<form class="col s12" action="CreateLocationDB.do" method="POST" id ="form"">
	<div class="LeftSide">
		<div class="card indigo lighten-4" id="loginCard">
			<div class="card-content white-text">
				<span class="card-title" id="cardTitle">Create new Location</span>
				
					<div class="row">
						<div class="input-field col s10">
							<input id="location_name" name="location_name" type="text"  value ="Sunwell"><label
								for="location_name">Location Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s5">
							<input id="city" name="city" type="text" value ="Greenwood Village"><label
								for="city">City</label>
						</div>

						<div class="input-field col s5">
							<input id="country" name="country" type="text" value ="USA"><label
								for="country">Country</label>
						</div>
					</div>

					<div class="row">
						<div class="input-field col s5">
							<p>Date started</p>
							<input id="date_started" name="date_started" type="date"
								placeholder="Date Started" class="datepicker"> <label
								for="date_started"></label>
						</div>

						<div class="input-field col s5">
							<p>Date Ended</p>
							<input id="date_ended" name="date_ended" type="date"
								class="datepicker">
						</div>
					</div>


					<input type="hidden" name="trip_id" value="${trip_id}">

					<button class="btn waves-effect waves-light blue darken-2"
						type="submit">
						Submit <i class="material-icons right">send</i>
					</button>
			


				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="hidden" class="validate">
					</div>
				</div>


			</div>
		</div>
	</div>

	<div class="RightSide">
		<div class="card indigo lighten-4" id="loginCard2">
			<div class="card-content white-text">
				<span class="card-title" id="cardTitle">Add Images</span>
			</div>
			<div class="row">
				<div class="input-field col s10">
					<input type="text" name="img_src" id="img_src" value ="http://images4.fanpop.com/image/photos/18700000/Dragons-16falloutboy-18700713-500-313.jpg">
					<textarea rows="" cols="" name="img_txt" id="img_txt" value ="My pets fighting">
					</textarea>
				</div>
		</div>
		</div>

		<div class="card indigo lighten-4" id="loginCard2">
			<div class="card-content white-text">
				<span class="card-title" id="cardTitle">Add Video</span>
			</div>
			<div class="row">
				<div class="input-field col s10">

					<input type="text" name="video_src" id="video_src" value ="https://www.youtube.com/watch?v=HEf_xrgmuRI">
					<textarea rows="" cols="" name="video_txt" id="video_txt" value ="my Video">
					</textarea>
				</div>
			</div>
		</div>
		
		<div class="card indigo lighten-4" id="loginCard2">
			<div class="card-content white-text">
				<span class="card-title" id="cardTitle">Add Text</span>
			</div>
			<div class="row">
				<div class="input-field col s10">

					<input type="text" name="text_header" id="text_header" value ="my test">
					<textarea rows="" cols="" name="text_body" id="text_body" value ="textBody">
					</textarea>
				</div>
			</div>
		</div> 
		
		<div class="card indigo lighten-4" id="loginCard2">
			<div class="card-content white-text">
				<span class="card-title" id="cardTitle">Add Audio</span>
			</div>
			<div class="row">
				<div class="input-field col s10">

					<input type="text" name="audio_src" id="audio_src" value ="www.youtube.com">
					<textarea rows="" cols="" name="audio_text" id="audio_txt" value ="music of the web">
					</textarea>
				</div>
			</div>
		</div>
		
		


	</div>
		</form>
</div>




​ ​
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/jquery.lettering.js"></script>
<!-- 
<script>
	$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
	</script> -->
</body>
<footer> </footer>