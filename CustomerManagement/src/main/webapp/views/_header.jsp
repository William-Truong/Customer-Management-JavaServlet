<%@page import="beans.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	header{
		background-color:#212529;
	}
	a.nav-link{
		color:white;
		font-size: 18px;
	}
	.btn-dark:focus{
		background-color: unset;
	}
</style>
<%
Account account = (Account) session.getAttribute("ss_user_token");
String name = "Login Now";
if(account != null) {
	name = account.getName();
}
%>
<header class="mb-4">
	<section class="container">
		<div class="row justify-content-between align-items-center">
			<ul class="nav col-4">
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/">Dashboard</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/Customers">Customers</a>
  </li>
</ul>
			<div class="col-3">
				<div class="dropdown">
  					<button class="btn btn-dark dropdown-toggle" type="button" id="account-menu" data-bs-toggle="dropdown" aria-expanded="false">
    				<%= name %>
  					</button>
  					<ul class="dropdown-menu" aria-labelledby="account-menu">
    					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">LogOut</a></li>
  					</ul>
</div>
			</div>
		</div>
	</section>
</header>