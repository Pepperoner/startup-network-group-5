package ua.goit.java.startup.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.java.startup.domainservise.StartupService;
import ua.goit.java.startup.domainservise.UserService;
import ua.goit.java.startup.dto.DtoStartup;

@Controller
public class StartupController {

    private StartupService startupService;
    private UserService userService;

//    @Autowired
//    public StartupController(StartupService startupService, UserService userService) {
//        this.startupService = startupService;
//        this.userService = userService;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<DtoStartup> getStartupById(@PathVariable("id") long id) {
//        DtoStartup dtoStartup = startupService.getDtoStartupById(id);
//        if (dtoStartup != null) {
//            return new ResponseEntity<DtoStartup>(dtoStartup, HttpStatus.OK);
//        }
//        return new ResponseEntity<DtoStartup>(HttpStatus.FORBIDDEN);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<DtoStartup> createStartup(@RequestBody DtoStartup dtoStartup) {
//        dtoStartup = startupService.createNewStartup(dtoStartup);
//        if (dtoStartup != null) {
//            return new ResponseEntity<DtoStartup>(dtoStartup, HttpStatus.OK);
//        }
//        return new ResponseEntity<DtoStartup>(HttpStatus.FORBIDDEN);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<DtoStartup> updateStartup(@RequestBody DtoStartup dtoStartup) {
//        dtoStartup = startupService.saveDtoStartup(dtoStartup);
//        if (dtoStartup != null) {
//            return new ResponseEntity<DtoStartup>(dtoStartup, HttpStatus.OK);
//        }
//        return new ResponseEntity<DtoStartup>(HttpStatus.FORBIDDEN);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public ResponseEntity<DtoStartup> deleteStartup(@PathVariable("id") long id) {
//        DtoStartup dtoStartup = startupService.deleteStartup(id);
//        if (dtoStartup!=null){
//            return new ResponseEntity<DtoStartup>(dtoStartup, HttpStatus.OK);
//        }
//        return new ResponseEntity<DtoStartup>(HttpStatus.FORBIDDEN);
//    }
}
