/*
 * Filter engine for scheduling appointments 
 */

const Filter = {
    init : function(){
        this.cachDOM();
        this.bindEvents();
    },

    cachDOM : function(){
        this.radioDate = document.getElementById('radioBox');
        this.dateRadioBox = document.getElementById('dateRadioBox');
        this.input = document.getElementById('donationDate');
        this.form = document.getElementById('scheduleForm');
        // container
        this.schedule = document.getElementById('schedule');
        // form
        this.form = document.getElementById('scheduleForm');
        this.center = document.getElementById('centerId');
    },

    bindEvents : function(){
        this.radioDate.addEventListener('click', this.toggle.bind(this));
        this.input.addEventListener('change', this.updateInputForm.bind(this));
        this.schedule.addEventListener('click', this.submit.bind(this));
    },

    toggle : function(e){
        if(e.target.getAttribute('name') === 'option'){
            if(this.dateRadioBox.checked){
                this.input.removeAttribute('disabled');
            }else{
                this.form.elements[2].value = "";
                this.input.setAttribute('disabled', true);
            }
        }
    },

    updateInputForm : function(){
        this.form.elements[2].value = this.input.value;
    },

    submit : function(e){
        if(e.target.classList.contains("submitSchedule")){
            this.center.value = e.target.parentElement.parentElement.parentElement.id;
            this.form.submit();
        }
    }
}

Filter.init();