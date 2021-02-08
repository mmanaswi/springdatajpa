<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Movie Cruiser</title>
		<link rel="icon" type="image/ico" href="./images/logo.png" />
		<link rel="stylesheet" type="text/css" href="./style/style.css">
	</head>
	<body>
		<header>
			<span class="header-title">Movie Cruiser</span>
			<img class="header-logo" src="./images/logo.png" alt="Movie Cruiser Logo"></img>
			<nav>
				<a class="nav-link" href="/movie-list-admin">Movies</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Edit Movie Status</h2>
			<p class="article-notification col-left">Movie details saved successfully</p>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>