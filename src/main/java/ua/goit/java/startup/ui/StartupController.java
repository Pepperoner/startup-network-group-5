package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.domainservice.StartupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@Controller
public class StartupController {

    @Autowired
    private StartupService startupService;

    @RequestMapping(value = "/add-startup", method = RequestMethod.GET)
    public ModelAndView createStartup() {
        return new ModelAndView("add-startup", "startup", new Startup());
    }


    /* @RequestMapping(value = "/add-startup", method = RequestMethod.POST)
     public String createStartup(Startup startup, BindingResult result) {

         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         Object user = auth.getPrincipal();

         if (user instanceof Developer) {
             Set<Developer> set = new HashSet<>();
             set.add((Developer) user);
             startup.setDeveloper(set);
         }
         startupService.add(startup);

         return "redirect:/index";
     }*/
    @RequestMapping(value = "/add-startup", method = RequestMethod.POST)
    public String createStartup(@ModelAttribute("startup") Startup startup, BindingResult result,
                                @RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("add-startup");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Developer) {
            Set<Developer> set = new HashSet<>();
            set.add((Developer) user);
            startup.setDeveloper(set);
        }
        //modelAndView.addObject("startup", new Startup());
        //modelAndView.addObject("startupModel", "startup");
        try {
            startup.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        startupService.add(startup);
        //return modelAndView;
        return "redirect:/developer/cabinet";
    }

    @RequestMapping(value = "/startup/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Startup startup = startupService.get(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(startup.getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/startup/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editStartup(@PathVariable(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("startup", startupService.get(id));
        modelAndView.setViewName("edit_startup");
        return modelAndView;
    }

    @RequestMapping(value = "/startup/update/{id}", method = RequestMethod.POST)
    public String updateStartup(
            @ModelAttribute("startup") Startup startup, BindingResult result,
            @RequestParam("file") MultipartFile file
    ) {

        Startup startupToUpdate = startupService.get(startup.getId());
        startupToUpdate.setName(startup.getName());
        startupToUpdate.setDescription(startup.getDescription());
        startupToUpdate.setCost(startup.getCost());
        if (!file.isEmpty()) {
            try {
                startupToUpdate.setImage(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Startup startupFromDb = startupService.update(startupToUpdate);
        ModelAndView modelAndView = new ModelAndView("edit_startup");
        modelAndView.addObject("startup", startupFromDb);
        return "redirect:/developer/cabinet";
    }

    @RequestMapping(value = "/startup/delete/{id}", method = RequestMethod.GET)
    public String deleteStartup(@PathVariable(name = "id") long id) {
        startupService.remove(id);
        return "redirect:/index";
    }
}
