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
public class AboutController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/about");
        return response;
    }
}