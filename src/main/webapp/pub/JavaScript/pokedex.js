let navLinks = document.getElementById("navLinks");

function showMenu() {
    navLinks.style.right = "0"
}
function hideMenu() {
    navLinks.style.right = "-200px"
}

const poke_container = document.getElementById("poke_container")
const pokemon_number = 649
const colors = {
    normal: "rgba(245,245,245,0.5)",
    fire: "rgba(255,153,153,0.5)",
    water: "rgba(171,213,255,0.5)",
    grass: "rgba(199,252,172,0.5)",
    electric: "rgba(255,244,89,0.5)",
    ice: "rgba(194,252,255,0.5)",
    fighting: "rgba(207,102,81,0.5)",
    poison: "rgba(229,115,255,0.5)",
    ground: "rgba(244,231,218,0.5)",
    flying: "rgba(230,251,252,0.5)",
    psychic: "rgba(255,191,226,0.5)",
    bug: "rgba(255,185,71,0.5)",
    rock: "rgba(163,124,108,0.5)",
    ghost: "rgba(189,134,252,0.5)",
    dragon: "rgba(151,179,230,0.5)",
    dark: "rgba(94,94,94,0.5)",
    steel: "rgba(190,190,190,0.5)",
    fairy: "rgba(255,237,253,0.5)"
}

const fetchPokemon = async () => {
    for (let i = 1; i <= pokemon_number; i++) {
        await getPokemon(i)
    }
}

const mainTypes = Object.keys(colors)

const getPokemon = async id => {
    const url = `https://pokeapi.co/api/v2/pokemon/${id}`
    const res = await fetch(url)
    const pokemon = await res.json()
    createPokemonCard(pokemon)
}

fetchPokemon();

function createPokemonCard(pokemon) {
    const pokemonElement = document.createElement("div")
    pokemonElement.classList.add("pokemon")

    const pokemonTypes = pokemon.types.map(element => element.type.name)
    const typeOne = mainTypes.find(
        type => pokemonTypes.indexOf(type) > -1
    )

    const typeTwo = function () {
        let type = mainTypes.find(type => pokemonTypes.indexOf(type) > 0)

        if (type != undefined) {
            return " / " + type[0].toUpperCase() + type.slice(1)
        } else {
            return ""
        }
    }


    const name = pokemon.name[0].toUpperCase() + pokemon.name.slice(1)
    const color = colors[typeOne]

    pokemonElement.style.backgroundColor = color

    const pokeInnerHTML = `
        <div class="img-container">
            <a href="/team/teambuilder?add=${pokemon.id}" class="hero-btn"><img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/${pokemon.id}.gif"/></a>
        </div>
        <div class = "info">
            <span class="number">#${pokemon.id.toString().padStart(3, "0")}</span>
            <h3 class="name">${name}</h3>
            <small class="type">type: <span>${typeOne[0].toUpperCase() + typeOne.slice(1) + typeTwo()}</span></small>
        </div>
    `
    pokemonElement.innerHTML = pokeInnerHTML

    poke_container.appendChild(pokemonElement)
}