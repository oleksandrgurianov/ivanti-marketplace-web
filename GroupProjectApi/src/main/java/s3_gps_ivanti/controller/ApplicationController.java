package s3_gps_ivanti.controller;

import org.springframework.util.StringUtils;
import s3_gps_ivanti.dto.*;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.business.CreatorService;
import s3_gps_ivanti.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3_gps_ivanti.model.Creator;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final CreatorService creatorService;

    //All
    @GetMapping("{id}")
    public ResponseEntity<ApplicationDetailedInfoDTO> getApplicationsByID(@PathVariable("id") int id) {

            ApplicationDetailedInfoDTO application = applicationService.getApplicationInfoByID(id);

            if(application != null) {
                return ResponseEntity.ok().body(application);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @GetMapping("/details/{appName}")
    public ResponseEntity<ApplicationDetailedInfoDTO> getApplicationDetails(@PathVariable("appName") String appName) {

        ApplicationDetailedInfoDTO dto = applicationService.getApplicationInfoByName(appName);

        if(dto != null) {
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<ArrayList<ApplicationBasicInfoDTO>> getAllApplications(){
        ArrayList<Application> allApplications = applicationService.getApplications();
        ArrayList<ApplicationBasicInfoDTO> dtos = new ArrayList<>();

        if (allApplications != null){
            for (Application app : allApplications){
                ApplicationBasicInfoDTO dto = new ApplicationBasicInfoDTO(app);
                dtos.add(dto);
            }
            return ResponseEntity.ok().body(dtos);
        }
        return ResponseEntity.notFound().build();
    }


    //Content Creator
    @GetMapping("creator/{id}")
    public ResponseEntity<List<ApplicationBasicInfoDTO>> getApplicationsByCreator(@PathVariable int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "sort", required = false) String sort) {
        ArrayList<Application> applications;

        if (StringUtils.hasText(name)) {
            applications = applicationService.getApplicationsByCreatorIdAndName(id, name);
        } else {
            applications = applicationService.getApplicationsByCreatorId(id);
        }

        ArrayList<ApplicationBasicInfoDTO> applicationsDTO  = new ArrayList<>();

        if (!applications.isEmpty()) {
            if (StringUtils.hasText(sort)) {
                switch (sort) {
                    case "nameDesc" -> applicationService.sortApplicationsByName(applications, false);
                    case "ratingAsc" -> applicationService.sortApplicationsByRating(applications, true);
                    case "ratingDesc" -> applicationService.sortApplicationsByRating(applications, false);
                    default -> applicationService.sortApplicationsByName(applications, true);
                }
            } else {
                applicationService.sortApplicationsByName(applications, true);
            }

            for (Application a : applications) {
                ApplicationBasicInfoDTO applicationDTO = new ApplicationBasicInfoDTO(a);
                applicationsDTO.add(applicationDTO);
            }

            return ResponseEntity.ok().body(applicationsDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("creator/{id}/statistics")
    public ResponseEntity<List<ApplicationStatisticsDTO>>getApplicationsStatistics(@PathVariable int id) {
        Creator creator = creatorService.getCreator(id);
        List<ApplicationStatisticsDTO> statisticsDTOS = applicationService.getApplicationStatisticsDTO((ArrayList<Application>) creator.getMyApplications());
        if(creator!=null){
            return ResponseEntity.ok().body(statisticsDTOS);
        }
        return ResponseEntity.notFound().build();
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
    public ResponseEntity<CreateApplicationResponseDTO> createApplications(@RequestBody CreateApplicationRequestDTO app) {

        CreateApplicationResponseDTO responseDTO = applicationService.createApplications(app);

        if(responseDTO == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        else {
            String url = "application/" + responseDTO.getId();
            URI uri = URI.create(url);
            return ResponseEntity.created(uri).build();
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

    @DeleteMapping({"{name}"})
    public ResponseEntity<Object> deleteApplications(@PathVariable("name") String name) {

        if (applicationService.deleteApplications(name)) {
            return ResponseEntity.ok().build();
        } else {
               return ResponseEntity.notFound().build();
        }
    }


    //Customer
    @GetMapping("download/{id}")
    public ResponseEntity<File> downloadApplications(@PathVariable("id") int id) {

        File app = applicationService.downloadApplications(id);

        if (app != null) {
            return ResponseEntity.ok().body(app);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<ArrayList<Application>>getApplicationsByCustomer(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
