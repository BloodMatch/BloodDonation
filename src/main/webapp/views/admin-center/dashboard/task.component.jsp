<div class="card ">
    <div class="header">
        <h4 class="title px-3">Tasks</h4>
        <p class="category px-4">Daily Tasks</p>
    </div>
    <div class="content">
	 <div class="table-width">
	     <table class="table">
	         <tbody>
	             <tr>
	                 <td><i class="fa fa-rocket" title="task 1"></i>
	                 	Mark missed donation appointments
	                 </td>
	                 <td class="td-actions text-right">
	                 	<form  action="center/dashboard/task" method="POST">
							<button type="submit" name="action" value="launch" class="btn btn-sm btn-dark">Launch</button>
							<input type="hidden" name="tasksId" value="1">
                   		</form>
					</td>
				</tr>
				<tr>
					<td><i class="fa fa-rocket" title="task 2"></i>
						Mark the arrived appointments
					</td>
                    <td class="td-actions text-right">
                    	<form  action="center/dashboard/task" method="POST">
                        	<button type="submit" name="action" value="launch" class="btn btn-sm btn-dark">Launch</button>
							<input type="hidden" name="tasksId" value="2">
                       	</form>
					</td>
             	</tr>
              	<tr>
	               	<td><i class="fa fa-rocket" title="task 3"></i>
	               		Mark expired appointments request
	               	</td>
	                <td class="td-actions text-right">
		             	<form  action="center/dashboard/task" method="POST">
		           			<button type="submit" name="action" value="launch" class="btn btn-sm btn-dark">Launch</button>
							<input type="hidden" name="tasksId" value="3">
		              	</form>
					</td>
				</tr>
				<%--
					<tr>
						<td><i class="fa fa-rocket" title="task 4"></i>
							..........
						</td>
                        <td class="td-actions text-right">
                        	<form  action="center/dashboard/task" method="POST">
								<button type="submit" name="action" value="launch" class="btn btn-dark">Launch</button>
								<input type="hidden" name="tasksId" value="4">
               				</form>
                      	</td>
                  	</tr>
				--%>
			</tbody>
		</table>
   	</div>
  	<div class="footer">
   		<hr>
      	<div class="stats text-center">
          	<i class="fa fa-calendar"></i>  
          	<jsp:useBean id="date" class="java.util.Date"/>
			<fmt:formatDate value="${date}" type="both"  dateStyle = "long" timeStyle = "short" />
            </div>
        </div>
    </div>
</div>