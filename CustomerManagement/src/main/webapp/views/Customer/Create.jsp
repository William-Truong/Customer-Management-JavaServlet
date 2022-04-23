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
<title>Create Customer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/3fc531ce88.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../_header.jsp"></jsp:include>
	<main>
		<section class="row align-items-center justify-content-center">
			<div class="col-3 ">
				<h1 class="text-center">Create Customer</h1>
				<h1 class="text-center text-danger">${message}</h1>
				<form action="CreateCustomer" method="POST">
					<div class="mb-3">
    					<label for="" class="form-label">Name</label>
    					<input type="text" name="name" class="form-control" required>
  					</div>
  					<div class="mb-4">
    					<label for="" class="form-label">Email</label>
    					<input type="email" name="email" class="form-control" required>
  					</div>
  					<button class="btn btn-dark w-100">Create</button>
				</form>
				
			</div>
		</section>
	</main>
</body>
</html>