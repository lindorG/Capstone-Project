package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.PokemonTeam;

import java.util.List;

@Repository
public interface PokemonTeamDAO extends JpaRepository<PokemonTeam, Long> {

    PokemonTeam findById(@Param("id") Integer id);

    @Query(value = "select pok_id from pokemon_teams where team_id = :team_id", nativeQuery = true)
        // this JPA Query is hibernate, JQL, or a HQL query
        // @Query("select u from users u where u.email = :email")
    List<Integer> findByTeamId(@Param("team_id") Integer team_id);

    Integer deletePokemonTeamByPokemonId(@Param("pok_id") Integer pok_id);
}