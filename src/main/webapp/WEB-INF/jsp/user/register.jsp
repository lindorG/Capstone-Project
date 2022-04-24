<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="..\..\..\pub\CSS\register.css">
<script src="..\..\..\pub\JavaScript\register.js"></script>
<title>Register</title>

<!-- rewrite this as a case statement using c:choose -->
<section class="titleAbove">
<c:if test="${empty form.id}">
    <div class="text-box">
    <h3>Register</h3>
    </div>
</c:if>

<c:if test="${not empty form.id}">
    <div class="text-box">
        <h3>Edit User</h3>
    </div>
</c:if>
</section>

<form action="/user/registerSubmit"   method="get">
    <input type="hidden" name="id" value="${form.id}">
    <br>
    <form id="register-form">
    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
    <input type="text" id="displayNameId" placeholder="Display Name" name="displayName" value="${form.displayName}"/>
        <c:forEach items='${bindingResult.getFieldErrors("displayName")}' var="error">
            <div style="color:red; align-items: center; align-text: center; justify-content: center; position: relative; margin:auto">${error.getDefaultMessage()}
        </c:forEach>
    </div>
    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
    <input type="email" id="emailId" placeholder="Email" name="email" value="${form.email}"/>
        <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
            <div style="color:red; align-items: center; align-text: center; justify-content: center; position: relative; margin:auto">${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
    <input type="password" id="passwordId" placeholder="Password" name="password" value="${form.password}"/>
            <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                <div style="color:red; align-items: center; align-text: center; justify-content: center; position: relative; margin:auto">${error.getDefaultMessage()}</div>
            </c:forEach>
    </div>
    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
    <input type="password" id="confirmPasswordId" placeholder="Confirm Password" name="confirmPassword" value="${form.confirmPassword}"/>
                <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                    <div style="color:red; align-items: center; align-text: center; justify-content: center; position: relative; margin:auto">${error.getDefaultMessage()}</div>
                </c:forEach>
    </div>
    <div class="input_field select_option">
    <select name="region" id="region">
    <option>Select Region</option>
    <option>Kanto</option>
    <option>Johto</option>
    <option>Hoenn</option>
    <option>Sinnoh</option>
    <option>Unova</option>
    <option>Kalos</option>
    <option>Alola</option>
    <option>Galar</option>
    </select>
    <div class="select_arrow"></div>
    </div>
    <br><br>
    <div class="input_field checkbox_option" required>
    <input type="checkbox" id="checkbox" name="checkbox">
    <label for="checkbox">I agree with terms and conditions</label>
    <br>
        <form action="/login/loginSubmit" method="POST"><input class="hero-btn" type="submit" value="Submit" id="btnsubmit"/></form>
    </div>
    </form>
</form>
</section>

<jsp:include page="../include/footer.jsp" />

