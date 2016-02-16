
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​
<div class="row" id="test">

	<div class="card indigo lighten-4" id="newUser">Hello
		${user.username}</div>

	<div class="row" id="tripViewer">

		<ul class="collapsible" data-collapsible="accordion">

			<c:choose>
				<c:when test="${! empty user.trips}">
					<h3>${user.username}Trips</h3>
					<c:forEach var="trip" items="${user.trips}">
						<li>
							<div class="collapsible-header">
								<i class="material-icons">grade</i>${trip.trip_name}
							</div>

							<div class="collapsible-body indigo lighten-2">
								<table>
									<c:forEach var="location" items="${trip.locations}">
										<tr>

											<td colspan ="5">Trip to ${location.locationName}</td>
<td>
											
											</td>
											<td>
											<form action="editlocation.do" method="POST">
											<input type="hidden" name="location_id" value="${location.id}">
											<a
												class="btn-floating btn-large waves-effect waves-light blue"
												type="submit"> <i class="material-icons">mode_edit</i></a>
												</form>
												
												
											<form action="deletelocation.do" method="POST">
											<button class="btn waves-effect waves-light 
											type="submit" name="action">delete<i class="material-icons right">delete</i>
  </button>
											
											
											
											<input type="hidden" name="location_id" value="${location.id}">
											<a class="btn-floating btn-large red" type="submit">
													<i class="large material-icons">delete</i>
											</a>
											</form>
											
											</td>
										</tr>
									</c:forEach>
								</table>
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
</body>