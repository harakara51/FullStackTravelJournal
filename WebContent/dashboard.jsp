<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title>Personal website</title> ​
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
     
​
<div class="row" id ="test">
        
          <div class="card indigo lighten-4" id="newUser">
           
           ${user.password}
            </div>

<div clas ="row" id ="tripViewer">

<ul class="collapsible" data-collapsible="accordion">
    <li>
      <div class="collapsible-header"><i class="material-icons">grade</i>First trip</div>
      <div class="collapsible-body"><p>Stuff for the first trip</p></div>
    </li>
    <li>
      <div class="collapsible-header"><i class="material-icons">grade</i>Second</div>
      <div class="collapsible-body"><p>Stuff for the Second</p></div>
    </li>
 
  </ul>
</div>
	​ ​
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/jquery.lettering.js"></script>
</body>
<footer class="page-footer">
          <div class="container">
            <div class="row">
             
                
             <div class="row" id="test">

		<div class="card indigo lighten-4" id="editTrip">
			<div class="card-content white-text">
				<form action="GetUserTravel.do" method="POST">
					<span class="card-title">Edit Trip</span>


					<button class="btn waves-effect waves-light blue darken-2"
						type="submit">
						Edit Trip <i class="material-icons right">send</i>
					</button>
				</form>


			</div>

		</div>


		<div class="card indigo lighten-4" id="addTrip"">
			<div class="card-content white-text">
				<form action="GetUserTravel.do" method="POST">
					<span class="card-title">Add Trip</span>


					<button class="btn waves-effect waves-light blue darken-2"
						type="submit">
						Add Trip <i class="material-icons right">send</i>
					</button>
				</form>
			</div>
		</div>
	</div>
                
              </div>
            </div>
          </div>
          
        </footer>