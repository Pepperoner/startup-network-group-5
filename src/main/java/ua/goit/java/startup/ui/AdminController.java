package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.domainservice.AdminService;
import ua.goit.java.startup.domainservice.DeveloperService;
import ua.goit.java.startup.domainservice.InvestorService;
/*
A class for the Admin page, with methods for inside management
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private InvestorService investorService;

    @RequestMapping(value = "/admin/cabinet", method = RequestMethod.GET)
    public ModelAndView viewCabinet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        ModelAndView modelAndView = new ModelAndView("index");
        if (user instanceof Admin) {
            modelAndView.addObject("admin", adminService.get(((Admin) user).getId()));
            modelAndView.addObject("investors", investorService.getAll());
            modelAndView.addObject("developers", developerService.getAll());
            modelAndView.setViewName("/user/admin_cabinet");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete/investor", method = RequestMethod.POST)
    public String deleteInvestor(@RequestParam(name = "id") long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Admin) {
            investorService.remove(id);
        }
        return "redirect:/admin/cabinet";
    }

    @RequestMapping(value = "/admin/delete/developer/", method = RequestMethod.POST)
    public String deleteDeveloper(@RequestParam(name = "id") long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Admin) {
            developerService.remove(id);
        }
        return "redirect:/admin/cabinet";
    }
}