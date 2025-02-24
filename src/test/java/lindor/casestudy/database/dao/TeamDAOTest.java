package lindor.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import lindor.casestudy.database.entity.Team;

import java.util.Date;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeamDAOTest {

    @Autowired
    private TeamDAO teamDAO;

    Team team;

    @BeforeEach
    void createTeam() {
        team = new Team(1, 2, new Date());
    }

    // 1. This stack of code tests findById() which searches for a team by the parameter "id"
    @Order(1)
    @Test
    void findById() {
        teamDAO.save(team);
        String team2 = String.valueOf(teamDAO.findById(team.getId()));

        System.out.println(team2);
    }
    // 2. This stack of code tests findByUserId() which searches for a team by the parameter "userId"
    @Order(2)
    @Test
    void findByUserId() {
        teamDAO.save(team);
        Integer team2 = teamDAO.findByUserId(team.getUserId()).getUserId();

        System.out.println(team2);
    }
    // 3. This stack of code tests deleteTeamByUserId() which deletes a team by the parameter "teamId"
    @Order(3)
    @Test
    void deleteTeamByUserId() {
        teamDAO.save(team);
        Integer team2 = teamDAO.findByUserId(team.getUserId()).getUserId();

        System.out.println(teamDAO.findByUserId(team.getUserId()));

        teamDAO.deleteTeamByUserId(team2);

        System.out.println(teamDAO.findByUserId(team.getUserId()));
    }
}
