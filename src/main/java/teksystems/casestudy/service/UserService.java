package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

}
