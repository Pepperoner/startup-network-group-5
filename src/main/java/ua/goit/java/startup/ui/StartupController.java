package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import ua.goit.java.startup.domainservise.StartupService;
//import ua.goit.java.startup.domainservise.UserService;
//import ua.goit.java.startup.dto.DtoStartup;


//@Controller
//@RequestMapping("/startup")
//public class StartupController {
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

    ///////////////////////////////////////////////////////
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
//            userService.createStartup(startup);
//        }
//        return "redirect:startup/list";
//    }
//
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public String updateStartup(@ModelAttribute Startup startup) {
//        userService.updateStartup(startup);
//        return "redirect:startup/list";
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public String deleteStrtup(@RequestParam String id) {
//        userService.deleteStartup(id);
//        return "redirect:startup/list";
//    }

//}
