package ua.goit.java.startup.ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.domainservice.DeveloperService;
import ua.goit.java.startup.domainservice.InvestorService;


@Controller
public class RegisterController {

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private InvestorService investorService;


    // Return registration form template
    @RequestMapping(value = "/user_type-selector", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("developer", UserRole.DEVELOPER);
        modelAndView.addObject("investor", UserRole.INVESTOR);
        modelAndView.setViewName("_user_type-selector");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    //@ResponseBody
    public ModelAndView getRegistrationForm(ModelAndView modelAndView, UserRole userRole) {

        modelAndView.setViewName("registration");
        if (userRole.equals(UserRole.INVESTOR)) {
            modelAndView.addObject("investor", new Investor());
            modelAndView.addObject("userModel", "investor");
        } else {
            modelAndView.addObject("developer", new Developer());
            modelAndView.addObject("userModel", "developer");
        }
        modelAndView.addObject("userRole", userRole);
        return modelAndView;
    }


    @RequestMapping(value = "/registration/developer", method = RequestMethod.POST)
    public ModelAndView doDeveloperRegistration(Developer developer, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("registration");
        Developer devExist = developerService.findByEmail(developer.getEmail());

        if (devExist != null && devExist.getEmail() != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.addObject("developer", new Developer());
            modelAndView.addObject("userModel", "developer");
            result.reject("email");
            modelAndView.addObject("userRole", devExist.getRole());
        }

        if (!result.hasErrors()) {
            developer.setRole(UserRole.DEVELOPER);
            developerService.add(developer);
            modelAndView.addObject("confirmationMessage", "You has been registered successfully.");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/registration/investor", method = RequestMethod.POST)
    public ModelAndView doInvestorRegistration(Investor investor, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("registration");
        Investor invExist = investorService.findByEmail(investor.getEmail());

        if (invExist != null && invExist.getEmail() != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.addObject("investor", new Investor());
            modelAndView.addObject("userModel", "investor");
            result.reject("email");
            modelAndView.addObject("userRole", invExist.getRole());
        }

        if (!result.hasErrors()) {
            investor.setRole(UserRole.INVESTOR);
            investorService.add(investor);
            modelAndView.addObject("confirmationMessage", "You has been registered successfully.");
        }
        return modelAndView;
    }


}