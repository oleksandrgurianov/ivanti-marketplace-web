package s3_gps_ivanti.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3_gps_ivanti.DTO.UserBasicInfoDTO;
import s3_gps_ivanti.business.UserService;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.model.Customer;
import s3_gps_ivanti.model.User;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    private final UserService userService;

//    @GetMapping("{id}")
//    public ResponseEntity<Application> getApplicationsBySearch(@PathVariable("id") long id) {
//
//        Application application = applicationService.getApplicationsByID(id);
//
//        if(application != null) {
//            return ResponseEntity.ok().body(application);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/creator/{id}")
    public ResponseEntity<UserBasicInfoDTO> getCreatorByID(@PathVariable("id") int id){
        User user = userService.getUserByID(id);

        if (user != null && user instanceof Creator){
            UserBasicInfoDTO dto = new UserBasicInfoDTO(user);
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<UserBasicInfoDTO> getCustomerByID(@PathVariable("id") int id){
        User user = userService.getUserByID(id);

        if (user != null && user instanceof Customer){
            UserBasicInfoDTO dto = new UserBasicInfoDTO(user);
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
