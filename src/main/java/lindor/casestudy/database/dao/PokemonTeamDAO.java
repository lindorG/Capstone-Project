package lindor.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import lindor.casestudy.database.entity.PokemonTeam;

import java.util.List;

@Repository
public interface PokemonTeamDAO extends JpaRepository<PokemonTeam, Long> {

    PokemonTeam findById(@Param("id") Integer id);

    @Query(value = "select pok_id from pokemon_teams where team_id = :team_id", nativeQuery = true)
    List<Integer> findByTeamId(@Param("team_id") Integer team_id);

//    @Query(value = "delete from pokemon_teams where pok_id = :pok_id and team_id = :team_id")
    void deletePokemonTeamByPokemonIdAndTeamId(@Param("pok_id") Integer pok_id, @Param("team_id") Integer team_id);
}