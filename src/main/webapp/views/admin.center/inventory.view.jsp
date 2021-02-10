<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    home
</c:set>

<c:set var = "title" scope = "session"> 
    Inventury
</c:set>

<c:set var = "content" scope = "session">
<h1>Inventury</h1>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="header">
                <h4 class="title  px-3">Blood Inventory</h4>
            </div>
            <div class="content">
                <div class="content table-responsive table-width">
                    <table class="table table-hover">
                        <thead>
                            <th>Bag Type</th>
                            <th>Blood Type</th>
                            <th>Quatity</th>
                            <th>Level</th>
                        </thead>
                        <tbody>
                        	<c:forEach items="${stocksList}" var="stock">
                        	<c:set var="bag" value="${stock.getBag()}"/>
                          	<tr>
                          		<form  action="center/inventory" method="POST" >
                                <td  classs="col-sm-3"><img src="assets/icons/blood_type-${ bag.getType()}.svg" width="15" title="${ bag.getType()}" alt="-"> ${ bag.getType()} </td>
                                <td class=" col-sm-2"><strong> ${ bag.getGroup()}</strong></td>
                                <td class="text-center col-sm-3">
                                        <input type="number"   min=0  value="${ stock.getQuantity()}" class="form-control" name="quantity" placeholder="quantity" readonly ondblclick='this.readOnly = !this.readOnly;' title="double click"/>
                                </td>
                                <td class="text-center col-sm-2">
                               	<c:choose>
                                	<c:when test = "${stock.getQuantity() >= 2 * bag.getSaftyStore()}">
							            <i class="fa fa-circle text-success" title="success"></i><small>success</small>
							       	</c:when>
							         
							     	<c:when test = "${stock.getQuantity() >  bag.getSaftyStore()}">
							          	<i class="fa fa-circle text-warning" title="warning"></i><small>warning</small>
							     	</c:when>
							     	<c:otherwise>
							          	<i class="fa fa-circle text-danger" title="danger"></i><small>danger</small>
							       	</c:otherwise>
							   	</c:choose>
                                
                                
                                </td>
                                <td class="text-center col-sm-2">
		                          	<input type="hidden" name="id" value="${ stock.getId()}">
		                          	<button type="submit" name="action" value="save" class="btn btn-sm btn-primary">Save</button>
                              	</td>
                              	</form>
                        	</tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</c:set>


<%@ include file="app.jsp"%>