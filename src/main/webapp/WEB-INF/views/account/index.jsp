<!-- GLOBAL HEADER -->

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- COURSE COVER IMAGE -->


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

 <div class="col col-lg-12 col-md-12 col-sm-12 col-12">
			
			<div class="ui-block">

					<div class="ui-block-content">

						<form:form
							action="${pageContext.request.contextPath }/account/edit"
							modelAttribute="user" enctype="multipart/form-data">
							<div class="form-row">
								

								<div class="col col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="form-group">
										<label for="teamName">username</label>
										<form:input path="username" class="form-control" id="teamName"
											placeholder="team Name..." />
									</div>
								</div>


							</div>

							<div class="form-row">


								<div class="form-group col-md-12">
									<label for="teamDescription">email</label>
									<form:input path="email" class="form-control"
										id="teamDescription" placeholder="team Description..." />
								</div>

							</div>




							
							<div class="form-row">
							<div class="form-group col-md-10">
								<c:if test="${not empty user.logo}">
									<div class="form-group col-md-4">
										<table class="table">
											<tr>
												<th>Images</th>
												<th>Action</th>
											</tr>
											<tr>
												<th><img class="card-img-top"
													src="${pageContext.request.contextPath }/img/${user.logo}"
													alt=""></th>
												<th><a class="badge badge-primary"
													href="team/deleteImage?logo=${logo}}&id=${id }">Delete</a></th>
											</tr>
										</table>
									</div>
								</c:if>
							</div>
						</div>
							<input type="submit" class="btn btn-primary" value="Update account">
						</form:form>

						

					</div>
			</div>
		</div> 


<div class="row">
		<c:if test="${totalPages>0}">

			<div class="pagination">
				<c:forEach var="i" begin="0" end="${totalPages-1}" step="1">
				<c:if test="${i == 0}"><a href="${pageContext.request.contextPath }/country/show-all?_search=&_pageIndex=${i}&_rows=5&_sort=NA">&laquo;</a>
				</c:if>				
				
				<c:if test="${i == pageIndex}"><a class="active" href="${pageContext.request.contextPath }/country/show-all?_search=&_pageIndex=${i}&_rows=5&_sort=NA">${i+1}</a>
				</c:if>
				
				<c:if test="${i != pageIndex}"><a  href="${pageContext.request.contextPath }/country/show-all?_search=&_pageIndex=${i}&_rows=5&_sort=NA">${i+1}</a>
				</c:if>
				
				
				
				
				<c:if test="${i == totalPages}"><a href="${pageContext.request.contextPath }/country/show-all?_search=&_pageIndex=${i}&_rows=5&_sort=NA">&raquo;</a>
				</c:if>
				
				</c:forEach>
			</div>

				</c:if>
		</div>
</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>




