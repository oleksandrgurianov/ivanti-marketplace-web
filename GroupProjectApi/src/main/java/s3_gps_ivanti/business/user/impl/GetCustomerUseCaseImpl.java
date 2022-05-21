package s3_gps_ivanti.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.CustomerNotFoundException;
import s3_gps_ivanti.business.user.GetCustomerUseCase;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.User;

@Service
@Primary
@RequiredArgsConstructor
public class GetCustomerUseCaseImpl implements GetCustomerUseCase {

    private final UserRepository userRepository;

    @Override
    public User getCustomer(String username) {
        //TODO check if is admin

        User result = userRepository.findUserByUsernameAndPermission(username);

       if(result == null){
           throw new CustomerNotFoundException();
       }

       return result;
    }
}