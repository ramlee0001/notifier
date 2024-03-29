<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>New Note</title>
<style>
/*Contact sectiom*/
.content-header {
	font-family: 'Oleo Script', cursive;
	color: #fcc500;
	font-size: 45px;
}

.section-content {
	text-align: center;
}

#contact {
	font-family: 'Teko', sans-serif;
	padding-top: 60px;
	width: 100%;
	width: 100vw;
	height: 550px;
	background: #3a6186; /* fallback for old browsers */
	background: -webkit-linear-gradient(to left, #3a6186, #89253e);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to left, #3a6186, #89253e);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	color: #fff;
}

.contact-section {
	padding-top: 40px;
}

.contact-section .col-md-6 {
	width: 50%;
}

.form-line {
	border-right: 1px solid #B29999;
}

.form-group {
	margin-top: 10px;
}

label {
	font-size: 1.3em;
	line-height: 1em;
	font-weight: normal;
}

.form-control {
	font-size: 1.3em;
	color: #080808;
}

textarea.form-control {
	height: 135px;
	/* margin-top: px;*/
}

.submit {
	font-size: 1.1em;
	float: right;
	width: 150px;
	background-color: transparent;
	color: #fff;
}
</style>
</head>
<body>
	<link
		href="https://fonts.googleapis.com/css?family=Oleo+Script:400,700"
		rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Teko:400,700"
		rel="stylesheet">
	<link
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
		rel="stylesheet">

	<section id="contact">
		<div class="section-content">
			<h1 class="section-header">
				<span class="content-header wow fadeIn "
					data-wow-delay="0.2s" data-wow-duration="2s"> NEW NOTE</span>
			</h1>
		</div>
		<div class="contact-section">
			<div class="container">
				 <form action="Addnotes" method="post">
					<div class="col-md-6 form-line">
						<div class="form-group">
							<label for="exampleInputUsername">Title</label> <input
								type="text" class="form-control" name="title" id="" placeholder=" Title ">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail">Date</label> <input
								type="date" class="form-control" name="date" id="exampleInputEmail"
								placeholder=" DD/MM/YYYY ">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="description"> Notes</label>
							<textarea class="form-control" name="note" id="description"
								placeholder="Enter Your Note"></textarea>
						</div>
						<div>

							<button type="submit" class="btn btn-default submit" name="option" value="done">
								<i class="fa fa-submit" aria-hidden="true"></i> Done
								
							</button>
						</div>

					</div>
				</form>
			</div>
	</section>
</body>
</html>