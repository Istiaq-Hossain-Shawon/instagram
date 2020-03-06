<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Team</title>
<script>
  $(function() {
    $("#dob_date" ).datepicker();    
    $( ".selector" ).datepicker( "setDate", new Date());
    
    $("#btnRegister").click(function(event) {
		
		var username = $('#username').val();
		var name = $('#name').val();
		var password = $('#password').val();
		var confirmpassword = $('#confirmpassword').val();
		var age = $('#age').val();
		var dob_date = $('#dob_date').val();	

		$("#btnRegister").prop("disabled", true);

		$.post("/register/add", {
			username : username,
			name : name,
			password : password,
			confirmPassword : confirmpassword,
			age : age,
			dob_date : dob_date			
		}, function(data) {
			console.log(data);

			var json = JSON.parse(data);
			

		}).done(function(data) {
			console.log(data);
		}).fail(function(xhr, textStatus, errorThrown) {			
			console.log(xhr);
			console.log(textStatus);
			console.log(errorThrown);
			
		}).complete(function() {
			$("#btnRegister").prop("disabled", false);					
		});
	});
    
  });
</script>
</head>
<body>

	<h1>Register</h1>
	<form:form id="basic-form" modelAttribute="userDto">
    <div class="form-row">
			<div class="form-group col-md-6">
				<label for="courseName">User Name</label>
				<form:input path="username" class="form-control" id="username"
					placeholder="User Name..." />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-12">
				<label for="courseCode">Name</label>
				<form:input path="name" class="form-control" id="name"
					placeholder="name..." />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="password">password</label>
				<form:input path="password" class="form-control" id="password"
					placeholder="password..." />
			</div>
			<div class="form-group col-md-6">
				<label for="password">Confirm password</label>
				<form:input path="confirmPassword" class="form-control selector"
					id="confirmpassword" placeholder="confirm password..." />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="age">age</label>
				<form:input path="age" class="form-control" id="age"
					placeholder="age..." />
			</div>
			<div class="form-group col-md-2">
				<label for="dob_date">DOB</label>
				<%-- <form:input path="dob" class="form-control" id="dob"
					placeholder="dob..." /> --%>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="role">REGISTER AS</label>
				<form:select path="role" class="form-control">
					<form:option value="COACH" label="COACH" />
					<form:option value="PLAYER" label="PLAYER" />
				</form:select>
			</div>
		</div>
		<input type="submit" id="btnRegister" class="btn btn-primary" value="Register">
  
</form:form>
	
</body>
</html>
