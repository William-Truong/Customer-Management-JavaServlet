<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/3fc531ce88.js" crossorigin="anonymous"></script>
<style>
	form{
		padding-top: 40%;
	}
</style>
</head>
<body>
	<main class="container">
		<section class="row align-items-center justify-content-center">
			<div class="col-4">
				<form action="Login" method="POST">
					<h1 class="mb-4 text-center">Admin</h1>
					<h4 class="mb-4 text-center text-danger">${message }</h1>
  					<div class="mb-3">
    					<label for="" class="form-label">Username</label>
    					<input type="text" name="username" class="form-control" id="">
  					</div>
  					<div class="mb-5">
    					<label for="" class="form-label">Password</label>
    					<input type="password" name="password" class="form-control" id="">
  					</div>
  					<button type="submit" class="btn btn-dark w-100 mb-3">Login</button>
  					<div>
  						<span>You have an account? </span>
  						<a href="${pageContext.request.contextPath}/SignUp">SignUp Now</a>
  					</div>
				</form>
			</div>
		</section>
	</main>	
</body>
</html>