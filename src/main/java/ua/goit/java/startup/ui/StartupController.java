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

    private final StartupService startupService;
    private final UserService userService;

    @Autowired
    public StartupController(StartupService startupService, UserService userService) {
        this.startupService = startupService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Startup> getStartupById(@PathVariable("id") long id) {
        Startup startup = startupService.getStartupById(id);
        if (startup != null) {
            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
        }
        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Startup> createStartup(@RequestBody Startup startup) {
        startup = startupService.createNewStartup(startup);
        if (startup != null) {
            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
        }
        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Startup> updateStartup(@RequestBody Startup startup) {
        startup = startupService.saveStartup(startup);
        if (startup != null) {
            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
        }
        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Startup> deleteStartup(@PathVariable("id") long id) {
        Startup startup = startupService.deleteStartup(id);
        if (startup!=null){
            return new ResponseEntity<Startup>(startup, HttpStatus.OK);
        }
        return new ResponseEntity<Startup>(HttpStatus.FORBIDDEN);
    }
}
