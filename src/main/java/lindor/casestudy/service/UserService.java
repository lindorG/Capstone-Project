package lindor.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lindor.casestudy.database.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

}
