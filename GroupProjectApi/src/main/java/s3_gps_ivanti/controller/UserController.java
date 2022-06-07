package s3_gps_ivanti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import s3_gps_ivanti.business.dtoconvertor.ApplicationDTOConverter;
import s3_gps_ivanti.business.user.*;
import s3_gps_ivanti.configuration.security.isauthenticated.IsAuthenticated;
import s3_gps_ivanti.dto.application.ApplicationAnalyticsDTO;
import s3_gps_ivanti.dto.user.*;
import lombok.RequiredArgsConstructor;
import s3_gps_ivanti.repository.entity.User;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
    private final CreateCustomerUseCase createCustomer;
    private final DeleteCustomerUseCase deleteCustomer;
    private final GetCustomersUseCase getCustomers;
    private final GetCustomerUseCase getCustomer;
    private final UpdateCustomerUseCase updateCustomer;
    private final GetCreatorUseCase getCreator;

    //All
    @PostMapping()
    public ResponseEntity<CreateCustomerResponseDTO> createUser(@RequestBody CreateCustomerRequestDTO user) {
        CreateCustomerResponseDTO customerResponseDTO = createCustomer.createCustomer(user);

        if(customerResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok().body(customerResponseDTO);
    }


    //Queen
    @IsAuthenticated
    @RolesAllowed({"ROLE_Queen"})
    @GetMapping()
    public ResponseEntity<List<UserBasicInfoDTO>> getUsers() {
        return ResponseEntity.ok().body(getCustomers.getAllCustomers());
    }

    //Customer and Creator
    @IsAuthenticated
    @RolesAllowed({"ROLE_Customer", "ROLE_Creator"})
    @GetMapping("/{username}")
    public ResponseEntity<CustomerDetailedInfoDTO> getUser(@PathVariable String username) {
        CustomerDetailedInfoDTO customerDetailedInfoDTO = getCustomer.getCustomer(username);

        if(customerDetailedInfoDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(getCustomer.getCustomer(username));
    }

    //Customer
    @IsAuthenticated
    @RolesAllowed({"ROLE_Customer"})
    @PutMapping()
    public ResponseEntity<Object> updateCustomer(@RequestBody UpdateCustomerRequestDTO updatedUser) {
        updateCustomer.updateCustomer(updatedUser);
        return ResponseEntity.ok().build();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_Customer"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  deleteUser(@PathVariable String id) {
        deleteCustomer.DeleteCustomer(id);
        return ResponseEntity.ok().build();
    }


    //TODO is this a public resource, can anyone use this?
    @GetMapping("{creatorName}/statistics")
    public ResponseEntity<List<ApplicationAnalyticsDTO>>getVersionAnalytics(@PathVariable String creatorName) {
        User creator = getCreator.getCreator(creatorName);
        List<ApplicationAnalyticsDTO> analytics = ApplicationDTOConverter.convertToDTOListForAnalytics(creator.getApplications());

        if(creator!=null){
            return ResponseEntity.ok().body(analytics);
        }
        return ResponseEntity.notFound().build();
    }
    //TODO fix this
   /* @GetMapping("{id}")
   public ResponseEntity<Application> getApplicationsBySearch(@PathVariable("id") long id) {

        Application Application = applicationService.getApplicationsByID(id);
        /       if(Application != null) {
            return ResponseEntity.ok().body(Application);} else {
            return ResponseEntity.notFound().build();
      }
    }*/
}

