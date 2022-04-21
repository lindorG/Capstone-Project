let navLinks = document.getElementById("navLinks");

function showMenu() {
    navLinks.style.right = "0"
}
function hideMenu() {
    navLinks.style.right = "-200px"
}

function App() {
    const [pokemonName, setPokemon] = useState("")

    const searchPokemon = () => {
        Axios.get(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`).then((response)=> {
            console.log(response)
        })
    }
    return (
        <div className="App">
            <div className="TitleSection"></div>
            <h1>Pokemon Stats</h1>
            <input
                type="text"
                onChange={(event) => {
                    setPokemonName(event.target.value)
                }}
            />
            <button onClick={searchPokemon}>Search Pokemon</button>
        </div>
    )
}

export default App;
