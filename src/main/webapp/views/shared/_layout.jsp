<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor App</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"><link rel="stylesheet" href="../css/myStyles.css">

</head>
<style >
body{

	padding: 300px;
      
            	background-image: url("https://image.freepik.com/free-photo/doctor-s-stethoscope-with-blue-background_23-2147652363.jpg");
            	

		background-position: center; 
	background-repeat: no-repeat; 
	background-size: cover; 
	height: 500px;}

}
.heavy {
  opacity: 0.9; /* النص واضح جدًا */
}

footer{
     position: fixed; 
            padding: 10px 10px 0px 10px; 
            bottom: 0; 
            left:-5px;
            width: 100%; 
            /* Height of the footer*/  
            height: 40px; 
            background: grey; 
            
            
  background-color:#26272b;
  font-size:15px;
  line-height:24px;
  color:#737373;
/* Height of the footer */
   text-align:center;
}

</style >


<body>


<div class="heavy">
<h2>${Welcome}</h2>

<a href="${appName}">Home</a>

<a href="${appName}doctor/add">Add Doctor</a>
<a href="${appName}doctor/index">Doctor</a>

<a href="${appName}appointment/add"> make Appointment</a>
<a href="${appName}appointment/index">Appointment</a>

<div style="text-align:right; float:right;">
<a href="${appName}user/login">Login</a>
<a href="${appName}user/registration">Create New Account</a>
</div>
</div>
<hr>





</body>

	
<footer>
    <p>&copy 2021 - Amanialmutairi <a href="https://www.linkedin.com/in/amani-almutairi-0b0079150/" class="text-white">@Amanii</a> </footer>	
	
	
	

</html>