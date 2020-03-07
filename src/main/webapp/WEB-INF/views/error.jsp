<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Bootstrap/dist/css/bootstrap.css">
</head>
<body>
	<div class="container padding-t80">
		<div class="row">
			<div class="col-lg-10">
				<div class="row">
					<div class="col-lg-12 col-md-12 mb-8">
						<div class="card h-100">
							<div class="card-body">
								<div class="alert alert-danger" role="alert">  ${message}</div>
								
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>