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
import ua.goit.java.startup.ui.form.InvestorStartupForm;

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
        if (user instanceof Investor) {
        //if (((Developer) user).getRole().equals(UserRole.INVESTOR)) {
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

    ///WORK without primary in DeveloperService
    @RequestMapping(value = "startup/invest/{id}", method = RequestMethod.GET)
    public ModelAndView investPage(@PathVariable(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        InvestorStartupForm investorStartupForm = new InvestorStartupForm();
        investorStartupForm.setStartup(startupService.get(id));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Investor) {
            investorStartupForm.setInvestor((Investor) user);
        }
        modelAndView.addObject("investorStartupForm", investorStartupForm);
        modelAndView.setViewName("invest_startup");
        return modelAndView;
    }

    ///WORK without primary in DeveloperService
    @RequestMapping(value = "startup/invest/{id}", method = RequestMethod.POST)
    public String investMoney(@ModelAttribute("investorStartupForm") InvestorStartupForm investorStartupForm,
                              @PathVariable(name = "id") long startupId) {

        Startup startupToInvest = startupService.get(startupId);
        startupToInvest.addMoneyToStartup(investorStartupForm.getPaidCost());
        Investor investorToInvest = investorService.get(investorStartupForm.getInvestor().getId());
        investorToInvest.addMoneyToInvestor(investorStartupForm.getPaidCost());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Investor) {
            startupToInvest.getInvestor().add((Investor) user);
            Investor investorFromDb = investorService.update(investorToInvest);
        }
        Startup startupFromDb = startupService.update(startupToInvest);

        return "redirect:/index";
    }

}
