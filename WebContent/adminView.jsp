
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​
<div class="row" id="test">

	<h1>${allusers[1].username}test</h1>
	<div class="row" id="tripViewer">
		<ul class="collapsible popout light-green lighten-4"
			data-collapsible="accordion">


			<c:forEach var="user" items="${allusers}">
				<li>
					<div class="collapsible-header">
						<i class="material-icons"> edit</i>Edit user ${user.username}
					</div>
					<div class="collapsible-body indigo lighten-2">

						<div class="card-panel teal">
							<div class="tablerow">
								<div class="tripName">Account of ${user.username}</div>
							</div>
							<div class="editLoc">
								<form action="editAccount.do" method="POST">
									<input type="hidden" name="username" value="${user.username}">
									<button class="btn-floating btn waves-effect waves-light blue"
										type="submit">
										<i class="material-icons">mode_edit</i>
									</button>
								</form>
							</div>
							
							<div class="deleteLoc">
								<form action="deleteAccount.do" method="POST">
									<button class="btn-floating btn red" type="submit">
										<i class="material-icons right">delete</i>
									</button>
									<input type="hidden" name="trip_id" value="${trip.id}">
									<input type="hidden" name="location_id" value="${location.id}">
								</form>

							</div>

						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
		<%-- <div class ="editLoc">
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
											 --%>



	</div>
</div>
<div class="row" id="test"></div>
​ ​
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/jquery.lettering.js"></script>
<script>
	var bgColorArray = [
			'http://d1zlh37f1ep3tj.cloudfront.net/wp/wblob/54592E651337D2/17F2/273DA2/EptXfMQV2NJ71RMfjKxbFg/how-to-quit-your-job.jpg',
			'http://paulmason.name/media/demos/full-screen-background-image/background.jpg',
			'http://www.travelmediakit.com/wp-content/themes/questex-travel/images/src/bg/travel-agents.jpg'

	], selectBG = bgColorArray[Math.floor(Math.random() * bgColorArray.length)];

	$('body').css('background', 'url(' + selectBG + ')')
</script>
</body>