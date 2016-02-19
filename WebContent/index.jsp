<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title> Travel Journal</title> ​
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
<div class ="test">
</div>

 <div class="card cyan" id="loginCard2">
			<div class="card-content white-text">
				<form action="GetUserTravel.do" method="POST">
					<span class="card-title" id ="cardTitle">Login</span>
					
					 <input type="text" name="username" placeholder = "<c:choose>
		<c:when test="${! empty userNotFound}">
			${userNotFound}

		</c:when>
	</c:choose>"> 
					 <input type="password" name="password" >

					
						<button class="btn waves-effect waves-light deep-orange"
							type="submit">
							Submit <i class="material-icons right">send</i>
						</button>
				</form>
				
				<form action="CreateUserTravel.do" method="POST">
					<button class="btn waves-effect waves-light deep-orange"
						type="submit">
						Create new user <i class="material-icons right">send</i>
					</button>
				</form>
			</div>
		</div>


	​
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/jquery.lettering.js"></script>
	<script>
	
	var bgColorArray = [
	        			'http://d1zlh37f1ep3tj.cloudfront.net/wp/wblob/54592E651337D2/17F2/273DA2/EptXfMQV2NJ71RMfjKxbFg/how-to-quit-your-job.jpg',
	        			,

	        			'http://www.travelmediakit.com/wp-content/themes/questex-travel/images/src/bg/travel-agents.jpg',
	        			'http://i.imgur.com/5bywvWg.jpg', 'http://i.imgur.com/CVEXAQ1.jpg',

	        			'http://i.imgur.com/RMdtSHn.jpg', 'http://i.imgur.com/9512jWc.jpg',

	        			'http://i.imgur.com/pOVZsKS.jpg', 'http://i.imgur.com/pXURamd.jpg',

	        			, 'http://i.imgur.com/ahibdwm.jpg',

	        			, 'http://i.imgur.com/67nMKP4.jpg',

	        			'http://i.imgur.com/OuLAf6I.jpg', 'http://i.imgur.com/EPavdJn.jpg',
	        			, 'http://i.imgur.com/pWbzdXg.jpg',

	        			'http://i.imgur.com/VVBsGx8.png', 'http://i.imgur.com/vEw2aAz.jpg',
	        			'http://i.imgur.com/ZExuz3L.jpg',

	        	],
    selectBG = bgColorArray[Math.floor(Math.random() * bgColorArray.length)];
 
$('body').css('background', 'url(' + selectBG + ')', 'background-size', 'cover','background-repeat', 'no-repeat')
	
	</script>
</body>
<footer> </footer>