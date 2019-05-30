<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head profile="http://www.w3.org/2005/10/profile">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>SiLPH Inc.</title>

	<!-- Link per Bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<!--  Link per le icone di FontAwesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
		integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

	<!-- Favicon del tab -->
	<link rel="icon" type="image/ico" href="Data/retro-photo-favicon.ico">

	<link rel="stylesheet" href="./css/hover.css">
</head>

<body>
	<!-- Sezione topbar  -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="homepage.jsp"> <i class="fas fa-camera-retro fa-fw"
				style="color: rgb(43, 43, 43)"></i>SiLPH
			Inc.
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">Fotografi</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Album</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Fotografie</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Moduli</a>
				</li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search" placeholder="Tag(s)..." aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
					</form>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-user-tie fa-fw" style="color: rgb(43, 43, 43); font-size: 20px"></i></a>

					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown"
						style="width: 300px">
						<form class="px-4 py-3">
							<div class="form-group">
								<label for="exampleDropdownFormID1">ID Funzionario</label> <input type="text"
									class="form-control" id="exampleDropdownFormID1" placeholder="ID" size="30">
							</div>
							<div class="form-group">
								<label for="exampleDropdownFormPassword1">Password</label> <input type="password"
									class="form-control" id="exampleDropdownFormPassword1" placeholder="Password"
									size="30">
							</div>
							<button type="submit" class="btn btn-primary">Sign in</button>
						</form>
					</div>
				</li>
			</ul>
		</div>
	</nav>

	<!-- sezione tiles fotografi -->

	<!-- Allora, in questo "container" alcune cose andranno cambiate quando avremo un backend:
		1. La generazione dei tile dovrò essere dinamica (genero tile con un for ogni volta che carica la pagina)
		2. Nome, congome, immagine e la biogrfia saranno dati dinamici di ogni fotografo
	-->
	<div class="container-fluid mt-4">

		<div class="row justify-content-center">

			<div class="col-auto mb-1">
				<div class="card" style="width: 20rem;">
					<div class="hovereffect">
						<a href="#"><img class="card-img fitSize" src="./Images/spacey.jpg"></a>
						<div class="overlay">
							<h4 class="card-title">Nome Cognome</h4>
						</div>
					</div>
				</div>
			</div>

			<div class="col-auto mb-3">
				<div class="card" style="width: 20rem;">
					<div class="hovereffect">
						<a href="#"><img class="card-img" src="./Images/mk.jpg"></a>
						<div class="overlay">
							<h4 class="card-title">Nome Cognome</h4>
						</div>
					</div>
				</div>
			</div>

			<div class="col-auto mb-3">
				<div class="card" style="width: 20rem;">
					<div class="hovereffect">
						<a href="#"><img class="card-img" src="./Images/user-placeholder.png"></a>
						<div class="overlay">
							<h4 class="card-title">Nome Cognome</h4>
						</div>
					</div>
				</div>
			</div>

			<div class="col-auto mb-3">
				<div class="card" style="width: 20rem;">
					<div class="hovereffect">
						<a href="#"><img class="card-img" src="./Images/image-2.jpg"></a>
						<div class="overlay">
							<h4 class="card-title">Nome Cognome</h4>
						</div>
					</div>
				</div>
			</div>

			<div class="col-auto mb-3">
				<div class="card" style="width: 20rem;">
					<div class="hovereffect">
						<a href="#"><img class="card-img" src="./Images/pkc.jfif"></a>
						<div class="overlay">
							<h4 class="card-title">Nome Cognome</h4>
						</div>
					</div>
				</div>
			</div>






		</div>
	</div>




	<!-- JS Per alcune animazioni di Bootstrap (ad esempio il menù Dropdown) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>

</html>