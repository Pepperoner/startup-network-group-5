package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Aleksandr on 26.09.2017.
 */
@Controller
@ComponentScan(basePackages = "ua.goit.java.startup.domainservise")
public class HomePageController {

//    private StartupService startupService;
//    private DeveloperService developerService;
 //   private InvestorService investorService;

//    @Autowired
//    public HomePageController(StartupService startupService, DeveloperService developerService, InvestorService investorService) {
//        this.startupService = startupService;
//        this.developerService = developerService;
//        this.investorService = investorService;
//    }
//
    @RequestMapping(
            value = {"", "/", "index"},
            method = RequestMethod.GET
    )
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView();



        //modelAndView.addObject("startups", startupService.getAll());
        //modelAndView.addObject("is_investor", investorService.isAuthenticatedInvestor);
        //modelAndView.addObject("is_developer", developerService.isAuthenticatedDeveloper);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
