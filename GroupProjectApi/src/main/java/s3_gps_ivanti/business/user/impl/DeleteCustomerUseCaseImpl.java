package s3_gps_ivanti.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.CustomerNotFoundException;
import s3_gps_ivanti.business.user.DeleteCustomerUseCase;
import s3_gps_ivanti.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private final UserRepository userRepository;

    @Override
    public void DeleteCustomer(String customerID) {
        //TODO check token.userid
        if(userRepository.findById(customerID).orElse(null) == null) {
            throw new CustomerNotFoundException();
        }

        if(userRepository.findById(customerID) != null) {
            userRepository.deleteById(customerID);
        }
        else
        {
            throw new CustomerNotFoundException();
        }
    }
}
