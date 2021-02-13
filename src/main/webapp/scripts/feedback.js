/*
 * Update appointment id input hidden when feedBack is clicked 
 * */

const feedbackContainer = document.getElementById('feedbackContainer');
const inputId = document.getElementById("appointId");
feedbackContainer.addEventListener('click', (e) => update(e) );

function update(e){
	if(e.target.classList.contains('feedback')){
		let appointId = e.target.parentElement.parentElement.parentElement.id;
		inputId.value = appointId;
	}
}