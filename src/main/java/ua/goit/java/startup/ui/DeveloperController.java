package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.domainservice.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
A class for the Developer page, with methods for inside management
 */
@Controller
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(final DeveloperService developerService) {
        this.developerService = developerService;
    }

    @RequestMapping(value = "/developer/cabinet", method = RequestMethod.GET)
    public ModelAndView viewCabinet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        ModelAndView modelAndView = new ModelAndView("index");
        if (user instanceof Developer) {
            modelAndView.addObject("developer", developerService.get(((Developer) user).getId()));
            modelAndView.setViewName("/user/developer_cabinet");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/developer/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Long id, HttpServletResponse response)
            throws ServletException, IOException {
        Developer developer = developerService.get(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(developer.getImage());
        response.getOutputStream().close();
    }
}