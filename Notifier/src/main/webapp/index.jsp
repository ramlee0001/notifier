<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NOTIFIER LOBBY</title>
<style>
login-container{
    margin-top: 5%;
    margin-bottom: 5%;
}
.login-logo{
    position: relative;
    margin-left: -41.5%;
}
.login-logo img{
    position: absolute;
    width: 20%;
    margin-top: 19%;
    background: #282726;
    border-radius: 4.5rem;
    padding: 5%;
}
.login-form-1{
    padding: 31%;
    background:#282726;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-1 h3{
    text-align: center;
    margin-bottom:12%;
    color:#fff;
}
.login-form-2{
    padding: 31%;
    background: #f05837;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-2 h3{
    text-align: center;
    margin-bottom:12%;
    color: #fff;
}
.btnSubmit{
    color: #fff;
    font-weight: 600;
    text-decoration: none;
}
.btnForgetPwd{
    
    font-weight: 600;
    width: 50%;
    color: #282726;
    background-color: #FFFF00;
    border: none;
    border-radius: 1.5rem;
    padding:45%;
}
.btnForgetPwd:hover{
    text-decoration:none;
    color:#FF0000;
}
</style>
</head>
<body>
<div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                    
                    
                        <div class="form-group">
                            <a href="login.jsp" class="btnForgetPwd">Login</a>
                        </div>
                    
                </div>
                <div class="col-md-6 login-form-2">
                    <div class="login-logo">
                       
                    </div>
                    
                        <div class="form-group">

                            <a href="register.jsp" class="btnForgetPwd" >Register</a>
                        </div>
                    
                </div>
            </div>
        </div>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>