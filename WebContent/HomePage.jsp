<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SiLPH Inc.</title>

<!-- Link per il CSS di Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!--  Link per le icone di FontAwesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">

<!-- CSS locale per override -->
<link rel="stylesheet" href="CSS/HomePage.css">
<link rel="stylesheet" href="CSS/silphbar.css">
<link rel="stylesheet" href="CSS/hover.css">
<link rel="stylesheet" href="CSS/fotocell.css">
<link rel="stylesheet" href="CSS/albumcell.css">

<!-- Favicon del tab -->
<link rel="icon" type="image/ico" href="Data/retro-photo-favicon.ico">

<!-- Google fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Sedgwick+Ave+Display|Staatliches|Oswald|Ubuntu&display=swap"
	rel="stylesheet">
</head>
<body>

	<!-- Inizio Navigation Bar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<a class="navbar-brand" href="#"> <i
			class="fas fa-camera-retro fa-fw silphbar-icon"></i>Silph Inc.
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">Fotografi</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Album</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Fotografie</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Moduli</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Tag(s)..." aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i
						class="fas fa-user-tie fa-fw dropdown-icon"></i></a>
					<div class="dropdown-menu dropdown-menu-right silph-login-dropdown"
						aria-labelledby="navbarDropdown">
						<form class="px-4 py-3">
							<div class="form-group">
								<label for="exampleDropdownFormID1">ID Funzionario</label> <input
									type="text" class="form-control" id="exampleDropdownFormID1"
									placeholder="ID" size="30">
							</div>
							<div class="form-group">
								<label for="exampleDropdownFormPassword1">Password</label> <input
									type="password" class="form-control"
									id="exampleDropdownFormPassword1" placeholder="Password"
									size="30">
							</div>
							<button type="submit" class="btn btn-primary">Sign in</button>
						</form>
					</div></li>
			</ul>
		</div>
	</nav>
	<!-- Fine Navigation Bar -->

	<!-- Inizio sezione Foto -->
	<div id="foto-jumbotron" class="jumbotron text-center">
		<div class="container-fluid">
			<h1 class="jumbotron-heading">Foto</h1>
			<p class="lead">
				<i>le nostre immagini più recenti.</i>
			</p>
		</div>
	</div>


	<div id="foto-section">
		<div class="container">
			<div class="row">

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example1.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example2.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example3.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example4.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example5.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example6.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example7.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example8.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 fotocell">
					<div class="card mx-auto shadow-lg ">
						<div class="hovereffect">
							<a href="#" class="pop"> <img class="card-img"
								src="SampleData/Pics/example9.jpg" data-toggle="modal"
								data-target="#imagemodal" />
							</a>
							<div class="overlay">
								<h4 class="card-title">Titolo Foto</h4>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- Fine sezione Foto -->

	<!-- Inizio sezione Album -->
	<div id="album-jumbotron" class="jumbotron text-center">
		<div class="container-fluid">
			<h1 class="jumbotron-heading">Album</h1>
			<p class="lead">
				<i>le nostre raccolte più attuali.</i>
			</p>
		</div>
	</div>
	<div id="album-section">
		<div class="container">
			<div class="row mb-2">
				<div class="col-md-6">
					<div class="card flex-md-row mb-4 shadow-sm h-md-200 albumcell">
						<div class="card-body d-flex flex-column align-items-end">
							<h3 class="mb-0">
								<a class="text-dark" href="#">Titolo Album</a>
							</h3>
							<a href="#" class="mb-1 text-muted">Nome Autore</a>
							<p class="card-text mb-auto text-right text-truncate">Lorem
								ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus
								est, malesuada quis placerat sed, congue at odio. Suspendisse
								rhoncus tortor et aliquet eleifend.</p>

							</span>
						</div>
						<a href="#"> <img
							class="card-img-right flex-auto d-none d-lg-block"
							src="SampleData/Pics/example1.jpg"></a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card flex-md-row mb-4 shadow-sm h-md-200 albumcell">
						<a href="#"> <img
							class="card-img-left flex-auto d-none d-lg-block"
							src="SampleData/Pics/example2.jpg"></a>

						<div class="card-body d-flex flex-column align-items-start">
							<h3 class="mb-0">
								<a class="text-dark" href="#">Titolo Album</a>
							</h3>
							<a href="#" class="mb-1 text-muted">Nome Autore</a>
							<p class="card-text mb-auto">Breve descrizione dell'album.
								Parla degli argomenti presentati al suo interno.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Fine sezione Album -->

	<!-- Inizio sezione Album -->
	<div id="fotografi-jumbotron" class="jumbotron text-center">
		<div class="container-fluid">
			<h1 class="jumbotron-heading">Fotografi</h1>
			<p class="lead">
				<i>i nostri artisti più giovani.</i>
			</p>
		</div>
	</div>
	<div id="fotografi-section"></div>
	<!-- Fine sezione Album -->

	<script>
		$(function() {
			$('.pop').on(
					'click',
					function() {
						$('.imagepreview').attr('src',
								$(this).find('img').attr('src'));
						$('#imagemodal').modal('show');
					});
		});
	</script>

	<!-- Modal -->
	<div class="modal fade" id="imagemodal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="row">
					<div class="col-md-8 pr-0" id="showImg">
						<img src="" class="imagepreview" style="width: 100%;">
					</div>
					<div class="col-md-4 pl-0">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Titolo
								Foto</h5>
						</div>
						<div class="modal-body">Breve descrizione della foto.
							Invoglia il Cliente a comprare la foto.</div>
						<div class="modal-footer">
							<p class="text-left">20€</p>
							<button type="button" class="btn btn-primary">Seleziona</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- JS Per alcune animazioni di Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>