<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<link rel="stylesheet" href="..\..\..\pub\CSS\teambuilder.css">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<title></title>

<section class="teamBuilder">
    <c:if test="${empty form.id}">
        <div class="text-box">
            <h1>My Team</h1>
        </div>
    </c:if>

    <table class="table">
        <tr scope="row" clas="row" style="color: white">
            <th style="background-color: rgba(255,255,255,0.16)"></th>
            <th style="background-color: rgba(255,255,255,0.16)"></th>
            <th style="background-color: rgba(255,255,255,0.16)"></th>
            <th style="background-color: rgba(255,255,255,0.16)"></th>
            <th style="background-color: rgba(255,255,255,0.16)">Name</th>
            <th style="background-color: rgba(255,255,255,0.16)">Height</th>
            <th style="background-color: rgba(255,255,255,0.16)">Weight</th>
            <th style="background-color: rgba(255,255,255,0.16)"></th>
        </tr>
        <c:forEach items="${myTeam}" var="pokemon">
            <tr scope="row" style="color: #ffffff">
                <td></td>
                <td></td>
                <td></td>
                <td><img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/${pokemon.id}.gif"/></td>
                <td>${pokemon.name.toUpperCase()}</td>
                <td>${pokemon.pokHeight*10} cm</td>
                <td>${Math.round(pokemon.pokWeight*0.1)} kg</td>
                <td><a href="/team/delete?delete=${pokemon.id}" class="team-btn"><i class="fa-solid fa-trash-can"></i></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</section>


<section class="search">
    <c:if test="${empty form.id}">
        <div class="text-box">
            <h1 style="opacity: 0.65; font-size: 50px;">Search Pok&#233;mon</h1>
        </div>
    </c:if>

    <c:if test="${not empty name}">
        <h5>"${pokemonModelKey.size()}" Pok&#233;mon Found</h5>
        <br>
    </c:if>

    <c:if test="${empty name}">
        <br>
    </c:if>

    <form action="/team/teambuilder" method="GET" class="searchToAdd">
        <i class="fa-solid fa-dragon"></i>
        <input type="text" name="name" class="textInput" placeholder="Enter Name" value="${name}">
        <button type="submit" class="button1 bouncy">&nbsp;Search&nbsp;</button>
    </form>

    <table class="table">
        <tr scope="row" style="color: white; background-color: black">
            <th></th>
            <th>Name</th>
            <th>Height</th>
            <th>Weight</th>
            <th></th>
        </tr>
        <c:forEach items="${pokemonModelKey}" var="pokemon">
            <tr scope="row">
                <td><img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/${pokemon.id}.png"/></td>
                <td>${pokemon.name.toUpperCase()}</td>
                <td>${pokemon.pokHeight*10} cm</td>
                <td>${Math.round(pokemon.pokWeight*0.1)} kg</td>
                <td><a href="/team/teambuilder?add=${pokemon.id}" class="hero-btn">Add</a></td>
            </tr>
        </c:forEach>
    </table>
    </section>

<script src="..\..\..\pub\JavaScript\teambuilder.js"></script>

<jsp:include page="../include/footer.jsp" />