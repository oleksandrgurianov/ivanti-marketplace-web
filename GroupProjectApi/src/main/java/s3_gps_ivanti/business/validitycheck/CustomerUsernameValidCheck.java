package s3_gps_ivanti.business.validitycheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.CustomerNotFoundException;
import s3_gps_ivanti.repository.UserRepository;

@Service
@AllArgsConstructor
public class CustomerUsernameValidCheck {
    private UserRepository userRepository;

    public void customerIsValid(String name){
        if(!userRepository.existsByUsername(name)){
            throw new CustomerNotFoundException();
        }
    }
}
