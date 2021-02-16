<div class="modal-dialog  modal-sm" role="document">
  <div class="modal-content">
    <div class="modal-header">
      <h5 class="modal-title" id="newAppointmentModalLabel">New Appointment</h5>
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="modal-body">
        <form action="center/appointment" method="POST">
            <input name="id" hidden value="${donor.getDonorId()}">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label>Blood donation type</label>
                        <select class="form-control " name="donationType" required>
                            <option value="Blood">Blood</option>
                            <option value="AB plasma">AB plasma</option>
                            <option value="Power Red">Power Red</option>
                            <option value="Platelets">Platelets</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-7">
                    <div class="form-group">
                        <label>Date</label>
                        <input type="date" class="form-control" name="date">
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="form-group">
                        <label>Time</label>
                        <select class="form-control " name="time">
                            <option value="9">09 - 10</option>
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
            <button type="submit" name="action" value="add" class="btn btn-danger ">Save</button>
        </div>
    </form>
  </div>
</div>