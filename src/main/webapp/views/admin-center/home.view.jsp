<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    center
</c:set>

<c:set var = "title" scope = "session"> 
    center
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>CENTER</h1>
  <c:set var="adminCenter" value="${sessionScope['isLoged']}" />
  <c:set var="center" value="${adminCenter.getCenter()}" />
  <div class="row">
        <div class="col-md-6">
            <div class="card py-4">
                <div class="header">
                    <h4 class="title px-3" title="center name">${center.getName()}</h4>
                </div>
                <div class="content">
                    <div class="content  table-width px-5">
                   		<div class="row">
	                    	<div class="col-sm-3">
	                        	<img class="text-right" src="assets/icons/location.svg" width="15" title="address" alt="Address">
	                        	Address
	                     	</div>
	                    	<div class="col-sm-8">
	                        	${center.getAddress()}
	                    	</div> 
	                    	<div class="col-sm-3">
	                        	<img class="text-right" src="assets/icons/location.svg" width="15" title="city" alt="City">
	                        	City
	                     	</div>
	                    	<div class="col-sm-8">
	                        	${center.getCity()}
	                    	</div> 
	                    	<div class="col-sm-3">
	                        	<img class="text-right" src="assets/icons/zip-code.svg" width="15" title="zipcode" alt="Zip-Code">
	                        	Zip-Code
	                     	</div>
	                    	<div class="col-sm-8">
	                        	${center.getZIPCode()}
	                    	</div> 
	                    	<div class="col-sm-3">
	                        	<img class="text-right" src="assets/icons/phone1.svg" width="15" title="phone1" alt="Phone1">
	                        	Phone1
	                     	</div>
	                    	<div class="col-sm-8">
	                        	${center.getPhone1()}
	                    	</div> 
	                    	<div class="col-sm-3">
	                        	<img class="text-right" src="assets/icons/phone2.svg" width="15" title="phone2" alt="Phone2">
	                        	Phone2
	                     	</div>
	                    	<div class="col-sm-8">
	                        	${center.getPhone2()}
	                    	</div> 
	                    	<div class="col-sm-3">
	                        	<img class="text-right" src="assets/icons/email.svg" width="15" title="email" alt="Email">
	                        	Email
	                     	</div>
	                    	<div class="col-sm-8">
	                        	${center.getEmail()}
	                    	</div>  
	                    	<br/>  
                    	</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
          <h1>....</h1>
        </div>
    </div>

</c:set>


<%@ include file="app.jsp"%>