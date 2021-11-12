<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    home
</c:set>

<c:set var = "title" scope = "session"> 
    home
</c:set>

<c:set var = "content" scope = "session"> 
<h1>CENTER</h1>
<div class="row">
    <div class="col-md-8">
        <div class="card">
            <div class="header">
                <h4 class="title px-3">Demands Summary</h4>
            </div>
            <div class="content">
                <div class="content table-width">
                    <table class="table table-hover">
                        <thead>
                            <th>State</th>
                            <th>Bag Type</th>
                            <th>Blood Type</th>
                            <th>Quatity</th>
                            <th>Date</th>
                            <th>-</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td><img src="./assets/my-icons/appointment_state-booked.svg" width="20" title="Pending" alt="-"> <small>Booked</small> </im></td>
                                <td ><img src="./assets/my-icons/blood_type-Platelets.svg" width="15" title="Red Power" alt="-"> <small></small>Platelets</im> </td>
                                <td class="text-center"><strong> AB+</strong></td>
                                <td class="text-center">12</td>
                                <td>12-15-2021</td>
                                <td>
                                    <form  action="center/appointment" method="POST">
                                        <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                            <input type="hidden" name="id" value="${demand.getId()}">
                                           <button type="submit" name="action" value="revoke" class="btn btn-danger">Revoke</button>
                                       </div>
                                   </form>
                               </td>
                           </tr>
                           <tr>
                               <td><img src="./assets/my-icons/appointment_state-pending.svg" width="20" title="Pending" alt="-"> <small>Pending</small> </im></td>
                               <td ><img src="./assets/my-icons/blood_type-Power Red.svg" width="15" title="Red Power" alt="-"> <small></small>Red Power</im> </td>
                               <td class="text-center"><strong> O-</strong></td>
                               <td class="text-center">12</td>
                               <td>12-15-2021</td>
                               <td>
                                   <form  action="center/appointment" method="POST">
                                       <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                           <input type="hidden" name="id" value="${demand.getId()}">
                                           <button type="submit" name="action" value="accept" class="btn btn-success">Accept</button>
                                       </div>
                                   </form>
                               </td>
                           </tr>
                           <tr>
                               <td><img src="./assets/my-icons/appointment_state-pending.svg" width="20" title="Pending" alt="-"> <small>Pending</small> </im></td>
                               <td ><img src="./assets/my-icons/blood_type-Power Red.svg" width="15" title="Red Power" alt="-"> <small></small>Red Power</im> </td>
                               <td class="text-center"><strong> O-</strong></td>
                               <td class="text-center">12</td>
                               <td>12-15-2021</td>
                               <td>
                                   <form  action="center/appointment" method="POST">
                                       <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                           <input type="hidden" name="id" value="${demand.getId()}">
                                            <button type="submit" name="action" value="accept" class="btn btn-primary">Accept</button>
                                        </div>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td><img src="./assets/my-icons/appointment_state-fullfiled.svg" width="20" title="Pending" alt="-"> <small>fullfiled</small> </im></td>
                                <td ><img src="./assets/my-icons/blood_type-AB plasma.svg" width="15" title="Red Power" alt="-"> <small></small>AB plasma</im> </td>
                                <td class="text-center"><strong> O-</strong></td>
                                <td class="text-center">12</td>
                                <td>12-15-2021</td>
                                <td>
                                    
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card card-user  py-3">
            <div class="content px-2">
                <div class="author"> 
                    <img class="avatar border-gray" src="assets/images/avatar-hospital.png" alt="..."/>
                    <h4 class="title">Hopital militaire<br/>
                        <small title="code">1D5G77</small>
                    </h4>
                </div>
                <br/>
                <hr>
                <div class="content  px-3">
                <div class="row">
                        <div class="col-sm-2">
                            <img class="text-right" src="assets/icons/phone.svg" width="15" title="phone" alt="Phone">
                        </div>
                        <div class="col-sm-7">
                            +21200000
                        </div>    
                </div>
                <div class="row">
                        <div class="col-sm-2">
                            <img class="text-right" src="assets/icons/location.svg" width="15" title="city" alt="City">
                        </div>
                        <div class="col-sm-7">
                            Rabat
                        </div>    
                </div>
                <div class="row">
                        <div class="col-sm-2">
                            <img class="text-right" src="assets/icons/location.svg" width="15" title="adresse" alt="Address">
                        </div>
                        <div class="col-sm-7">
                            Boulvard kda kda
                        </div>    
                </div>
                <hr/>
                <div class="text-center">
                    <a href="#center/hospital/facturation?id=0" class="btn btn-danger btn-block">Facturation</a>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>
</c:set>


<%@ include file="../app.jsp"%>