<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false"%>

<head>
<title> Edit user </title>
<style>
body {
	background-color: #545454;
	font-family: "Poppins", sans-serif;
	font-weight: 300
}

.card {
	padding: 100px;
	border: none
}

.height {
	height: 100vh
}

.inputs span {
	font-size: 13px;
	font-weight: 600;
	color: #9e9e9e
}

.inputs input {
	height: 48px;
	border: 2px solid #9e9e9e
}

.inputs input:focus {
	border: 2px solid blue;
	box-shadow: none
}

label.radio {
	cursor: pointer;
	width: 100%
}

label.radio input {
	position: absolute;
	top: 0;
	left: 0;
	visibility: hidden;
	pointer-events: none
}

label.radio span {
	padding: 7px 14px;
	border: 2px solid blue;
	display: inline-block;
	color: blue;
	border-radius: 3px;
	text-transform: uppercase;
	width: 100%;
	height: 49px;
	display: flex;
	justify-content: start;
	align-items: center
}

label.radio input:checked+span {
	border-color: blue;
	background-color: blue;
	color: #fff;
	width: 100%;
	height: 49px;
	display: flex;
	justify-content: start;
	align-items: center
}

.name {
	font-size: 13px;
	font-weight: 600;
	color: #9e9e9e;
	margin-left: 3px
}

.options {
	text-decoration: none
}

.btn-outline-primary {
	color: #0000ff;
	border-color: #0000ff
}

.btn-outline-primary:hover {
	background-color: #0000ff;
	border-color: #0000ff
}
</style>
</head>
<body>
	<div class="container">
		<div>
		    <form action="Edituservalidate" method="post">
			<div class="row height d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<div class="card py-5">
					<div class="inputs px-4">
						<span class="text-uppercase">User Name</span> <input type="text"
							class="form-control" name="uname" placeholder="${sessionScope.username }" readonly="readonly">
					</div>
					<div class="row mt-3 g-2">
						<div class="col-md-6">
							<div class="inputs px-4">
								<span class="text-uppercase">Mobile number</span> <input type="text"
									class="form-control" name="mobilenumber" placeholder="Mobile Number">
							</div>
						</div>
						<div class="col-md-6">
							<div class="inputs px-4">
								<span class="text-uppercase">New Password</span> <input type="text"
									class="form-control" name="newpassword" placeholder="New Password">
							</div>
						</div>
					</div>
					</div>
					
					<div
						class="mt-3 px-4 d-flex justify-content-between align-items-center">
						<button class="btn btn-primary" name="option" value="update">update user</button>
					</div>
				</div>
				</div>
				</form>
			</div>
		</div>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap" rel="stylesheet">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" "rel="stylesheet"></script>
</body>