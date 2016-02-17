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

<body>
	<table class=imagedisplay>
		<c:forEach var="image" items="${location.images}">
			<img src="${image.img_src}" />
		</c:forEach>
	</table>


	<c:forEach var="video" items="${location.videos}">
		<iframe width="854" height="480" src="https://www.youtube.com/embed/${video.video_src}" frameborder="0" allowfullscreen></iframe>
	</c:forEach>

	<c:forEach var="text" items="${location.texts}">
	<P>${text.bigtext}</P>
	</c:forEach>


	<c:forEach var="audio" items="${location.audios}">
		<audio controls>
			<source src="${audio.audio_src}">
	</audio>
	</c:forEach>


</body>
</html>