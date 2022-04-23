<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/3fc531ce88.js" crossorigin="anonymous"></script>
<style>
	form input{
		margin-right: 5px;
	}
</style>
</head>
<body>
	<jsp:include page="../_header.jsp"></jsp:include>
	<main>
		<section class="container">
			<div class="row">
				<article class="col-12">
					<h1 class="text-center mb-4">
						List Customers
					</h1>
					<h1 class="text-center text-danger mb-4">
						${message}
					</h1>
				</article>
			</div>			
			<div class="row align-items-center justify-content-between mb-3">
				<div class="col-2">
					<a href="CreateCustomer" class="nav-link text-dark">
						<i class="fa-solid fa-circle-plus"></i> New Customer
					</a>
				</div>
				<div class="col-4">
					<form class="d-flex align-items-center" action="${pageContext.request.contextPath}/Customers" method="GET">
						<input type="text" name="keyword" placeholder="Search customer..." class="form-control"/>
						<button class="btn btn-dark" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
					</form>
				</div>
			</div>
			<div class="row">
				<article class="col-12">
					<table class="table">
						<thead>
							<tr class="table-dark">
      							<th scope="col">ID</th>
      							<th scope="col">NAME</th>
      							<th scope="col">EMAIL</th>
      							<th scope="col">CREATED DATE</th>
      							<th scope="col">UPDATED DATE</th>
      							<th scope="col">EDIT</th>
      							<th scope="col">DELETE</th>
    						</tr>
						</thead>
						<tbody>
							<c:forEach items="${customers}" var="customer">
							<tr>
								<th scope="row">${customer.id}</th>
      							<td>${customer.name}</td>
      							<td>${customer.email}</td>
      							<td>${customer.created_date}</td>
      							<td>${customer.updated_date}</td>
      							<td><a href="EditCustomer?id=${customer.id}">Edit</a></td>
      							<td><a href="DeleteCustomer?id=${customer.id}">Delete</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</article>
			</div>
		</section>
	</main>
</body>
</html>