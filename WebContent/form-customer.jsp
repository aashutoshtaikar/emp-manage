<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!--Navbar-->
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
        <a class="nav-link disabled" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" aria-disabled="true">
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
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn bg-dark text-white" type="submit">Search</button>
    </form>
  </div>
</nav>
<!--/.Navbar-->

<div class="container">
<form action="CreateCustomer">
  <div action="CreateCustomer" class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" value="${customer.email}">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
   <div class="form-group">
    <label for="exampleInputFirstName1">Id</label>
    <input type="text" class="form-control" id="exampleInputFirstName1" placeholder="First Name" name="cid" value="${customer.cid}">
  </div>
  <div class="form-group">
    <label for="exampleInputFirstName1">First Name</label>
    <input type="text" class="form-control" id="exampleInputFirstName1" placeholder="First Name" name="cfname" value="${customer.cfname}">
    <label for="exampleInputFirstName1">Last Name</label>
    <input type="text" class="form-control" id="exampleInputFirstName1" placeholder="Last Name" name="clname" value="${customer.clname}">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>


