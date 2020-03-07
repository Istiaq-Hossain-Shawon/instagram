<!-- GLOBAL HEADER -->

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- COURSE COVER IMAGE -->


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

 <div class="col col-lg-12 col-md-12 col-sm-12 col-12">
			
			<div class="ui-block">

				
				<!-- News Feed Form  -->
				
				<div class="news-feed-form">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item">
							<a class="nav-link active inline-items" data-toggle="tab" href="#home-1" role="tab" aria-expanded="true">
				
								<svg class="olymp-status-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-status-icon"></use></svg>
				
								<span>Status</span>
							</a>
						</li>						
					</ul>
				
					<!-- Tab panes -->
					<div class="tab-content">
						<div class="tab-pane active" id="home-1" role="tabpanel" aria-expanded="true">
							<form:form action="${pageContext.request.contextPath }/post/add" modelAttribute="post" enctype="multipart/form-data">
							
								<div class="author-thumb">
<img src="${pageContext.request.contextPath }/img/default-user.jpg" alt="Cricbean" style='    width: 40px;'>		
				
													

								</div>
								<div class="form-group with-icon label-floating is-empty">
									<label class="control-label">Share what you are thinking here...</label>
									<textarea class="form-control" name ="postContent" placeholder=""></textarea>
									
								</div>
								<div class="add-options-message">
									<label for="image">Images: </label> 
                    <input type="file" name="images" multiple="multiple"/>
									<!-- <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD PHOTOS">
										
										
										
									</a>	 -->								
				<input type="submit" class="btn btn-primary btn-md-2" value="POST" style="width: 15%;float: right;margin-top: 5px;">
				
								<!-- 	<button type="submit" class="btn btn-primary btn-md-2"></button>
									<button   class="btn btn-md-2 btn-border-think btn-transparent c-grey">Preview</button>
				 -->
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
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>




