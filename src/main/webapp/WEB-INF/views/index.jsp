
<!DOCTYPE html>

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Oracle database management</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<style>
.mainDiv{
width:1400px;
margin:0 auto;
}
.tableDiv{
margin-top:25px;
}
.title{
font-size:30px;
}
</style>
<script>
$(document).ready(function(){
	$("#RevokePrivUser").change(function(){
	    $.ajax({ method: "POST",
	    	url: "GetUserPrivByUsername",
	    	data: { username:$("#RevokePrivUser").val()},
	    	dataType: "json",
	    	
	    	success: function(result){
	    		$('#PrivUserList').html(" ");
	    		var data="";
	    		data+="<label>Privilege:</label><select class='form-control' name='privilege'>";
	    		
	    		var i;
	    		for( i=0;i<result.length;i++){
	    			data+="<option value='"+result[i]+"'>"+result[i]+"</option>";
	    		}
	    		data+="</select>";
	    		$('#PrivUserList').append(data);
	    }});
	});
	$("#RevokeRoleUser").change(function(){
	    $.ajax({ method: "POST",
	    	url: "GetUserRoleByUsername",
	    	data: { username:$("#RevokeRoleUser").val()},
	    	dataType: "json",
	    	
	    	success: function(result){
	    		$('#RevokeRoleUserDiv').html(" ");
	    		var data="";
	    		data+="<label>Role:</label><select class='form-control' name='rolename'>";
	    		
	    		var i;
	    		for( i=0;i<result.length;i++){
	    			data+="<option value='"+result[i]+"'>"+result[i]+"</option>";
	    		}
	    		data+="</select>";
	    		$('#RevokeRoleUserDiv').append(data);
	    }});
	
	});
	$("#RevokePrivFromRoleSl").change(function(){
	
		   $.ajax({ method: "POST",
		    	url: "getListRoletUserByRole",
		    	data: { rolename:$("#RevokePrivFromRoleSl").val()},
		    	dataType: "json",
		    	
		    	success: function(result){
		    		$('#RevokePrivFromRoleDiv').html(" ");
		    		var data="";
		    		data+="<label>Privilege:</label><select class='form-control' name='privilege'>";
		    		
		    		var i;
		    		for( i=0;i<result.length;i++){
		    			data+="<option value='"+result[i]+"'>"+result[i]+"</option>";
		    		}
		    		data+="</select>";
		    		$('#RevokePrivFromRoleDiv').append(data);
		    }});
	
	});
	$("#RoleNameToAdd").change(function(){
		
		   $.ajax({ method: "POST",
		    	url: "getListRoleExcept",
		    	data: { rolename:$("#RoleNameToAdd").val()},
		    	dataType: "json",
		    	
		    	success: function(result){
		    		$('#RoleNameToBeAddedDiv').html(" ");
		    		var data="";
		    		data+="<label>Role name to be added:</label><select class='form-control' name='rolenametobeadded'>";
		    		
		    		var i;
		    		for( i=0;i<result.length;i++){
		    			data+="<option value='"+result[i]+"'>"+result[i]+"</option>";
		    		}
		    		data+="</select>";
		    		$('#RoleNameToBeAddedDiv').append(data);
		    }});
	
	});
	$("#RoleNameRevoke").change(function(){
		
		   $.ajax({ method: "POST",
		    	url: "getListRoleFromSelectedRole",
		    	data: { rolename:$("#RoleNameRevoke").val()},
		    	dataType: "json",
		    	
		    	success: function(result){
		    		$('#RoleNameToBeRevokedDiv').html(" ");
		    		var data="";
		    		data+="<label>Role name to be added:</label><select class='form-control' name='rolenametoberevoked'>";
		    		
		    		var i;
		    		for( i=0;i<result.length;i++){
		    			data+="<option value='"+result[i]+"'>"+result[i]+"</option>";
		    		}
		    		data+="</select>";
		    		$('#RoleNameToBeRevokedDiv').append(data);
		    }});
	
	});
	
	
	
	
	
});
</script>
</head>
<body>
<div class="mainDiv">

