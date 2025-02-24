package lindor.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import lindor.casestudy.database.dao.UserDAO;

@Slf4j
@Controller
public class ForumController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/forum", method = RequestMethod.GET)
    public ModelAndView forum() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/forum");
        return response;
    }
}