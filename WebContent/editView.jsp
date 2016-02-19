<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<title>Main View</title>
</head>
<jsp:include page="navBar.jsp" />​
<body id=view>
	

			<c:forEach var="image" items="${location.images}">

				<div class="col s3 halgin" id="smallbox">
					<div class="card">
					<ul id="pics">
						<div class="card-image">
						<li>
							<figure>
							<img src="${image.img_src}" />
							<figcaption><p>${image.img_text}</p></figcaption>
							</figure>
							</li>
						</div>
						</ul>
					</div>
				</div>

			</c:forEach>
		
<div class ="videos">
			<c:forEach var="video" items="${location.videos}">
				<iframe width="854" height="900"
					src="https://www.youtube.com/embed/${video.video_src}"
					frameborder="0" allowfullscreen id ="video"></iframe>
			</c:forEach>

			<c:forEach var="text" items="${location.texts}">
				<P>${text.bigtext}</P>
			</c:forEach>
</div>
<div class ="audio">
			<c:forEach var="audio" items="${location.audios}">
				<audio controls id ="aud">
					<source src="${audio.audio_src}" >
				</audio>
			</c:forEach>
</div>			
			<div class="NavButton">
			<div class ="prev">
				<form action="previousLocation.do" method="POST">
				<input
							type="hidden" name="location_id" value="${location.id}">
					<button class="btn waves-effect waves-light blue darken-2 halign"
						type="submit">
						Previous Location<i class="material-icons left">fast_rewind</i> 
					</button>
				</form>
				</div>
				<div class ="next">
				<form action="nextLocation.do" method="POST">
				 <input
							type="hidden" name="location_id" value="${location.id}">
					<button class="btn waves-effect waves-light blue darken-2 halign"
						type="submit">
						Next Location<i class="material-icons right">fast_forward</i>
					</button>
				</form>
				</div>		
</div>	 	
</body>
</html>