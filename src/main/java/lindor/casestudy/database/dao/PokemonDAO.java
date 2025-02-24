package lindor.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import lindor.casestudy.database.entity.Pokemon;

import java.util.List;

@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Long> {

    Pokemon findById(@Param("id") Integer id);

    List<Pokemon> findByNameIgnoreCaseContaining(@Param("name") String name);

    List<Pokemon> findAllById(@Param("id") Integer id);
}