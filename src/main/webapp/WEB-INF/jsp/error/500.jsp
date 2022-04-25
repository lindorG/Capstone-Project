<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" href="..\..\..\pub\CSS\500.css">

<a href="/index">
    <img src="..\..\..\pub\images\500.png" class="nothing"></img>
</a>

<section class="error">
<h1 style="text-align: center">Error Page</h1>

<c:if test="${not empty requestUrl}">
    <p style="text-align: center">${requestUrl}</p>
</c:if>
<h3>Stack Trace</h3>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<c:if test="${not empty stackTrace}">
    <p>${stackTrace}</p>
</c:if>
<h3>Root Cause</h3>
<c:if test="${not empty rootcause}">
    <p>${rootcause}</p>
</c:if>
<c:if test="${not empty rootTrace}">
    <p>${roottrace}</p>
</c:if>
</section>
<br><br>
</section>

<script src="..\..\pub\JavaScript\500.js"></script>
<jsp:include page="../include/footer.jsp" />
