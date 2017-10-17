package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.domainservice.DeveloperService;
import ua.goit.java.startup.domainservice.InvestorService;

import java.io.IOException;

/*
A class for (Developer/Investor) registration management
 */
@Controller
public class RegisterController {

    private final DeveloperService developerService;
    private final InvestorService investorService;

    @Autowired
    public RegisterController(final DeveloperService developerService, final InvestorService investorService) {
        this.developerService = developerService;
        this.investorService = investorService;
    }

    @RequestMapping(value = "/user_type-selector", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("developer", UserRole.DEVELOPER);
        modelAndView.addObject("investor", UserRole.INVESTOR);
        modelAndView.setViewName("_user_type-selector");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
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
    public ModelAndView doDeveloperRegistration(@ModelAttribute("developer") Developer developer, BindingResult result,
                                                @RequestParam("file") MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView("registration");
        Developer devExist = developerService.findByEmail(developer.getEmail());
        if (devExist != null && devExist.getEmail() != null) {
            modelAndView.addObject("alreadyRegisteredMessage",
                    "Oops!  There is already a user registered with the email provided.");
            modelAndView.addObject("developer", new Developer());
            modelAndView.addObject("userModel", "developer");
            result.reject("email");
            modelAndView.addObject("userRole", devExist.getRole());
        }
        if (!result.hasErrors()) {
            developer.setRole(UserRole.DEVELOPER);
            if (!file.isEmpty()) {
                try {
                    developer.setImage(file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            developerService.add(developer);
            modelAndView.addObject("confirmationMessage",
                    "You has been registered successfully.");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/registration/investor", method = RequestMethod.POST)
    public ModelAndView doInvestorRegistration(@ModelAttribute("investor") Investor investor, BindingResult result,
                                               @RequestParam("file") MultipartFile file) {
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
            if (!file.isEmpty()) {
                try {
                    investor.setImage(file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            investorService.add(investor);
            modelAndView.addObject("confirmationMessage",
                    "You has been registered successfully.");
        }
        return modelAndView;
    }
}