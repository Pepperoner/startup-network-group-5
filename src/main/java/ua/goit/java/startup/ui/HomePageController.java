package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.domainservice.StartupService;

/**
 * Created by Aleksandr on 26.09.2017.
 */
@Controller
@ComponentScan(basePackages = "ua.goit.java.startup.domainservice")
public class HomePageController {

    @Autowired
    private StartupService startupService;
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
        modelAndView.addObject("startups", startupService.getAll());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if(user instanceof Investor || user instanceof Developer){
            modelAndView.addObject("user", user);
        }

        //modelAndView.addObject("startups", startupService.getAll());
        //modelAndView.addObject("is_investor", investorService.isAuthenticatedInvestor);
        //modelAndView.addObject("is_developer", developerService.isAuthenticatedDeveloper);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
