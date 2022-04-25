package teksystems.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import teksystems.casestudy.database.entity.User;

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
    // 1. This stack of code tests findByEmail()
    @Order(1)
    @Test
    void findById() {
        userDAO.save(user);
        String user2 = userDAO.findByEmail(user.getEmail()).getEmail();

        assertEquals(user2,"hello@gmail.com");

        System.out.println(user2);
        System.out.println(user);
    }
    @Order(2)
    // 2. This stack of code tests findByDisplayNameIgnoreCaseContaining() and ignores the casing of the parameter
    @Test
    void findByDisplayNameIgnoreCaseContaining() {
        userDAO.save(user);
        String displayName = "hEllo";

        String credentials = String.valueOf(userDAO.findByDisplayNameIgnoreCaseContaining(displayName));

        System.out.println(displayName);
        System.out.println(credentials);
    }
    // 3. This stack of code tests findByDisplayNameIgnoreCaseContaining() and ignores the casing of the parameter
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