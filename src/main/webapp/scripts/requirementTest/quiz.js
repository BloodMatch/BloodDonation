const quizApi = (function(){

    // Global data
    const quiz = {
        blood : [
            {
                question : "Are you in good health and feeling well ?",
                answer : "yes"
            },

            {
                question : "Your weigh is less then 50kg (110lbs) ?",
                answer : "no"
            },

            {
                question : "Your age is between 18 and 65 years old ?",
                answer : "yes"
            },

            {
                question : "Do you use any recreational drugs that inject ?",
                answer : "no"
            }
        ],
    }
    let clientAnswers = [];

    // cachDOM
    const quizContainer = document.getElementById('quiz');
    const btnSubmit = document.getElementById('submitQuiz');
    const message = document.getElementById('message');
    const donorId = document.getElementById('donorId');


    // eventBinding
    btnSubmit.addEventListener('click', submitForm);

    // Actions
    function render(){
        quiz.blood.forEach((block, index) => {
            quizContainer.innerHTML += `
            <div class="row mb-3 justify-content-center">
                <div class="col-sm-8">
                <h4>Question ${index+1}</h4>
                    <div class="card p-4">
                        <div class="card-body">
                            <p class="lead"> ${block.question} </p>
                            <hr>
                            <div class="form-group">
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="${index}-1" value="yes" name="${index}" class="custom-control-input answer">
                                    <label class="custom-control-label" for="${index}-1">Yes</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="${index}-2" value="no" name="${index}" class="custom-control-input answer">
                                    <label class="custom-control-label" for="${index}-2">No</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>`
        });
    }

    function submitForm(){
    	loading();
    	
        // get answers
        getAnswers();
        
        // validate
        if(validate()){
            submit();
        }else{
        	stopLoading();
            alert("<strong>You don't Have all Requrements</strong> for a Blood Donation", "danger");
        }
        
        // clear test
        clear();
    }

    function validate(){
        let results = true;
        quiz.blood.forEach((question, index) => {
            if(question.answer !== clientAnswers[index]){
                results = false;
            }
        })
        return results;
    }

    function submit(){
        fetch(`${location.origin}/BloodDonation/donor/requirements`, {
            method : 'POST',
            body : JSON.stringify({ donorId : donorId.value }),
            headers :{
                "Context-type" : "application/json; charset=UTF-8", 
            }
        })
        .then(response => response.json())
        .then(response => {
        	alert("<strong> You Have all Requirements </strong>, You can Schedule New Appoitment.", "success");
        	stopLoading();
        	location.replace(`${location.origin}/BloodDonation/donor/menu`);
        })
        .catch(err => {
        	alert("<strong> Error occurred </strong> Please try again later !", "danger");
        	stopLoading();
        });
    }

    function getAnswers(){
        let answers = Array.from(document.querySelectorAll('.answer'));
        answers = answers.filter(answer => { 
            if(answer.checked){
                clientAnswers.push(answer.value);
                return true;
            }
        });
    }

    function alert(msg, style){
        message.firstElementChild.innerHTML = `<div class="alert alert-${style}" role="alert"> ${msg} </div>`;
    }

    function clear(){
        clientAnswers = [];
        let answers = Array.from(document.querySelectorAll('.answer'));
        answers.forEach(input => input.checked = false);
    }
    
    function loading(){
    	btnSubmit.disabled = true;
    	btnSubmit.innerHTML = `<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>`;
    }
    
    function stopLoading(){
    	btnSubmit.disabled = false;
    	btnSubmit.innerHTML = 'Submit';
    }

    return {
        render,
    }

})()

quizApi.render();