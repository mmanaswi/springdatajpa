<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Movie Cruiser</title>
		<link rel="icon" type="image/ico" href="images/logo.png" />
		<link rel="stylesheet" type="text/css" href="style/style.css">
		<script src="js/script.js"></script>
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
			<h2 class="article-heading">Edit Movie</h2>
			<form:form name="editMovieForm" method="post" action="update" modelAttribute="movie" onsubmit="return validateForm()">
				<table class="form-table">
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Title</label>
							<form:hidden path="id" value="${movie.id}"/>
							<form:input class="form-input" path="title" id="title" name="title" value="${movie.title}"></form:input>
							<p class="form-error-message" id="title-error"></p>
						</td>
					</tr>
					<tr>
						<td>
							<label class="form-item" for="field-boxOffice">Box Office ($)</label>
							<form:input class="form-input form-input-right" path="boxOffice" name="boxOffice" id="boxOffice" value="${movie_boxOffice }"></form:input>
							<p class="form-error-message" id="boxOffice-error"></p>
						</td>
						<th>
							<label class="form-item" for="field-yes">Active</label><br>
							<form:radiobutton path="active" value="true" /><label class="form-item" for="field-yes">Yes</label>
							<form:radiobutton path="active" value="false" /><label class="form-item" for="field-no">No</label>
						</th>
						<td>
							<label class="form-item" for="field-dateOfLaunch">Date of Launch</label>
							<input class="form-input" type="date" path="dateOfLaunch" name="dateOfLaunch" id="field-dateOfLaunch" placeholder="dd/mm/yyyy" value="${movie.dateOfLaunch }"></input>
							<p class="form-error-message" id="dateOfLaunch-error"></p>
						</td>
						<td>
							<label class="form-item" for="field-genre">Genre</label>
							<form:select path="genre" class="form-input" name="genre" id="field-genre">
								<form:option value="select">--Select--</form:option>
								<form:option value="Science Fiction">Science Fiction</form:option>
								<form:option value="Superhero">Superhero</form:option>
								<form:option value="Romance">Romance</form:option>
								<form:option value="Comedy">Comedy</form:option>
								<form:option value="Adventure">Adventure</form:option>
								<form:option value="Thriller">Thriller</form:option>
							</form:select>
							<p class="form-error-message" id="genre-error"></p>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<label class="form-item" for="field-hasTeaser">
								<form:checkbox path="hasTeaser" name="hasTeaser" id="field-hasTeaser" value="true" />has Teaser
								<span class="form-checkbox"></span>
							</label>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<input class="form-button" type="submit" name="submit" value="Save"></input>
						</td>
					</tr>
				</table>
			</form:form>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>