<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 23.10.2019
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/registration">
    Login <input type="text" name="login" value="">
    First Name <input type="text" name="firstName" value="">
    Second Name <input type="text" name="secondName" value="">
    Age <input type="text" name="age" value="">
    Password <input type="password" name="password" value="">
    <input type="submit" value="Create">
</form>
</body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body class="bg-gradient-primary">
<div class="container">
    <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
            <div class="row">
                <div class="col-lg-5 d-none d-lg-flex">
                    <div class="flex-grow-1 bg-register-image"></div>
                </div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h4 class="text-dark mb-4">&nbsp;</h4>
                        </div>
                        <form class="user" method="get" action="/registration">

                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user"
                                                                          type="text" placeholder="Name"
                                                                          name="firstName" value=""></div>
                                <div class="col-sm-6"><input class="form-control form-control-user" type="text"
                                                             placeholder="Last name" name="secondName" value=""></div>
                            </div>
                            <div class="form-group"><input class="form-control form-control-user" type="text"
                                                           placeholder="Login" name="login" value=""></div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user"
                                                                          type="password" placeholder="Password"
                                                                          name="password" value=""></div>

                                <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user"
                                                                          type="text" placeholder="Age"
                                                                          name="age" value=""></div>
                                <button class="btn btn-primary btn-block text-white btn-user" type="submit">Create
                                </button>
                                <hr>
                                <hr>
                            </div>
                        </form>
                        <div class="text-center"><a class="small" href="login.html">Have an account? Log in!</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/bs-charts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>
