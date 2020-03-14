<!-- GLOBAL HEADER -->

<jsp:include page="/WEB-INF/views/common/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- COURSE COVER IMAGE -->


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

	<div class="col col-lg-12 col-md-12 col-sm-12 col-12">

		<div class="ui-block">


			<!-- News Feed Form  -->

			<div class="news-feed-form">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li class="nav-item"><a class="nav-link active inline-items"
						data-toggle="tab" href="#home-1" role="tab" aria-expanded="true">

							<svg class="olymp-status-icon">
								<use xlink:href="svg-icons/sprites/icons.svg#olymp-status-icon"></use></svg>

							<span>Status</span>
					</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane active" id="home-1" role="tabpanel"
						aria-expanded="true">
						<form:form
							action="${pageContext.request.contextPath }/post/update"
							modelAttribute="post" enctype="multipart/form-data">
	<form:input path="postId" value="${post.postId}" hidden="hidden" />
							<div class="author-thumb">
								<img
									src="${pageContext.request.contextPath }/img/default-user.jpg"
									alt="Cricbean" style='width: 40px;'>



							</div>
							<div class="form-group with-icon label-floating is-empty">
								<textarea class="form-control" name="postContent" value=""
									placeholder="">
									<c:out value="${post.postContent}" /> 
									</textarea>
							</div>


							<div class="post-block-photo js-zoom-gallery">

								<c:if test="${not empty post.postImage}">
									<div class="form-group col-md-4">
										<table class="table">
											<tr>
												<th>Images</th>
												<th>Action</th>
											</tr>
											<c:forEach items="${post.postImage}" var="image">

												<tr>
													<th>
														<a href="${pageContext.request.contextPath }/img/${image.imagePath}"	class="col col-12-width">
															<img 		src="${pageContext.request.contextPath }/img/${image.imagePath}" alt="photo">
														</a>
													</th>
													<th>
														<a class="badge badge-primary"	
														href="${pageContext.request.contextPath}/post/deleteImage?postId=${post.postId}&imageId=${image.imageId}">Delete</a>
													</th>
												</tr>
											</c:forEach>

										</table>
									</div>
								</c:if>
							</div>

							<div class="add-options-message">
								<label for="image">Images: </label> <input type="file"
									name="images" multiple="multiple" /> <input type="submit"
									class="btn btn-primary" value="Update Post">


							</div>

						</form:form>
					</div>


				</div>
			</div>

			<!-- ... end News Feed Form  -->
		</div>
	</div>


</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="/WEB-INF/views/common/footer.jsp" />