<!-- The Modal -->
<div class="modal" id="createUser">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Create user</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="createUser" method="post">

<div class="form-group">
    <label >Username:</label>
    <input type="text" class="form-control" name="username">
  </div>
  
  <div class="form-group">
    <label >Password:</label>
    <input type="password" class="form-control" name="password">
  </div>
  
    <div class="form-group">

    <input type="submit" class="form-control" value="create">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<!-- The Modal -->
<div class="modal" id="deleteUser">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Delete user</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="deleteUser" method="post">

<div class="form-group">
    <label >Username:</label>
      <select class="form-control" name="username">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
  </div>
  

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Delete" style="background-color:red;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="changeUserPassword">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Change user password</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="changeUserPassword" method="post">

<div class="form-group">
    <label >Username:</label>
    <select class="form-control" name="username">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
    
  </div>
  <div class="form-group">
    <label >New password:</label>
    <input type="text" class="form-control" name="newPass">
    
  </div>

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Change password" style="background-color:green;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="tableDiv">
<div class="row" style="height:700px;">
<div class="col-6">
<!-- Button to Open the Modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createUser">
  Create user
</button>
<!-- Button to Open the Modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteUser" style="background-color:red;">
  Delete user
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#changeUserPassword" style="background-color:green;">
  Change user password
</button>
<p class="title">Users list</p>
<table id="data" class="table table-borerded">
<thead>
<tr>
<th>USERNAME</th>
<th>USER_ID</th>
<th>CREATED</th>
</tr>
</thead>
<tbody>


<c:forEach items="${listUser}" var="user" >
<tr>

<td>${user.username}</td>
<td>${user.user_id}</td>
<td>${user.created}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
</div>
<div class="col-6">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNewPrivilege" style="background-color:green;">
  Add new privilege to user
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#RevokePrivilege" style="background-color:red;">
 Revoke privilege from user
</button>
<div class="modal" id="addNewPrivilege">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add new privilege to user</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="addNewPrivilege" method="post">

<div class="form-group">
    <label >Username:</label>
    <select class="form-control" name="username">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
    
  </div>
  <div class="form-group">
    <label >Privilege:</label>
   <select class="form-control" name="privilege">
      <c:forEach items="${listPrivilegeCanSet}" var="priv" >
       <option value="${priv}">${priv}</option>
</c:forEach>
  </div>

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Add privilege" style="background-color:green;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="RevokePrivilege">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Revoke privilege from user</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="revokePrivilege" method="post">

<div class="form-group">
    <label >Username:</label>
    <select class="form-control" name="username" id="RevokePrivUser">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
    
  </div>
  <div class="form-group" id="PrivUserList">
    

  </div>

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Revoke privilege" style="background-color:red;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<p class="title">Users's privilege</p>
<table id="listPriviUser" class="table table-borerded">
<thead>
<tr>
<th>USERNAME</th>
<th>PRIVILEGE</th>
<th>CREATED</th>
</tr>
</thead>
<tbody>


<c:forEach items="${listPriviUser}" var="user" >
<tr>

<td>${user.username}</td>
<td>${user.privilege}</td>
<td>${user.adminOption}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
</div>
</div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#SetQuota" ">
Set quota user
</button>
<div class="modal" id="SetQuota">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Set quota</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="setQuotaUser" method="post">
<div class="form-group">
    <label >Username:</label>
    <select class="form-control" name="username">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
    
  </div>
<div class="form-group">
    <label >Quota megabyte:</label>
<input type="number" min="1"  max="2097151" class="form-control" name="quotaset">
    
  </div>


  
    <div class="form-group">

    <input type="submit" class="form-control" value="Set quota" style="background-color:green;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<p class="title">Quota management</p>
<table id="listQuota" class="table table-borerded">
<thead>
<tr>
<th>TABLESPACE_NAME</th>
<th>USERNAME</th>
<th>BYTES</th>
<th>MAX_BYTES</th>
<th>BLOCKS</th>
<th>MAX_BLOCKS</th>
<th>DROPPED</th>
</tr>
</thead>
<tbody>


