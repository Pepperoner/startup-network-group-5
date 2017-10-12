package ua.goit.java.startup.ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.domainservice.InvestorService;
import ua.goit.java.startup.domainservice.StartupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class InvestorController {

    @Autowired
    private InvestorService investorService;
    @Autowired
    private StartupService startupService;

    @RequestMapping(value = "/investor/cabinet", method = RequestMethod.GET)
    public ModelAndView viewCabinet() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        ModelAndView modelAndView = new ModelAndView("index");
        if (((Developer) user).getRole().equals(UserRole.INVESTOR)) {
            modelAndView.addObject("investor", user);
            modelAndView.setViewName("/user/investor_cabinet");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/investor/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Investor investor = investorService.get(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(investor.getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "startup/invest/{id}", method = RequestMethod.GET)
    public ModelAndView investPage(@PathVariable(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("startup", startupService.get(id));
        modelAndView.setViewName("invest_startup");
        return modelAndView;
    }

    @RequestMapping(value = "startup/invest/{id}", method = RequestMethod.POST)
    public String investMoney(@ModelAttribute("startup") Startup startup) {
        Startup startupToInvest = startupService.get(startup.getId());
        startupToInvest.setCurrentsum(startup.getCurrentsum() + startupToInvest.getCurrentsum());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Investor) {
            Set<Investor> set = new HashSet<>();
            set.add((Investor) user);
            startup.setInvestor(set);
        }
        Startup startupFromDb = startupService.update(startupToInvest);
        ModelAndView modelAndView = new ModelAndView("invest_startup");
        modelAndView.addObject("startup", startupFromDb);
        return "redirect:/index";
    }
}
