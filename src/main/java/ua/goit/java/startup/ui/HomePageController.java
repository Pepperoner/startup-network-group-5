package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

//    private final StartupService startupService;
//    private final DeveloperService developerService;
//    private final InvestorService investorService;

//    @Autowired
//    public HomePageController(StartupService startupService, DeveloperService developerService, InvestorService investorService) {
//        this.startupService = startupService;
//        this.developerService = developerService;
//        this.investorService = investorService;
//    }
//
//    @RequestMapping(
//            value = {"", "/", "index"},
//            method = RequestMethod.GET
//    )
//    public ModelAndView getHomePage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("startups", startupService.getAll());
//        modelAndView.addObject("is_investor", investorService.isAuthenticatedInvestor);
//        modelAndView.addObject("is_developer", developerService.isAuthenticatedDeveloper);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
}
