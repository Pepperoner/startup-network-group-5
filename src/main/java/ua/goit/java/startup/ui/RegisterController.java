package ua.goit.java.startup.ui;




import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.User;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.domainservise.DeveloperService;
import ua.goit.java.startup.domainservise.InvestorService;
import ua.goit.java.startup.domainservise.UserService;


@Controller
public class RegisterController {


    @Autowired
    private UserService userService;
    @Autowired
    private DeveloperService developerService;

    @Autowired
    private InvestorService investorService;


    // Return registration form template
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, UserRole userRole){
        modelAndView.addObject("user", userRole);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @RequestMapping(value = "/registration-form", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView ajaxTest(@RequestParam(value = "userType") int userRole) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userRole", UserRole.values()[userRole]);
        modelAndView.setViewName("_registration-form");
        return modelAndView;

    }


    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, User user) {

        System.out.println("User: " + user);
        userService.add(user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, Developer developer) {

        System.out.println("User: " + developer);
        developerService.add(developer);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, Investor investor) {

        System.out.println("User: " + investor);
        investorService.add(investor);
        modelAndView.setViewName("index");
        return modelAndView;
    }





}