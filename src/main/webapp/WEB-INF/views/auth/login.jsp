<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%--     <link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/login.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery.js"></script> --%>
</head>
<style>
.landing-page .content-bg-wrap {       
    -webkit-animation: sidedownscroll 30s linear infinite;
    animation: sidedownscroll 30s linear infinite;
}
</style>
<body class="landing-page">



<div class="content-bg-wrap" style="-webkit-animation: sidedownscroll 30s linear infinite;animation: sidedownscroll 30s linear infinite;"></div>


<!-- Header Standard Landing  -->

<div class="header--standard header--standard-landing" id="header--standard">
	<div class="container">
		<div class="header--standard-wrap">

			<a href="#" class="logo">
				<div class="img-wrap">
					<img src="${pageContext.request.contextPath }/img/logo.png" alt="Olympus">
					<img src="${pageContext.request.contextPath }/img/logo-colored-small.png" alt="Olympus" class="logo-colored">
				</div>
				<div class="title-block">
					<h6 class="logo-title">Cricbean</h6>
					<div class="sub-title">SPORTS NETWORK</div>
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
				<h1>Welcome to the Biggest Sports Network in the Bangladesh</h1>
				<p>We are the best and biggest social network with 5 billion active users all around the country. Share you
					thoughts, write blog posts, show your favourite music via Stopify, earn badges and much more!
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
						<div class="title h6">Login to your Account</div>
							<form class="content"
								action="${pageContext.request.contextPath }/login-processing"
								method="POST">
								<div class="row">
									<div class="col col-12 col-xl-12 col-lg-12 col-md-12 col-sm-12">
										<div class="form-group label-floating is-empty">
											<label class="control-label">Your Email</label> <input
												class="form-control" placeholder="" type="text"
												name="username">
										</div>
										<div class="form-group label-floating is-empty">
											<label class="control-label">Your Password</label> <input
												class="form-control" placeholder="" type="password"
												name="password">
										</div>
										<c:if test="${error == 'true'}">
											<div class="alert alert-danger" role="alert">Wrong
												username or password</div>
										</c:if>
										<button type="submit"
											class="btn btn-lg btn-primary full-width">Login</button>
									</div>
								</div>
							</form>
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
<%-- <script src="${pageContext.request.contextPath }/js/jquery.matchHeight.js"></script>
<script src="${pageContext.request.contextPath }/js/svgxuse.js"></script>
<script src="${pageContext.request.contextPath }/js/imagesloaded.pkgd.js"></script>

<script src="${pageContext.request.contextPath }/js/velocity.js"></script>
<script src="${pageContext.request.contextPath }/js/ScrollMagic.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.waypoints.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.countTo.js"></script>
<script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
 --%>
 <script src="${pageContext.request.contextPath }/js/material.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath }/js/smooth-scroll.js"></script>

<%-- <script src="${pageContext.request.contextPath }/js/selectize.js"></script>
<script src="${pageContext.request.contextPath }/js/swiper.jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/moment.js"></script>
<script src="${pageContext.request.contextPath }/js/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath }/js/simplecalendar.js"></script>
<script src="${pageContext.request.contextPath }/js/fullcalendar.js"></script>
<script src="${pageContext.request.contextPath }/js/isotope.pkgd.js"></script>
<script src="${pageContext.request.contextPath }/js/ajax-pagination.js"></script>
 --%>
 <%-- <script src="${pageContext.request.contextPath }/js/Chart.js"></script>
<script src="${pageContext.request.contextPath }/js/chartjs-plugin-deferred.js"></script>
<script src="${pageContext.request.contextPath }/js/circle-progress.js"></script>
<script src="${pageContext.request.contextPath }/js/loader.js"></script>
<script src="${pageContext.request.contextPath }/js/run-chart.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.magnific-popup.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.gifplayer.js"></script>
<script src="${pageContext.request.contextPath }/js/mediaelement-and-player.js"></script>
<script src="${pageContext.request.contextPath }/js/mediaelement-playlist-plugin.min.js"></script> --%>
<script src="${pageContext.request.contextPath }/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath }/js/base-init.js"></script>
<script defer src="${pageContext.request.contextPath }/fonts/fontawesome-all.js"></script>

 <script src="${pageContext.request.contextPath }/css/Bootstrap/dist/js/bootstrap.bundle.js"></script>






</body>
</html>