<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Menu
</c:set>

<c:set var ="content" scope="session">
    <section class="first-section">
        <div class="container" id="feedbackContainer">
        	<h2>Appointment History</h2>
            <div class="text-muted font-weight-lighter">Find Out All Your Appointments</div>
            <hr>
            <c:if test="${empty appoint.appointments}">
            	<div class="container">
         		<div class="row justify-content-center">
         			<div class="alert alert-danger" role="alert">
					  	No Appointment or Donations are made yet !
					</div>
         		</div>
         	</div>
            </c:if>
   			<c:forEach items="${appoint.appointments}" var="appointment">
   				<div class="row mb-3">
	        		<div class="col-sm-12">
	        			<div class="card p-3" id="${appointment.id}">
	                        <div class="card-body">
	                            <div class="row align-items-center">
	                                <div class="col-2">
	                                    <p class="lead"><img src="${rootUrl}/assets/icons/blood-type/${appointment.donationType}.svg" width="20" title="${appointment.donationType}" alt="-"> ${appointment.donationType }</p>
	                                    <div class="d-flex">
		                                    <c:forEach begin="1" step="1" end="${appointment.satisfaction}">
		                                    	<i class="fas fa-star text-warning"></i>
		                                    </c:forEach>
	                                    </div>
	                                    <c:if test="${appointment.satisfaction} > 0">Rating ${appointment.satisfaction}</c:if>
	                                </div>
	                                <div class="col-7">
	                                    <h4> ${appointment.center.name} </h4>
	                                    <p class="lead text-left"> ${appointment.center.address}</p>
	                                    <c:if test="${not empty appointment.comment}">
	                                    	<hr>
	                                    	<div class="card bg-gray border-0">
	                        					<div class="card-body">
                                    				<p class="text-truncate">${appointment.comment}</p>
                                    			</div>
                                    		</div>
	                                    </c:if> 
	                                </div>
	                                <div class="col-3 ">
	                                    <p class="lead blood-color text-center"><i class="fas fa-calendar-day"></i> ${appointment.time }</p>
	                                    <p class="lead text-center"> 
		                                    <c:choose>
		                                    	<c:when test="${appointment.state == 'Pending' }">
		                                    	 	<i class="fas fa-circle"></i>
		                                    	</c:when>
		                                    	<c:when test="${appointment.state == 'Canceled' }">
		                                    		<i class="fas fa-circle text-danger"></i>
		                                    	</c:when>
		                                    	<c:when test="${appointment.state == 'Fulfilled' }">
		                                    		<i class="fas fa-circle text-success"></i>
		                                    	</c:when>
		                                    	<c:when test="${appointment.state == 'Arrived' }">
		                                    		<i class="fas fa-circle text-primary"></i>
		                                    	</c:when>
		                                    	<c:when test="${appointment.state == 'Booked' }">
		                                    		<i class="fas fa-circle text-warning"></i>
		                                    	</c:when>
		                                    </c:choose>
	                                    ${appointment.state } </p>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="card-footer bg-white">
	                        	<div class="d-flex justify-content-between align-items-center">
	                        		<button type="button" class="btn btn-blood feedback" data-toggle="modal" data-target="#exampleModal">
									  	FeedBack
									</button>
									<c:choose>
										<c:when test="${appointment.state == 'Fulfilled' }">
											<button type="button" class="btn bg-gray" data-toggle="modal" data-target="#A-${appointment.analysis.id }">
												View Blood Test <i class="fas fa-file-medical-alt"></i>
											</button>
											<!-- Modal -->
											<div class="modal fade" id="A-${appointment.analysis.id }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog modal-lg">
												    <div class="modal-content">
												      <div class="modal-header d-flex justify-content-between">
												        <h5 class="modal-title" id="exampleModalLabel">Boold Test</h5>
												        <h5>${appointment.analysis.date}</h5>
												      </div>
												      <div class="modal-body">
												        <div class="container">
													        <div class="row align-items-center">
													        	<div class="col-sm-8">
													        		<h4><i class="fas fa-hospital blood-color fa-2x"></i> ${appointment.center.name} </h4>
		                                    						<p class="lead text-left"> ${appointment.center.address}</p>
													        	</div>
													        	<div class="col-sm-4 text-right">
													        		<h5>Code : <span class="lead">${appointment.analysis.code}</span> </h5>
													        		<h5>Phone : <span class="lead"><i class="fas fa-phone-alt"></i> ${appointment.center.phone1}</span> </h5>
													        	</div>
													        </div>
													        <hr>
													        <div class="row justify-content-between">
													        	<div class="col-sm-6">
													        		<h5>First Name : <span class="lead">${user.firstName}</span></h5>
													        		<h5>Last Name : <span class="lead">${user.lastName}</span></h5>
													        	</div>
													        	<div class="col-sm-6 text-right">
													        		<h5>CIN :<span class="lead">${donor.cin}</span></h5>
													        		<h5>Blood Type :<span class="lead">${donor.group}</span></h5>
													        	</div>
													        </div>
													        <hr>
												      	</div>
												      	
												      	 <div class="container">
													      	 <div class="row">
													      	 	<h4 class="blood-color">Results :</h4>
															</div>
													      	 <div class="card bg-gray border-0">
					                        					<div class="card-body">
				                                    				<div class="row">
															        	<div class="col-sm-4">
															        		<h5>Hemoglobin : <span class="lead">${appointment.analysis.results.index1}</span></h5>
															        	</div>
															        	<div class="col-sm-4">
															        		<h5>RBC : <span class="lead">${appointment.analysis.results.index2}</span></h5>
															        	</div>
															        	<div class="col-sm-4">
															        		<h5>HCT : <span class="lead">${appointment.analysis.results.index3}</span></h5>
															        	</div>
															        	<div class="col-sm-4">
															        		<h5>MCV : <span class="lead">${appointment.analysis.results.index4}</span></h5>
															        	</div>
															        	<div class="col-sm-4">
															        		<h5>MCH : <span class="lead">${appointment.analysis.results.index4}</span></h5>
															        	</div>
															        	<div class="col-sm-4">
															        		<h5>MCHC : <span class="lead">${appointment.analysis.results.index5}</span></h5>
															        	</div>
													        		</div>
				                                    			</div>
				                                    		</div>
												      	 	
												     	  	<div class="row">
												     	  		<hr>		
													        	<div class="col-sm-12">
													        		<h4 class="blood-color">Comment :</h4>
		                                    						<p class="lead text-left"> ${appointment.analysis.comment}</p>
													        	</div>
													        </div>
												      	</div>
													  </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
												      </div>
												    </div>
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div>
				                        		<p>Analysis Not yet Available</p>
				                        	</div>
										</c:otherwise>
									</c:choose>
	                        	</div>
	                        </div>
	                    </div>
	        		</div>
	        	</div>
   			</c:forEach>
   		
   			<script type="text/javascript" defer src="${rootUrl}/scripts/feedback.js"></script>
        </div>
    </section>
    
    <!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog  modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <form action="${rootUrl}/donor/feedBack" method="Post">
		      	<div class="modal-body">
			  		    <div class="form-group">
			        		<input class="form-control" id="appointId" name="id" value="" hidden />
			        	</div>
			        	<div class="form-group">
			        		 <label>Rate service <sapn class="text-danger">*</sapn></label>
			        		<div class="starrating risingstar d-flex justify-content-center flex-row-reverse">
					            <input type="radio" id="star5" name="rating" value="5" /><label for="star5" title="5 stars"><i class="fas fa-star fa-2x"></i>5</label>
					            <input type="radio" id="star4" name="rating" value="4" /><label for="star4" title="4 stars"><i class="fas fa-star fa-2x"></i>4</label>
					            <input type="radio" id="star3" name="rating" value="3" /><label for="star3" title="3 stars"><i class="fas fa-star fa-2x"></i>3</label>
					            <input type="radio" id="star2" name="rating" value="2" /><label for="star2" title="2 stars"><i class="fas fa-star fa-2x"></i>2</label>
					            <input type="radio" id="star1" name="rating" value="1" /><label for="star1" title="1 star"><i class="fas fa-star fa-2x"></i>1</label>
					        </div>
			        	</div>
			        	<div class="from-group">
						 	 <label for="comment">Comment</label>
						  	<textarea class="form-control" id="comment" name="comment" max="255"  rows="text" cols=""></textarea>						 
						 </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="submit" class="btn btn-blood">Save changes</button>
			      </div>
		      </form>
		    </div>
		  </div>
		</div>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>