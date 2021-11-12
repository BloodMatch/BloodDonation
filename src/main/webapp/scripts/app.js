// Alert message popout
const alertMsg = document.getElementById('alertMsg');

setTimeout(function(){
	if(alertMsg){
		alertMsg.style.display = 'none';
	}
}, 5000);

// navbar styler
const navbar = {
	init : function(){
		this.cachDOM();

		this.styling();
	},

	cachDOM : function(){
		this.navBar = document.getElementById('AppNavBar');
		this.signUpBtn = document.getElementById('signUp');
	},

	styling : function(){
		if(location.pathname == "/BloodDonation/" || location.pathname == "/BloodDonation/home"){
			this.navBar.classList.add('layout-colorLanding');
			this.signUpBtn.style.display = 'none';
		}else{
			this.navBar.classList.add('layout-color');
		}
	}
}
navbar.init();