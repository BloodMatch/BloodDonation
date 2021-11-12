<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Test Eligibility
</c:set>

<c:set var ="content" scope="session">
    <section class="first-section">
        <div class="container">
            <h2>Requirements for Donation</h2>
            <div class="text-muted font-weight-lighter"> Somthing for Requirements </div>
            <hr>
        </div>
        <div class="container" id="message">
            <div class="row justify-content-center">

            </div>
        </div>

        <div class="container" id="quiz"> 
            <div class="row">
                <p class="lead">
                    To ensure the safety of both patients and donors, these are some of 
                    the requirements donors must meet to be eligible to donate blood based 
                    on their donation type.
                </p>
            </div>
            <div class="form-group">
                <input type="hidden" value="${donor.id}" name="donorId" class="form-control" id="donorId">
            </div>
        </div>
        <div class="container my-5">
            <div class="row justify-content-between">
                <div class="col-sm-10 d-flex justify-content-end">
                    <button class="btn btn-success btn-block" id="submitQuiz">
  						Submit
					</button>
                </div>
            </div>
        </div>
    </section>
    <script defer src="${rootUrl}/scripts/requirementTest/quiz.js"></script>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>