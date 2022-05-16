package s3_gps_ivanti.controller;

import org.springframework.web.bind.annotation.*;
import s3_gps_ivanti.business.UserService;
import s3_gps_ivanti.business.exceptions.UserNotFoundException;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import s3_gps_ivanti.dto.UserBasicInfoDTO;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.model.Customer;

import java.util.List;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
private final UserRepository userRepository;
private final UserService userService;

@GetMapping("/users")
public List<User> getUsers() {
    return userRepository.findAll();
}
@GetMapping("/user/{id}")
public User user(@PathVariable String id) {
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
}
@DeleteMapping("/delete/{id}")
public void deleteUser(@PathVariable String id) {
   if (!userExists(id)) {
   throw new UserNotFoundException(id);
   }
   userRepository.deleteById(id);
}
@PostMapping("/users")
public void saveUser(@RequestBody User user) {
        userRepository.save(user);
}
@PutMapping("/users/{id}")
    User replaceUser(@RequestBody User updatedUser, @PathVariable String id) {
        if (!userExists(id)) {
        throw new UserNotFoundException(id);
        }

        return userRepository.save(updatedUser);
        }

private boolean userExists(final String id) {
        return userRepository.existsById(id);
        }


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

        if (user instanceof Creator){
            UserBasicInfoDTO dto = new UserBasicInfoDTO(user);
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<UserBasicInfoDTO> getCustomerByID(@PathVariable("id") int id){
        User user = userService.getUserByID(id);

        if (user instanceof Customer){
            UserBasicInfoDTO dto = new UserBasicInfoDTO(user);
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

