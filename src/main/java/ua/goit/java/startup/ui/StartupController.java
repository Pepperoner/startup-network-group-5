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
    public ModelAndView createStartup(@ModelAttribute("startup") Startup startup, BindingResult result,
                                      @RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("add-startup");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        if (user instanceof Developer) {
            Set<Developer> set = new HashSet<>();
            set.add((Developer) user);
            startup.setDeveloper(set);
        }
        modelAndView.addObject("startup", new Startup());
        modelAndView.addObject("startupModel", "startup");
        try {
            startup.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        startupService.add(startup);
        return modelAndView;
    }

    @RequestMapping(value = "/startup/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        Startup startup = startupService.get(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(startup.getImage());
        response.getOutputStream().close();
    }


//
//    private final StartupService startupService;
//    private final UserService userService;
//
//    @Autowired
//    public StartupController(StartupService startupService, UserService userService) {
//        this.startupService = startupService;
//        this.userService = userService;
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Startup> getStartupById(@PathVariable("id") long id) {
//        Startup startup = startupService.getStartupById(id);
//        if (startup != null) {
//            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
//        }
//        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Startup> createStartup(@RequestBody Startup startup) {
//        startup = startupService.createNewStartup(startup);
//        if (startup != null) {
//            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
//        }
//        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<Startup> updateStartup(@RequestBody Startup startup) {
//        startup = startupService.saveStartup(startup);
//        if (startup != null) {
//            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
//        }
//        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public ResponseEntity<Startup> deleteStartup(@PathVariable("id") long id) {
//        Startup startup = startupService.deleteStartup(id);
//        if (startup != null) {
//            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
//        }
//        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
//    }
//
//    /////////////////////////////////////////////////////
//    @RequestMapping(value = "/startup/list", method = RequestMethod.GET)
//    public ModelAndView getStartupById() {
//        ModelAndView model = new ModelAndView("startup");
//        model.setViewName("startup/list");
//        model.addObject("startup", userService.getAll());
//        return model;
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String createStartup (@ModelAttribute Startup startup){
//        if (startup!= null){
//           Startup startup = userService.createStartup(startup);
//        }
//        return "redirect:startup/list";
//    }
//
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public String updateStartup(@ModelAttribute Startup startup) {
//        Startup startup = userService.updateStartup(startup);
//        return "redirect:startup/list";
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public String deleteStrtup(@RequestParam String id) {
//        Startup startup = userService.deleteStartup(id);
//        return "redirect:startup/list";
//    }

}
