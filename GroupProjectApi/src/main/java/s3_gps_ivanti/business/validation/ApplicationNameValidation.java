package s3_gps_ivanti.business.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.repository.ApplicationRepository;

@Service
@AllArgsConstructor
public class ApplicationNameValidation {
    private ApplicationRepository applicationRepository;

    public void applicationIdIsValid(String name){
        if(!applicationRepository.existsByName(name)){
            throw new ApplicationNotFoundException();
        }
    }
}
