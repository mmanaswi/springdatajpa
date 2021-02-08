<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Movie Cruiser</title>
<link rel="icon" type="image/ico" href="./images/logo.png" />
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header>
		<span class="header-title">Movie Cruiser</span> <img
			class="header-logo" src="./images/logo.png" alt="Movie Cruiser Logo"></img>
		<nav>
			<a class="nav-link" href="/movie-list-customer">Movies</a> <a
				class="nav-link" href="favoritiesMovies?id=1">Favorites</a>
		</nav>
	</header>
	<article>
		<h2 class="article-heading">Favorites</h2>
		<table>
			<tr>
				<th class="col-left">Title</th>
				<th class="col-right">Box Office</th>
				<th>Genre</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="p" items="${movieslist }">
				<tr>
					<td class="col-left">${p.title }</td>
					<td class="col-right">${p.boxOffice }</td>
					<td>${p.genre}</td>
					<td><a class="action-link"
						href="deleteFromFavorities?id=${p.id }">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" class="col-left">
					<p class="table-message">
						<strong>No. of Favorites:</strong>${movieslist.size() }</p>
				</td>
			</tr>
		</table>
	</article>
	<footer>
		<p>Copyright &copy; 2019</p>
	</footer>
</body>
</html>