<c:forEach items="${listQuota}" var="quota" >

<tr>

<td>${quota.tablespaceName}</td>
<td>${quota.username}</td>
<td>${quota.bytes}</td>
<td>${quota.maxBytes}</td>
<td>${quota.blocks}</td>
<td>${quota.maxBlocks}</td>
<td>${quota.dropped}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#CreateRole" style="background-color:green;">
 Create new role
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#DropRole" style="background-color:red;">
 Delete role
</button>

<div class="modal" id="CreateRole">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Create role</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="createRole" method="post">

<div class="form-group">
    <label >Role name:</label>
<input type="text" class="form-control" name="rolename">
    
  </div>


  
    <div class="form-group">

    <input type="submit" class="form-control" value="Create role" style="background-color:green;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>



<div class="modal" id="DropRole">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Delete role</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="dropRole" method="post">

<div class="form-group">
    <label >Role name:</label>
    <select name="rolename" class="form-control">
    <c:forEach items="${listRoleUser}" var="rolesa" >
    <option value="${rolesa.role}">${rolesa.role}</option>
    </c:forEach>
    </select>

    
  </div>


  
    <div class="form-group">

    <input type="submit" class="form-control" value="Drop role" style="background-color:red;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<p class="title">List role</p>
<table id="listRoleUser" class="table table-borerded">
<thead>
<tr>
<th>ROLE</th>
<th>PASSWORD_REQUIRED</th>
<th>AUTHENTICATION_TYPE</th>
</tr>
</thead>
<tbody>


<c:forEach items="${listRoleUser}" var="rolesa" >

<tr>

<td>${rolesa.role}</td>
<td>${rolesa.passwordRequired}</td>
<td>${rolesa.authenticationType}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AddRoleToUsers" >
 Add role to users
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#RevokeRoleFromUsers" style="background-color: red;">
 Revoke role from users
</button>
<div class="modal" id="AddRoleToUsers">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add role to user</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="AddRoleToUser" method="post">

<div class="form-group">
    <label >Username:</label>
    <select class="form-control" name="username">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
    
  </div>

<div class="form-group">
    <label >Role name:</label>
    <select name="rolename" class="form-control">
    <c:forEach items="${listRoleUser}" var="rolesa" >
    <option value="${rolesa.role}">${rolesa.role}</option>
    </c:forEach>
    </select>

    
  </div>
  
    <div class="form-group">

    <input type="submit" class="form-control" value="Add role to user" style="background-color:green;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="RevokeRoleFromUsers">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Revoke role from user</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="revokeRoleFromUser" method="post">

<div class="form-group">
    <label >Username:</label>
    <select class="form-control" name="username" id="RevokeRoleUser">
    <c:forEach items="${listUser}" var="user" >
       <option value="${user.username}">${user.username}</option>
</c:forEach>
   </select>
    
  </div>

<div class="form-group" id="RevokeRoleUserDiv">

    
  </div>
  
    <div class="form-group">

    <input type="submit" class="form-control" value="Revoke role from user" style="background-color:red;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<p class="title">Users and their role</p>
<table id="UserAndTheirRoleList" class="table table-borerded">
<thead>
<tr>
<th>GRANTEE</th>
<th>GRANTED_ROLE</th>
<th>ADMIN_OPTIN</th>
<th>DEFAULT_ROLE</th>
</tr>
</thead>
<tbody>


<c:forEach items="${UserAndTheirRoleList}" var="rolesa" >

<tr>

<td>${rolesa.grantee}</td>
<td>${rolesa.grantedRole}</td>
<td>${rolesa.adminOption}</td>
<td>${rolesa.defaultRole}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AddPrivilegeToRole" >
 Add privilege to role
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#RevokePrivilegeFromRole" style="background-color:red;">
 Revoke privilege from role
</button>
<div class="modal" id="AddPrivilegeToRole">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add privilege to role</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="AddPrivilegeToRole" method="post">

