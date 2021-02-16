/*
 * Update appointment id input hidden when feedBack is clicked 
 */

// Cashing
const feedbackContainer = document.getElementById('feedbackContainer');
const inputId = document.getElementById("appointId");

// Events
feedbackContainer.addEventListener('click', (e) => update(e) );

// Actions
function update(e){
	if(e.target.classList.contains('feedback')){
		let appointId = e.target.parentElement.parentElement.parentElement.id;
		inputId.value = appointId;
	}
}