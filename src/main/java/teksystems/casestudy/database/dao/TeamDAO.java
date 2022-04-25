package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import teksystems.casestudy.database.entity.Team;
import teksystems.casestudy.database.entity.User;

import java.util.List;

@Repository
public interface TeamDAO extends JpaRepository<Team, Long> {

    List<Team> findById(@Param("id") Integer id);

    @Query(value = "select * from teams where user_id = :user_id", nativeQuery = true)
    Team findByUserId(@Param("user_id") Integer user_id);

    void deleteTeamByUserId(@Param("user_id") Integer user_id);
}