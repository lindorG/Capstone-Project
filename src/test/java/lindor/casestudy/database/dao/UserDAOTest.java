package lindor.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import lindor.casestudy.database.entity.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    User user;

    @BeforeEach
    void createUser() {
        user = new User(2, "hello@gmail.com", "Hello", "Kanto", "password", new Date());
    }

    // 1. This stack of code tests findByEmail() which searches for a user by the parameter "email"
    @Order(1)
    @Test
    void findByEmail() {
        userDAO.save(user);
        String user2 = userDAO.findByEmail(user.getEmail()).getEmail();

        assertEquals(user2,"hello@gmail.com");

        System.out.println(user2);
        System.out.println(user);
    }
    @Order(2)
    // 2. This stack of code tests findByDisplayNameIgnoreCaseContaining() which searches for a user by the parameter "displayName" and ignores casing
    @Test
    void findByDisplayNameIgnoreCaseContaining() {
        userDAO.save(user);
        String displayName = "hEllo";

        String credentials = String.valueOf(userDAO.findByDisplayNameIgnoreCaseContaining(displayName));

        System.out.println(displayName);
        System.out.println(credentials);
    }
    // 3. This stack of code tests findByDisplayNameIgnoreCaseContaining() which searches for a user by the parameters "displayName", "region", and ignores casing
    @Order(3)
    @Test
    void findByDisplayNameIgnoreCaseAndRegionIgnoreCase() {
        userDAO.save(user);
        String displayName = "hEllo";
        String region = "kaNto";

        String displayNameAndRegion = String.valueOf(userDAO.findByDisplayNameIgnoreCaseAndRegionIgnoreCase(displayName, region));

        System.out.println(displayName);
        System.out.println(region);
        System.out.println(displayNameAndRegion);
    }
}