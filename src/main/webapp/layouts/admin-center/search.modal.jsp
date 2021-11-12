    <div class="modal-dialog  " role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="searchModalLabel">Search</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <form action="center/profile/search">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <select class="form-control " name="type">
                                <option value="donor">Donor</option>
                                <option value="hospital">Hospital</option>
                                <option value="bloodType">Blood Type</option>
                                
                            </select>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <input type="text" class="form-control" name="query">
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" name="action" value="search" class="btn btn-danger ">Search</button>
            </div>
        </form>
      </div>
    </div>

