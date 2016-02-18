
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​
<div class="row" id="test">

	<div class="row" id="tripViewer">
		<ul class="collapsible popout light-green lighten-4" data-collapsible="accordion">
			<c:choose>
				<c:when test="${! empty user.trips}">
					<h3>${user.username} 'sTrips</h3>
					<c:forEach var="trip" items="${user.trips}">
						<li>
						<!-- <div class ="Trip Header"> -->
						
						
						<div class="collapsible-header" id ="collapseHeader">
								<i class="material-icons">grade</i>${trip.trip_name}
		
							</div>
						<div class ="tripDelete">
						<form action="deleteTrip.do" method="POST">
													<button class="btn-floating btn red" type="submit">
														<i class="material-icons right">delete</i>
													</button>
													<input type="hidden" name="trip_id"
														value="${trip.id}">

												</form>
							
						</div> 
							<!-- </div> -->
							
							<div class="collapsible-body indigo lighten-2">
							
									<c:forEach var="location" items="${trip.locations}">
									
											
										
							
											
											<div class="card-panel teal">
											<div class ="tablerow">
											<div class ="tripName">
											Trip to ${location.locationName}
											</div>
											<div class ="editLoc">
												<form action="editlocation.do" method="POST">
												<input type="hidden" name="trip_id"
														value="${trip.id}">
													<input type="hidden" name="location_id"
														value="${location.id}">
													<button
														class="btn-floating btn waves-effect waves-light blue"
														type="submit">
														<i class="material-icons">mode_edit</i>
													</button>
												</form>
											</div>
											<div class ="editLoc">
												<form action="editlocations.do" method="POST">
												<input type="hidden" name="trip_id"
														value="${trip.id}">
													<input type="hidden" name="location_id"
														value="${location.id}"> 
													<button
														class="btn-floating btn waves-effect waves-light green"
														type="submit">
														<i class="material-icons">launch</i>
													</button>
												</form>
											</div>
											<div class ="deleteLoc">
													<form action="deletelocation.do" method="POST">
													<button class="btn-floating btn red" type="submit">
														<i class="material-icons right">delete</i>
													</button>
													<input type="hidden" name="trip_id"
														value="${trip.id}">
													<input type="hidden" name="location_id"
														value="${location.id}">
												</form>
											
											</div>
											
											</div>
									</div>
							
						
									</c:forEach>
								
								<form action="addlocation.do" method="POST">

									<input type="hidden" name="trip_id" value="${trip.id}">
									<button class="btn waves-effect waves-light blue darken-2"
										type="submit">
										Add a Location <i class="material-icons right">send</i>
									</button>
								</form>
							</div>
						</li>
					</c:forEach>

				</c:when>
				<c:otherwise>
					<h1>List is empty</h1>
				</c:otherwise>
			</c:choose>




		</ul>
	</div>
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
<script>


	var bgColorArray = ['http://d1zlh37f1ep3tj.cloudfront.net/wp/wblob/54592E651337D2/17F2/273DA2/EptXfMQV2NJ71RMfjKxbFg/how-to-quit-your-job.jpg',
	                    'http://paulmason.name/media/demos/full-screen-background-image/background.jpg',
	                    'http://www.travelmediakit.com/wp-content/themes/questex-travel/images/src/bg/travel-agents.jpg'
	                    
	                    ],
    selectBG = bgColorArray[Math.floor(Math.random() * bgColorArray.length)];
 
$('body').css('background', 'url(' + selectBG + ')')
	
	</script>
</body>