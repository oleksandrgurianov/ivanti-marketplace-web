package S3_GPS_Ivanti.controller;

import S3_GPS_Ivanti.business.ApplicationService;
import S3_GPS_Ivanti.business.UserService;
import S3_GPS_Ivanti.model.Application;
import S3_GPS_Ivanti.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final UserService userService;

    @GetMapping("/filter/{rating}/{date}")
    public ResponseEntity<ArrayList<Application>> getApplicationsSorted(@PathVariable("rating") boolean rating,@PathVariable("date") boolean date , @RequestBody String username, String password) {
        User user = userService.getUser(username, password);

        if(user != null) {
            ArrayList<Application> applications = applicationService.getApplicationsSorted(rating, date);

            if(applications != null) {
                return ResponseEntity.ok().body(applications);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("search/{search}")
    public ResponseEntity<ArrayList<Application>> getApplicationsBySearch(@PathVariable("search") String search, @RequestBody String username,  String password) {
        User user = userService.getUser(username, password);

        if(user != null) {
            ArrayList<Application> applications = applicationService.getApplicationsBySearch(search);

            if(applications != null) {
                return ResponseEntity.ok().body(applications);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{id}")
    public ResponseEntity<Application> getApplicationsBySearch(@PathVariable("id") long id) {

            Application application = applicationService.getApplicationsByID(id);

            if(application != null) {
                return ResponseEntity.ok().body(application);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @GetMapping()
    public ResponseEntity<ArrayList<Application>>getApplications(@RequestBody String username, String password) {
        User user = userService.getUser(username, password);

        if(user != null) {
            ArrayList<Application> applications = applicationService.getApplications();

            if(applications != null) {
                return ResponseEntity.ok().body(applications);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @PostMapping()
    public ResponseEntity createApplications(@RequestBody String username, String password,  Application app) {
        User user = userService.getUser(username, password);

        if(user != null) {
            if(applicationService.createApplications(app)) {
                return ResponseEntity.ok().build();
            }
            else {
                return new ResponseEntity("Error", HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @PutMapping()
    public ResponseEntity updateApplications(@RequestBody String username, @RequestBody String password, @RequestBody Application app) {
        User user = userService.getUser(username, password);

        if(user != null) {
            if (applicationService.updateApplications(app, user)) {
                return ResponseEntity.noContent().build();
            }
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping({"appID"})
    public ResponseEntity deleteApplications(@PathVariable("appID") int appID, @RequestBody  String username, @RequestBody String password) {
        User user = userService.getUser(username, password);

        if(user != null) {
            boolean result = applicationService.deleteApplications(appID, user);

            if (result == true) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("download/{appID}")
    public ResponseEntity<File> downloadApplications(@PathVariable("appID") int appID, @RequestBody  String username, @RequestBody String password) {

        User user = userService.getUser(username, password);

        if(user != null) {
            File App = applicationService.downloadApplications(username, password, appID);

           if (App != null) {
               return ResponseEntity.ok().body(App);
           } else {
               return ResponseEntity.notFound().build();
          }
        }
        return new ResponseEntity("Please make sure your username and password are correct", HttpStatus.BAD_REQUEST);
    }
}
