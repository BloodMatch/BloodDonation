<div class="modal-dialog  modal-sm" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="newAppointmentModalLabel">Reschedule Appointment</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <form action="center/appointment" method="POST">
                <input name="id" hidden id="id">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group text-center">
                            
                            <h5><img id="donationTypeImg" src="" width="15" title="Red Power" alt="-"><strong id="donationType">Blood Donation Type</strong></h5>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-7">
                        <div class="form-group">
                            <label>Date</label>
                            <input type="date" class="form-control" name="date" id="date">
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                            <label>Time</label>
                            <select class="form-control " name="time" type="time" id="time">
                                <option value="09">09 - 10</option>
                                <option value="10">10 - 11</option>
                                <option value="11">11 - 12</option>
                                <option value="14">14 - 15</option>
                                <option value="15">15 - 16</option>
                                <option value="16">16 - 17</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" name="action" value="save" class="btn btn-success ">Save</button>
            </div>
        </form>
	</div>
</div>

<script>
    
    	document.addEventListener('DOMContentLoaded', function() {
    
	    $('#editAppointmentModal').on('show.bs.modal', function (event) {
	    	var button = $(event.relatedTarget) // Button that triggered the modal
	        var donationType = button.data('type') ;
	        var datetime = button.data('datetime') ;
	        var id = button.data('id') ;
	        var modal = $(this);
	        
	        modal.find('.modal-body').find('#donationType').text(donationType);
	        //modal.find('.modal-body').find('#donationType').text(donationType);
	        																
	        modal.find('.modal-body').find('#donationTypeImg').attr('src','assets/icons/blood-type/'+donationType+'.svg');
	        modal.find('.modal-body').find('#id').val(id);
	        modal.find('.modal-body').find('#date').val(datetime.substr(0, 10));
	        modal.find('.modal-body').find('#time').val(datetime.substr(11, 2));
	        
	      })
   	});
</script>