<div class="form-group">
    <label >Role name:</label>
    <select name="rolename" class="form-control">
    <c:forEach items="${listRoleUser}" var="rolesa" >
    <option value="${rolesa.role}">${rolesa.role}</option>
    </c:forEach>
    </select>

    
  </div>
  <div class="form-group">
    <label >Privilege:</label>
   <select class="form-control" name="privilegename">
      <c:forEach items="${listPrivilegeCanSet}" var="priv" >
       <option value="${priv}">${priv}</option>
</c:forEach>
  </div>

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Add privilege to this role" style="background-color:blue;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<div class="modal" id="RevokePrivilegeFromRole">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Revoke Privilege From Role</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="revokePrivFromRole" method="post">

<div class="form-group">
    <label >Role name:</label>
    <select name="rolename" class="form-control" id="RevokePrivFromRoleSl">
    <c:forEach items="${listRoleUser}" var="rolesa" >
    <option value="${rolesa.role}">${rolesa.role}</option>
    </c:forEach>
    </select>

    
  </div>

<div class="form-group" id="RevokePrivFromRoleDiv">

    
  </div>
  
    <div class="form-group">

    <input type="submit" class="form-control" value="Revoke privilege from role" style="background-color:red;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<p class="title">Role's privileges</p>
<table id="listRolePrivileged" class="table table-borerded">
<thead>
<tr>
<th>ROLE</th>
<th>PRIVILEGE</th>
<th>ADMIN_OPTION</th>
</tr>
</thead>
<tbody>


<c:forEach items="${listRolePrivileged}" var="rolesa" >

<tr>

<td>${rolesa.role}</td>
<td>${rolesa.privilege}</td>
<td>${rolesa.adminOption}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AddRoleToRole" >
 Add role to role
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#RevokeRoleFromRole" style="background-color:red;">
 Revoke role from role
</button>
<div class="modal" id="AddRoleToRole">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add role to role</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="AddRoleToRole" method="post">

<div class="form-group">
    <label >Role name:</label>
    <select name="rolename" class="form-control" id="RoleNameToAdd">
    <c:forEach items="${listRoleUser}" var="rolesa" >
    <option value="${rolesa.role}">${rolesa.role}</option>
    </c:forEach>
    </select>

    
  </div>
<div class="form-group" id="RoleNameToBeAddedDiv">
    

    
  </div>

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Add role to this role" style="background-color:blue;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="RevokeRoleFromRole">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Revoke role from role</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form action="revokeRoleFromRole" method="post">

<div class="form-group">
    <label >Role name:</label>
    <select name="rolename" class="form-control" id="RoleNameRevoke">
    <c:forEach items="${listRoleUser}" var="rolesa" >
    <option value="${rolesa.role}">${rolesa.role}</option>
    </c:forEach>
    </select>

    
  </div>
<div class="form-group" id="RoleNameToBeRevokedDiv">
    

    
  </div>

  
    <div class="form-group">

    <input type="submit" class="form-control" value="Revoke role from this role" style="background-color:red;color:white;">
  </div>
  
</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<p class="title">Role's roles</p>
<table id="listRoleRole" class="table table-borerded">
<thead>
<tr>
<th>ROLE</th>
<th>GRANTED_ROLE</th>
<th>ADMIN_OPTION</th>
</tr>
</thead>
<tbody>


<c:forEach items="${ListRoleToRole}" var="rolesa" >

<tr>

<td>${rolesa.role}</td>
<td>${rolesa.grantedRole}</td>
<td>${rolesa.adminOption}</td>
</tr>
   
</c:forEach>




</tbody>
</table>
</div>
</div>
<script>
$(document).ready(function() {
	 $('#data').DataTable();
	 $('#listPriviUser').DataTable();
	 $('#listRoleUser').DataTable();
	 $('#UserAndTheirRoleList').DataTable();
	 $('#listRolePrivileged').DataTable();
	 $('#listRoleRole').DataTable();
	 $('#listQuota').DataTable();
});

</script>
</body>
</html>