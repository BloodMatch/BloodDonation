<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var = "title" scope = "session"> 
    Register
</c:set>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<c:set var = "content" scope = "session"> 
    <section class="first-section">
        <div class="container">
            <div class="row justify-content-around">
                <div class="col-sm-6">
                    <a href="${rootUrl}/register" class="text-dark text-decoration-none"><i class="fas fa-angle-left"></i> Back</a>
                </div>
                <div class="col-sm-6 go-right">
                    <p class="text-muted steps">STEP 02/02 <br> <strong>Residency Info.</strong></p>
                </div>
            </div>
            <div class="row">
                <h2>Complete Your Profile !</h2>
                <div class="text-muted font-weight-lighter">For the purpose of industry regulation, your details are required.</div>
            </div>
            <hr/>
            <form action="${rootUrl}/register2" method="POST">
                 <div class="row my-5">
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group mt-4">
                            <label for="cin">CIN <sapn class="text-danger">*</sapn></label>
                            <input type="text" name="cin" id="cin" value="" class="form-control form-control-lg" placeholder="Please enter cin" required autofocus>		    
                        </div>
                        
                        <div class="form-group mt-4">
                            <label for="Phone">Phone (optional)</label>
                            <input type="text" name="phone" id="Phone" value="" class="form-control form-control-lg" placeholder="Please enter phone" required autofocus>		    
                        </div>
					    <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group mt-4">
                                    <label for="gender">Gender <sapn class="text-danger">*</sapn></label>
                                    <select name="gender" class="form-control form-control-lg" id="gender">
                                        <option selected>Gender</option>
                                        <option vlaue="F">Female</option>
                                        <option value="M">Male</option>
                                    </select>  
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group mt-4">
                                    <label for="group">Blood Type (optional)</label>
                                    <select name="group" class="form-control form-control-lg" id="group">
                                        <option selected>blood type</option>
                                        <option value="A+">A+</option>
                                        <option value="A-">A-</option>
                                        <option value="B+">B+</option>
                                        <option value="B-">B-</option>
                                        <option value="AB+">AB+</option>
                                        <option value="AB-">AB-</option>
                                        <option value="O+">O+</option>
                                        <option value="O-">O-</option>
                                    </select> 
                                </div>
                            </div>
                        </div>
				    </div>
                </div>

                 <div class="col-sm-12 col-md-6">
                 
                 	 <div class="form-group mt-4">
                         <label for="birthday">Birthday <sapn class="text-danger">*</sapn></label>
                         <input type="date" name="birthday" id="birthday" value="" class="form-control form-control-lg" placeholder="Please enter birthday" required autofocus>		    
                     </div>
                     
                     <div class="form-group mt-4">
                         <label for="birthday">City of residence <sapn class="text-danger">*</sapn></label>
                         <input type="text" name="city" id="city" value="" class="form-control form-control-lg" placeholder="Please enter city" required autofocus>		    
                     </div>

                   	  <div class="form-group mt-4">
                         <label for="zipCode">ZIP Code <sapn class="text-danger">*</sapn></label>
                         <input type="number" name="zipCode" id="zipCode" value="" class="form-control form-control-lg" placeholder="Please enter zip code" required autofocus>		    
                     </div>
                   
                     <div class="row mt-4">
                         <button class="btn btn-blood btn-lg btn-block" type="submit">Register Account</button>			    	
                     </div>

                     <div class="text-center my-3">
                         <p class="text-muted font-weight-lighter"><i class="fas fa-lock"></i> Your Info is safely secured</p>
                     </div>
                 </div>
             </div>
         </form>
     </div>
 </section>
 </c:set>
 
 <%@ include file="layouts/app.view.jsp"  %>
 
 
 