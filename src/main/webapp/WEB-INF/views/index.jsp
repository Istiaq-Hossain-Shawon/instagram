<!-- GLOBAL HEADER -->

<jsp:include page="common/header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
<!-- COURSE COVER IMAGE -->


<div class="container">
	<div class="row">

		<div class="col col-xl-6 order-xl-2 col-lg-12 order-lg-1 col-sm-12 col-12">

			<div class="page-description">
				<div class="icon">
					<svg class="olymp-star-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="FAV PAGE"><use xlink:href="svg-icons/sprites/icons.svg#olymp-star-icon"></use></svg>
				</div>
				<span>Here you ll see the recent post.</span>
			</div>

			<div id="newsfeed-items-grid">

<c:forEach items="${posts}" var="post">
	<div class="ui-block">
					
				<!-- Post -->
					
					<article class="hentry post">
					
						<div class="post__author author vcard inline-items">
							
							<img src="${pageContext.request.contextPath }/img/${post.user.logo}" alt="author">
					
							<div class="author-date">
								<a class="h6 post__author-name fn" href="#"> ${post.user.email}  </a> uploaded  ${fn:length(post.postImage)} <a href="#">new photos</a>
								<div class="post__date">
									<time class="published" datetime="2017-03-24T18:18">
										<ta:formatDate value="${post.postDate}" pattern="dd MMM yyyy HH:mm" />
									</time>
								</div>
							</div>
					
							<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-three-dots-icon"></use></svg>
								<ul class="more-dropdown">
									<li>
										<a href="#">Edit Post</a>
									</li>
									<li>
										<a href="#">Delete Post</a>
									</li>
									<li>
										<a href="#">Turn Off Notifications</a>
									</li>
									<li>
										<a href="#">Select as Featured</a>
									</li>
								</ul>
							</div>					
						</div>					
						<p>${post.postContent}
						</p>
					
						<div class="post-block-photo js-zoom-gallery">
							
							<c:forEach items="${post.postImage}" var="image">
								<a href="${pageContext.request.contextPath }/img/${image.imagePath}" class="col col-3-width"><img src="${pageContext.request.contextPath }/img/${image.imagePath}" alt="photo"></a>						
							
							
							</c:forEach>
							
							
							
						
							
							
						</div>
					
						<div class="post-additional-info inline-items">
					
							<a href="#" class="post-add-icon inline-items">
								<svg class="olymp-heart-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-heart-icon"></use></svg>
								<span>0</span>
							</a>
					
							<div class="comments-shared">
								<a href="#" class="post-add-icon inline-items">
									<svg class="olymp-speech-balloon-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-speech-balloon-icon"></use></svg>
									<span>0</span>
								</a>
					
								<a href="#" class="post-add-icon inline-items">
								<img  class="olymp-menu-icon left-menu-icon"
                                  src="${pageContext.request.contextPath }/img/icon-chat26.png" />
									
								
								
									<span>16</span>
								</a>
							</div>
					
					
						</div>
					
						<div class="control-block-button post-control-button">
					
							<a href="#" class="btn btn-control">
								<svg class="olymp-like-post-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-like-post-icon"></use></svg>
							</a>
					
							<a href="#" class="btn btn-control">
								<svg class="olymp-comments-post-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-comments-post-icon"></use></svg>
							</a>
					
							<a href="#" class="btn btn-control">
								<svg class="olymp-share-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-share-icon"></use></svg>
							</a>
					
						</div>
					
					</article>
					
				
					
					<!-- ... end Post -->					
					<!-- Comments -->
					
					<ul class="comments-list">
					
						<c:forEach items="${post.postComment}" var="comment">
								
														
							<li class="comment-item">
							<div class="post__author author vcard inline-items">
								<img src="img/author-page.jpg" alt="author">
					
								<div class="author-date">
									<a class="h6 post__author-name fn" href="02-ProfilePage.html">James Spiegel</a>
									<div class="post__date">
										<time class="published" datetime="2004-07-24T18:18">
											38 mins ago
										</time>
									</div>
								</div>
					
								<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-three-dots-icon"></use></svg></a>
					
							</div>
					
							<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium der doloremque laudantium.</p>
					
							<a href="#" class="post-add-icon inline-items">
								<svg class="olymp-heart-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-heart-icon"></use></svg>
								<span>3</span>
							</a>
							<a href="#" class="reply">Reply</a>
						</li>
							
							</c:forEach>
					
					
					
					</ul>
					
					<!-- ... end Comments -->

				
					
					<!-- Comment Form  -->
					
					<form class="comment-form inline-items">
					
						<div class="post__author author vcard inline-items">
							<img src="${pageContext.request.contextPath }/img/${post.user.logo}" alt="author">
					
							<div class="form-group with-icon-right ">
								<textarea class="form-control" placeholder=""></textarea>
								<div class="add-options-message">
									<a href="#" class="options-message" data-toggle="modal" data-target="#update-header-photo">
										<svg class="olymp-camera-icon">
											<use xlink:href="svg-icons/sprites/icons.svg#olymp-camera-icon"></use>
										</svg>
									</a>
								</div>
							</div>
						</div>
					
						<button class="btn btn-md-2 btn-primary">Post Comment</button>
					
						<button class="btn btn-md-2 btn-border-think c-grey btn-transparent custom-color">Cancel</button>
					
					</form>
					
					
				</div>
