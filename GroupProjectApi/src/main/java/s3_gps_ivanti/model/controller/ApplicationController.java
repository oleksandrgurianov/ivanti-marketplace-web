package s3_gps_ivanti.model.controller;

import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")/*@CrossOrigin(origins = "http://localhost:3000/")*/

public class ApplicationController {

    private final ApplicationService applicationService;

    //All
    @GetMapping("/filter/{rating}/{date}")
    public ResponseEntity<ArrayList<Application>> getApplicationsSorted(@PathVariable("rating") boolean rating, @PathVariable("date") boolean date ) {

        ArrayList<Application> applications = applicationService.getApplicationsSorted(rating, date);

        if(applications != null) {
            return ResponseEntity.ok().body(applications);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("search/{search}")
    public ResponseEntity<ArrayList<Application>> getApplicationsBySearch(@PathVariable("search") String search) {

        ArrayList<Application> applications = applicationService.getApplicationsBySearch(search);

        if(applications != null) {
            return ResponseEntity.ok().body(applications);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Application> getApplicationsByID(@PathVariable("id") String id) {

            Application application = applicationService.getApplicationsByID(id);

            if(application != null) {
                return ResponseEntity.ok().body(application);
            } else {
                return ResponseEntity.notFound().build();
            }
    }
    @GetMapping("/details/{appName}")
    public ResponseEntity<Application> getApplicationDetails(@PathVariable("appName") String appName) {

        Application application = applicationService.getApplicationsByID(appName);

        if(application != null) {
            return ResponseEntity.ok().body(application);
        }
        return ResponseEntity.notFound().build();
    }

    //Creator
    @GetMapping("creator/{ID}")
    public ResponseEntity<ArrayList<Application>>getApplicationsByCreator(@PathVariable String ID) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/creator/appToUpdate/{appName}")
    public ResponseEntity<UpdateApplicationDTO>getApplicationToUpdate(@PathVariable("appName") String appName) {
        UpdateApplicationDTO application = applicationService.getApplicationToUpdate(appName);

        if(application != null) {
            return ResponseEntity.ok().body(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<AddApplicationDTO> createApplications(@RequestBody AddApplicationDTO app) {
        if(applicationService.createApplications(app)) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PutMapping()
    public ResponseEntity<Object> updateApplications(@RequestBody UpdateApplicationDTO app) {

        if (applicationService.updateApplications(app)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping({"{appID}"})
    public ResponseEntity<Object> deleteApplications(@PathVariable("appID") String appID) {

        if (applicationService.deleteApplications(appID)) {
            return ResponseEntity.ok().build();
        } else {
               return ResponseEntity.notFound().build();
        }
    }


    //Customer
    @GetMapping("download/{appID}")
    public ResponseEntity<File> downloadApplications(@PathVariable("appID") String appID) {

        File app = applicationService.downloadApplications(appID);

        if (app != null) {
            return ResponseEntity.ok().body(app);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("customer/{ID}")
    public ResponseEntity<ArrayList<Application>>getApplicationsByCustomer(@PathVariable String ID) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
