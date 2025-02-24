package lindor.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import lindor.casestudy.database.dao.UserDAO;
import lindor.casestudy.database.dao.UserRoleDAO;
import lindor.casestudy.database.entity.User;
import lindor.casestudy.database.entity.UserRole;
import lindor.casestudy.formbean.RegisterFormBean;
import lindor.casestudy.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");


        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/user/registerSubmit", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

        if (bindingResult.hasErrors()) {

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " +  error.getDefaultMessage());
            }

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);

            response.setViewName("user/register");
            return response;
        }

        User user = userDao.findById(form.getId());
        if (user == null) {
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setDisplayName(form.getDisplayName());
        user.setRegion(form.getRegion());
        user.setCreateDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");

        userRoleDao.save(userRole);

        log.info(form.toString());

        response.setViewName("redirect:/index");

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setDisplayName(user.getDisplayName());
        form.setRegion(user.getRegion());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());

        response.addObject("form", form);

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/user/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "displayName", required = false) String displayName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<User> users = new ArrayList<>();

        if (!StringUtils.isEmpty(displayName)) {
            users = userDao.findByDisplayNameIgnoreCaseContaining(displayName);
        }

        response.addObject("usersModelKey", users);
        response.addObject("displayName", displayName);

        return response;
    }
}