</c:forEach>


			

			

			
			</div>

			<a id="load-more-button" href="#" class="btn btn-control btn-more" data-load-link="items-to-load.html" data-container="newsfeed-items-grid"><svg class="olymp-three-dots-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-three-dots-icon"></use></svg></a>

		</div>

		<div class="col col-xl-3 order-xl-1 col-lg-6 order-lg-2 col-md-6 col-sm-12 col-12">
			<div class="ui-block">
				<div class="ui-block-title">
					<h6 class="title">Friend Suggestions</h6>
					<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-three-dots-icon"></use></svg></a>
				</div>

				
				
				<!-- W-Action -->
				
				<ul class="widget w-friend-pages-added notification-list friend-requests">
					<c:forEach items="${users}" var="user">
						<li class="inline-items">
						<div class="author-thumb">
							<img style="width: 40px;" src="${pageContext.request.contextPath }/img/${user.logo}" alt="author">
						</div>
						<div class="notification-event">
							<a href="#" class="h6 notification-friend">${user.name}</a>
							<span class="chat-message-item">${user.email}</span>
						</div>
						<span class="notification-icon">
							<a href="#" class="accept-request">
								<span class="icon-add without-text">
									<svg class="olymp-happy-face-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-happy-face-icon"></use></svg>
								</span>
							</a>
						</span>
					</li>
					</c:forEach>
					
					
				
				
				</ul>
				
				<!-- ... end W-Action -->
			</div>

		

		</div>

		<div class="col col-xl-3 order-xl-3 col-lg-6 order-lg-3 col-md-6 col-sm-12 col-12">


			<div class="ui-block">
				
				<!-- W-Create-Fav-Page -->
				
				<div class="widget w-create-fav-page">
					<div class="icons-block">
						<svg class="olymp-star-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="FAV PAGE"><use xlink:href="svg-icons/sprites/icons.svg#olymp-star-icon"></use></svg>
				
						<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="svg-icons/sprites/icons.svg#olymp-three-dots-icon"></use></svg></a>
					</div>
				
					<div class="content">
						<span>Be like them and</span>
						<h3 class="title">Create your own post !</h3>
						<a href="${pageContext.request.contextPath }/post/add" class="btn btn-bg-secondary btn-sm">Share Now!</a>
					</div>
				</div>
				
				<!-- ... end W-Create-Fav-Page -->			</div>

			

		</div>

	</div>

<div class="row">
		<c:if test="${totalPages>0}">

			<div class="pagination">
				<c:forEach var="i" begin="0" end="${totalPages-1}" step="1">
				<c:if test="${i == 0}"><a href="${pageContext.request.contextPath }/?_search=&_pageIndex=${i}&_rows=5&_sort=NA">&laquo;</a>
				</c:if>				
				
				<c:if test="${i == pageIndex}"><a class="active" href="${pageContext.request.contextPath }/?_search=&_pageIndex=${i}&_rows=5&_sort=NA">${i+1}</a>
				</c:if>
				
				<c:if test="${i != pageIndex}"><a  href="${pageContext.request.contextPath }/?_search=&_pageIndex=${i}&_rows=5&_sort=NA">${i+1}</a>
				</c:if>
				
				
				
				
				<c:if test="${i == totalPages}"><a href="${pageContext.request.contextPath }/country/show-all?_search=&_pageIndex=${i}&_rows=5&_sort=NA">&raquo;</a>
				</c:if>
				
				</c:forEach>
			</div>

				</c:if>
		</div>

</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="common/footer.jsp"/>




