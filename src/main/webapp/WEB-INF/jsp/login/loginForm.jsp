<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="..\..\..\pub\CSS\loginForm.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">

<form action="/login/loginSubmit" method="POST">

    <section class="login">
        <h1>Login</h1>
        <form class="input">
        <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
        <input type="text" name="username" placeholder="email">
    <br>
    <br>
        <span><i aria-hidden="true" class="fa fa-lock"></i></span>
        <input type="password" name="password" placeholder="password">
    <br>
        </form>
        <button type="submit">SIGN IN</button>
    </section>
</form>

</section>

<script src="..\..\pub\JavaScript\loginForm.js"></script>
<jsp:include page="../include/footer.jsp" />