<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="..\..\..\pub\CSS\header.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
    <!--bootstrap-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="icon" type="image/png" href="..\..\..\pub\images\logo 1.ico">
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<section class="header">
    <nav>
        <a href="../index"><img src="..\..\..\pub\images\logo-animated2.gif" alt=""></a>
        <div class="nav-links" id="navLinks">
            <!-- Bootstrap button icon -->
            <i class="fa fa-times" onclick="hideMenu()"></i>
            <ul>
                <form class="authorization">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/user/register">| &nbsp; Sign Up &nbsp; |</a></li>
                </sec:authorize>

                <sec:authorize access="hasAuthority('ADMIN')">
                    <li><a href="/user/search">| &nbsp; Search &nbsp; |</a></li>
                </sec:authorize>

                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login/login">| &nbsp; Login &nbsp; |</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="/login/logout">&nbsp;| &nbsp; Logout &nbsp; |&nbsp;</a></li>
                    <li style="color: white; font-size: 12px;">Welcome <sec:authentication property="principal.username"/>!</li>
                </sec:authorize>
                </form>
                <li><a href="../index">HOME</a></li>
                <li><a href="../about">ABOUT</a></li>
                <li><a href="../news">NEWS</a></li>
                <li><a href="../pokemon/pokedex">Pok&#233;dex</a></li>
                <li><a href="../team/teambuilder">TEAMBUILDER</a></li>
                <li><a href="../forum">FORUM</a></li>
            </ul>
        </div>
        <!-- Bootstrap button icon -->
        <i class="fa fa-bars" onclick="showMenu()"></i>
    </nav>