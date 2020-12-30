<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    login
</c:set>

<c:set var = "content" scope = "session"> 
         
    <div class="text-center form-signin">
	  	<form>
	    <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
	    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
	    <label for="inputEmail" class="visually-hidden">Email address</label>
	    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
	    <label for="inputPassword" class="visually-hidden">Password</label>
	    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	    <div class="checkbox mb-3">
	      <label>
	        <input type="checkbox" value="remember-me"> Remember me
	      </label>
	    </div>
	    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
	    <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
	  </form>
	</div>
    
</c:set>

<c:remove var="other"/>

<%@ include file="layouts/app.view.jsp"%>