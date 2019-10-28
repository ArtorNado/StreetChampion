<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
</head>
<body>
<form method="post" action="/profile">
    Login<input type="text" name="login" value="${cookies.name}">
    Password<input name="password" type="password" value="${cookies.password}">
    Remember me<input type="checkbox" name="checkBox">
    <input type="submit" value="Log in">
</form>
<form method="post" action="/registration">
    <input type="submit" value="Registration">
</form>
</body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,3..">

    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body class="bg-gradient-primary">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex">
                            <div class="flex-grow-1 bg-login-image">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="p-5">
                            <div class="text-center">
                                <h4 class="text-dark mb-4">Welcome!</h4>
                            </div>
                            <form method="post" action="/profile" class="user">
                                <div class="form-group"><input type="text" class="form-control form-control-user"

                                                               placeholder="Enter login" name="login"
                                                               value="${cookies.name}"/></div>

                                <div class="form-group"><input type="password"
                                                               class="form-control form-control-user"
                                                               placeholder="Enter password"
                                                               name="password" value="${cookies.password}"/></div>
                                <div class="form-group">
                                    <div class="custom-control custom-checkbox small">
                                        <div class="form-check"><input type="checkbox"
                                                                       class="form-check-input custom-control-input"
                                                                       id="formCheck-1" name="checkBox"/><label
                                                class="form-check-label custom-control-label" for="formCheck-1">Remember
                                            me</label></div>
                                    </div>
                                </div>
                                <input class="btn btn-primary btn-block text-white btn-user" type="submit"
                                       value="Log in">
                                </input>
                                <hr/>
                                <hr/>
                            </form>
                            <form action="/registration" method="post">
                                <input class="btn btn-dark btn-block text-white btn-user" type="submit"
                                       value="Create new account">
                                </input>
                            </form>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
