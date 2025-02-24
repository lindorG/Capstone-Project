<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" href="..\..\..\pub\CSS\search.css">
<script src="..\..\..\pub\JavaScript\search.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">

<section class="search">
<h1>Search</h1>
    <p>As an administrator, you may search any user by display name</p>

<br>
<form action="/user/search" method="GET">
    <div class="wrap">
        <div class="searchBar">
            <span><i aria-hidden="true" class="fa fa-user"></i></span>
            <input type="text" name="displayName" placeholder="Enter Display Name" value="${displayName}">
            <button type="submit" class="searchButton">
                <i class="fa fa-search" style="height: 1px"></i>
            </button>
        </div>
    </div>
</form>

<br>

<c:if test="${not empty displayName}">
    <h5>Search Results: "Found ${usersModelKey.size()}"</h5>
    <br>
</c:if>


<table class="table">
    <tr scope="row" style="background-color: #ffffff">
        <th>Email</th>
        <th>Display Name</th>
        <th>Region</th>
        <th></th>
    </tr>
    <c:forEach items="${usersModelKey}" var="user">
        <tr scope="row" style="color: white">
            <td>${user.email}</td>
            <td>${user.displayName}</td>
            <td>${user.region}</td>
            <td><a href="/user/edit/${user.id}" class="hero-btn">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</section>

<jsp:include page="../include/footer.jsp" />