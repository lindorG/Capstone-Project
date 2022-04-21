package teksystems.casestudy.controller;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.*;
import teksystems.casestudy.database.entity.*;
import teksystems.casestudy.formbean.RegisterFormBean;
import teksystems.casestudy.formbean.TeamFormBean;

import java.util.ArrayList;
import java.util.List;
@Controller
public class TeamController {

    @Autowired
    private TeamDAO teamDao;

    @Autowired
    private PokemonDAO pokemonDao;

    @Autowired
    private PokemonTeamDAO pokemonTeamDao;

    @Autowired
    private UserDAO userDao;


    @RequestMapping(value = "/showTeam", method = RequestMethod.GET)
    public ModelAndView showTeam() throws Exception {
        ModelAndView response = new ModelAndView();

        return response;
    }

    @RequestMapping(value="/team/teambuilder", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "add", required = false, defaultValue = "-1") Integer id) {

        ModelAndView response = new ModelAndView();
        response.setViewName("team/teambuilder");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = ((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername();

        User user =  userDao.findByEmail(username);

        Team team = teamDao.findByUserId(user.getId());

        if (team == null) {
            team = new Team();

            team.setUserId(user.getId());

            teamDao.save(team);
        }

        List<Integer> teamIdList = pokemonTeamDao.findByTeamId(team.getId());

        if (id != -1 && teamIdList.size() < 6) {
            PokemonTeam pokemonTeam = new PokemonTeam();

            pokemonTeam.setTeam(team);
            pokemonTeam.setPokemon(pokemonDao.findById(id));

            response.setViewName("redirect:/team/teambuilder");
            // This is a duplicate entry error and it should be handled
            try {
                pokemonTeamDao.save(pokemonTeam);
            } catch(Exception e) {
                System.out.println("You cannot create a duplicate entry");
            }
        }

        System.out.println(id + " is here");

        List<Pokemon> pokemon = new ArrayList<>();

        if (!StringUtils.isEmpty(name)) {
            pokemon = pokemonDao.findByNameIgnoreCaseContaining(name);
        }

        response.addObject("pokemonModelKey", pokemon);
        response.addObject("name", name);


        pokemonTeamDao.findByTeamId(team.getId());

        System.out.println(pokemonTeamDao.findByTeamId(team.getId()));


        List<Pokemon> pokemonList = new ArrayList<>();

        for( Integer e : teamIdList ) {
            pokemonList.add(pokemonDao.findById(e));
        }

        response.addObject("myTeam", pokemonList);

        return response;
    }
}