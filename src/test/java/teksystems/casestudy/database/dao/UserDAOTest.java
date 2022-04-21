package teksystems.casestudy.database.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import teksystems.casestudy.database.entity.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    void name() {
        user = new User(2, "hello@gmail.com", "Hello", "Kanto", "password", new Date());
    }


    @Test
    void findById() {
//        user = user.DAO.findById(1);
        userDAO.save(user);
        String user2 = userDAO.findByEmail(user.getEmail()).getEmail();

        assertEquals(user2,"hello@gmail.com");
    }

//    @Test
//    void findByEmail() {
//    }
//
//    @Test
//    void findByDisplayNameIgnoreCaseContaining() {
//    }
//
//    @Test
//    void findByDisplayNameAndRegion() {
//    }
}