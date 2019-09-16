<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Customers</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp">Continuum</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="form-customer.jsp">Add Customer</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          View
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Sort by last name</a>
          <a class="dropdown-item" href="#">Sort by first name</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Sort by id</a>
        </div>
      </li>
    <!--   
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
     -->
    </ul>
    <form action="SearchCustomers" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="theSearchName">
      <button class="btn bg-dark text-white" type="submit">Search</button>
    </form>
  </div>
</nav>
<!-- 	
	<input type="button" value="Home" onclick="window.location.href='index.jsp'" class="btn btn-primary"> 
	<input type="button" value="Add Customer" onclick="window.location.href='form-customer.jsp'" class="btn btn-primary" >
	
	<form action="SearchCustomers" method="get" class="form-inline">
		<table class="table table-dark">
			<tr>
				<td>Customers</td>
				<td><i class="fas fa-search" aria-hidden="true"></i><input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search" aria-label="Search" name="theSearchName"></td>
				<td><input type="submit" value="search" class="btn btn-primary"></td>
			</tr>
		</table>	
	</form>
 -->
 <div class="container">
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>
		</thead>
		<c:forEach items="${customers}" var="customer" >
			<c:url var="deleteLink" value="/DeleteCustomer">
				<c:param name="cid" value="${customer.cid}"></c:param>
			</c:url>
			<c:url var="updateLink" value="/FormPopulateCustomer">
				<c:param name="cid" value="${customer.cid}"></c:param>
			</c:url>
			
			<tr>
				<td>${customer.cid}</td>
				<td>${customer.cfname}</td>
				<td>${customer.clname}</td>
				<td>${customer.email}</td>
				<td><input type="button" value="Update" onclick="window.location.href='${updateLink}'" class="btn btn-success">
				| <input type="button" value="Delete" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false; window.location.href='${deleteLink}'" class="btn btn-danger"></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>