<div class="modal-dialog  modal-lg py-3" role="document">
   <div class="modal-content">
     <div class="modal-header">
       <h3 class="modal-title" id="AnalysisModalLabel">Analysis</h3>
       <button type="button" class="close" data-dismiss="modal" aria-label="Close">
         <span aria-hidden="true">&times;</span>
       </button>
     </div>
     <div class="modal-body">
         <form action="center/analysis" method="POST"  id="analysisForm">
             <input hidden name="id" >
             <div class="row">
                 <div class="col-md-4">
                     <div class="form-group">
                         <label>Code</label>
                         <input type="text" class="form-control" name="code" readonly ondblclick='this.readOnly = !this.readOnly;' placeholder="code" required autocomplete="off">
                     </div>
                 </div>
                 <div class="col-md-5">
                     <div class="form-group">
                         <label>Date</label>
                         <input type="date" class="form-control" name="date" readonly ondblclick='this.readOnly = !this.readOnly;'>
                     </div>
                 </div>
                 <div class="col-md-3">
                     <div class="form-group">
                         <label>Group</label>
                         <select class="form-control" name="group" >
                             <option value="" selected></option>
                             <option value="AB+">AB+</option>
                             <option value="AB-">AB-</option>
                             <option value="A+">A+</option>
                             <option value="A-">A-</option>
                             <option value="B+">B+</option>
                             <option value="B-">B-</option>
                             <option value="O+">O+</option>
                             <option value="O-">O-</option>
                         </select>
                     </div>
                 </div>
             </div>
             <div class="row">
                 <div class="col-md-12">
                     <div class="form-group">
                         <label>Comment</label>
                         <textarea class="form-control" name="comment"  placeholder="write a comment" maxlength="255"></textarea>
                     </div>
                 </div>
             </div>
             <hr/>
              <div class="row">
                 <div class="col-md-12">
                     <div class="">
                         <h4>
                             Results
                         </h4>
                     </div>
                 </div>
             </div>
             <div class="row">
                 <div class="col-md-6">
                     <div class="form-group">
                         <label>Indice1</label>
                         <input type="text" class="form-control" name="index1" id="index1" placeholder="index" >
                     </div>
                 </div>
                 <div class="col-md-6">
                     <div class="form-group">
                         <label>Indice2</label>
                         <input type="text" class="form-control" name="index2" id="index2" placeholder="index" >
                     </div>
                 </div>
             </div>
             <div class="row">
                 <div class="col-md-6">
                     <div class="form-group">
                         <label>Indice3</label>
                         <input type="text" class="form-control" name="index3" id="index3" placeholder="index" >
                     </div>
                 </div>
                 <div class="col-md-6">
                     <div class="form-group">
                         <label>Indice4</label>
                         <input type="text" class="form-control" name="index4" id="index4" placeholder="index" >
                     </div>
                 </div>
             </div>
             <div class="row">
                 <div class="col-md-6">
                     
                     <div class="form-group">
                         <label>Indice5</label>
                         <input type="text" class="form-control" name="index5" id="index5" placeholder="index" >
                     </div>
                 </div>
                 <div class="col-md-6">
                     <div class="form-group">
                         <label>Indice6</label>
                         <input type="text" class="form-control" name="index6" id="index6" placeholder="index" >
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
	 	$('#AnalysisModal').on('show.bs.modal', function (event) {
	        var modal = $(this);
	        var button = $(event.relatedTarget) // Button that triggered the modal

	        var id = button.data('id') ;
	        var code = button.data('code') ;
	        var date = button.data('date') ;
	        var group = button.data('group') ;
	        var comment = button.data('comment') ;
	        var jsonResults = button.data('results');

	        var form = modal.find('.modal-body>#analysisForm');
	        //form.find("input[type=text]
	        form.find('input[name="id"]').val(id);
	        form.find('input[name="code"]').val(code);
	        form.find('input[name="date"]').val(date);
	        form.find('select[name="group"]').val(group);
	        form.find('textarea[name="comment"]').val(comment);
	        if( jsonResults == "")
	        	form.find("input[type=text]").val("");
	       	else
		        Object.keys(jsonResults).forEach(function(key) {
		            form.find("input[name="+key+"]").val(jsonResults[key]);
		        })
	        
	      });
	 });
 </script>