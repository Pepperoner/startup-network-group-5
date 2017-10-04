package ua.goit.java.startup.ui;


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
import ua.goit.java.startup.domainservice.DeveloperService;
import ua.goit.java.startup.domainservice.InvestorService;
import ua.goit.java.startup.domainservice.UserService;


@Controller
public class RegisterController {

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private InvestorService investorService;


    // Return registration form template
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("developer", UserRole.DEVELOPER);
        modelAndView.addObject("investor", UserRole.INVESTOR);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @RequestMapping(value = "/registration-form", method = RequestMethod.POST)
    //@ResponseBody
    public ModelAndView getRegistrationForm(UserRole userRole) {

        ModelAndView modelAndView;

        if (userRole.equals(UserRole.INVESTOR)) {
            modelAndView = new ModelAndView("_registration-form", "investor", new Investor());
            modelAndView.addObject("userModel", "investor");
        } else {
            modelAndView = new ModelAndView("_registration-form", "developer", new Developer());
            modelAndView.addObject("userModel", "developer");
        }
        modelAndView.addObject("userRole", userRole);
        return modelAndView;
    }


    @RequestMapping(value = "/register/developer", method = RequestMethod.POST)
    public String doDeveloperRegistration(Developer developer, BindingResult result) {
        developer.setRole(UserRole.DEVELOPER);
        developerService.add(developer);
        return "redirect:/index";
    }

    @RequestMapping(value = "/register/investor", method = RequestMethod.POST)
    public String doInvestorRegistration(Investor investor, BindingResult result) {
        investor.setRole(UserRole.INVESTOR);
        investorService.add(investor);
        return "redirect:/index";
    }


}