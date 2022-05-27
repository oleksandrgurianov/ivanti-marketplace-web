package s3_gps_ivanti.business.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.repository.ApplicationRepository;

@Service
@AllArgsConstructor
public class ApplicationIDValidation {
    private ApplicationRepository applicationRepository;

    public void applicationIdIsValid(String id){
        if(!applicationRepository.existsById(id)){
            throw new ApplicationNotFoundException();
        }
    }
}
