<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
<link rel="stylesheet" href="..\..\..\pub\CSS\search.css">
<script src="..\..\..\pub\JavaScript\search.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">

<section>
<h1>Search</h1>

<br>
<form action="user/search" method="GET">
    <span><i aria-hidden="true" class="fa fa-user"></i></span><input type="text" name="displayName" value =
</form>
</section>


<section>
    <table class="table">
        <tr scope="row">
            <th>Display Name</th>
            <th>Region</th>
        </tr>
        <c:forEach items="${usermModelKey}" var="user">
        <tr scope="row">
            <td>${user.email}</td>
            <td>${user.displayName}</td>
            <td>${user.region}</td>
        </tr>
    </c:forEach>
    </table>
</section>

<jsp:include page="footer.jsp" />