package s3_gps_ivanti.controller;

import org.springframework.web.bind.annotation.*;
import s3_gps_ivanti.business.exceptions.UserNotFoundException;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.UserRepository;

import java.util.List;
@RestController
public class UserController {
private final UserRepository userRepository;

public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        }


    @GetMapping("/users")
public List<User> getUsers() {
        return userRepository.findAll();
        }

@GetMapping("/user/{id}")
public User user(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        }

@DeleteMapping("/users/{id}")
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

/**
 * This method will completely replace the existing restaurant with <code>id</code> with <code>updatedRestaurant</code>.
 * @param updatedUser this needs to have the full details for the restaurant you're updating
 * @param id the ID of the restaurant you are updating. This will be used to locate and update the restaurant to be
 *           changed, NOT the ID in the updatedRestaurant object
 */
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
}