package lindor.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import lindor.casestudy.database.entity.Pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PokemonDAOTest {

    @Autowired
    private PokemonDAO pokemonDAO;

    Pokemon pokemon;

    @BeforeEach
    void createPokemon() {
        pokemon = new Pokemon(1, "bulbasaur", 7, 69, 64);
        pokemon = new Pokemon(4, "charmander", 7, 85, 62);
        pokemon = new Pokemon(7, "squirtle", 5, 90, 63);
        pokemon = new Pokemon(25, "pikachu", 4, 60, 112);
    }

    // 1. This stack of code tests findByNameIgnoreCaseContaining() which searches for a Pokémon by the parameter "name"
    @Order(1)
    @Test
    void findByNameIgnoreCaseContaining() {
        pokemonDAO.save(pokemon);
        String name = "pIKaCHu";

        String pokemon25 = String.valueOf(pokemonDAO.findByNameIgnoreCaseContaining(name));

        System.out.println(name);
        System.out.println(pokemon25);
    }

    // 1. This stack of code tests findAll() which searches for all Pokémon and returns a list
    @Order(2)
    @Test
    void findAllById() {
        for (int i = 0; i < 50; i++) {
            System.out.println(pokemonDAO.findAllById(i));
        }
    }
}
