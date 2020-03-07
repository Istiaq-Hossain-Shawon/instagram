<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap-reboot.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap-grid.css">


	<!-- Main Styles CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/fonts.min.css">

</head>

<body class="landing-page">



<div class="content-bg-wrap" style="-webkit-animation: sidedownscroll 30s linear infinite;animation: sidedownscroll 30s linear infinite;"></div>


<!-- Header Standard Landing  -->

<div class="header--standard header--standard-landing" id="header--standard">
	<div class="container">
		<div class="header--standard-wrap">

			<a href="#" class="logo">
				<div class="img-wrap">
					<img style="width: 40px;" src="${pageContext.request.contextPath }/img/logo.png" alt="Instragram">
					
				</div>
				<div class="title-block">
					<h6 class="logo-title">Instagram</h6>
					<div class="sub-title">SOCIAL NETWORK</div>
				</div>
			</a>

			
		</div>
	</div>
</div>

<!-- ... end Header Standard Landing  -->
<div class="header-spacer--standard"></div>

<div class="container">
	<div class="row display-flex">
		<div class="col col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
			<div class="landing-content">
				<h1>Welcome to the Biggest Social  Network in the Bangladesh</h1>
				<p>We are the best and biggest social network with 5 billion active users all around the country. Share you
					thoughts, write  posts, follow  your favourit  persons, share photos and much more!
				</p>
				<!-- <a href="#" class="btn btn-md btn-border c-white">Register Now!</a> -->
			</div>
		</div>

		<div class="col col-xl-5 col-lg-6 col-md-12 col-sm-12 col-12">
			
			<!-- Login-Registration Form  -->
			
			<div class="registration-login-form">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li class="nav-item">
						<a class="nav-link active" data-toggle="tab" href="" role="tab">
						
						</a>
					</li>
					
				</ul>
			
				<!-- Tab panes -->
				<div class="tab-content">
				
			
					<div class="tab-pane active" id="profile" role="tabpanel" data-mh="log-tab">
						<div class="title h6">Register</div>
								<form:form action="${pageContext.request.contextPath }/register/new"	modelAttribute="user" enctype="multipart/form-data">
							
						
								<div class="row">
									<div class="col col-12 col-xl-12 col-lg-12 col-md-12 col-sm-12">
										
										
										<div class="form-group label-floating">
											<label class="control-label">User Name</label> 
											<input
												class="form-control" placeholder="" type="text"
												name="username">
										</div>
										<div class="form-group label-floating">
											<label class="control-label">Name</label> <input
												class="form-control" placeholder="" type="text"
												name="name">
										</div>
										
										<div class="form-group label-floating">
											<label class="control-label">Your Email</label> <input
												class="form-control" placeholder="" type="email"
												name="email">
										</div>


										<div class="form-group label-floating is-empty">
											<label class="control-label">Your Password</label> <input
												class="form-control" placeholder="" type="password"
												name="password">
										</div>
										<div class="form-group label-floating is-empty">
											<label class="control-label">Your Confirm Password</label> <input
												class="form-control" placeholder="" type="password"
												name="confirmPassword">
										</div>									
										
										
										<div class="form-row">
											<div class="form-group col-md-6">
												<label for="IMage">Image</label> <input type="file"
													name="file" />
												<%-- <form:input type="file" name="file" path="file" /> --%>
											</div>
										</div>
											<input type="submit" class="btn btn-primary btn-md-2" value="Register" style="margin-top: 5px;">
<!-- 										<button type="submit"
											class="btn btn-lg btn-primary full-width"></button> -->
									</div>
								</div>
							</form:form>
						</div>
				</div>
			</div>
			
			<!-- ... end Login-Registration Form  -->		</div>
	</div>
</div>


<!-- JS Scripts -->

<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.appear.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath }/js/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath }/js/Headroom.js"></script>

 <script src="${pageContext.request.contextPath }/js/material.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath }/js/smooth-scroll.js"></script>

<script src="${pageContext.request.contextPath }/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath }/js/base-init.js"></script>
<script defer src="${pageContext.request.contextPath }/fonts/fontawesome-all.js"></script>
 <script src="${pageContext.request.contextPath }/js/selectize.js"></script>
 <script src="${pageContext.request.contextPath }/css/Bootstrap/dist/js/bootstrap.bundle.js"></script>






</body>
</html>