package s3_gps_ivanti.business.validitycheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.repository.ApplicationRepository;

@Service
@AllArgsConstructor
public class ApplicationIDValidCheck {
    private ApplicationRepository applicationRepository;

    public void applicationIdIsValid(String id){
        if(!applicationRepository.existsById(id)){
            throw new ApplicationNotFoundException();
        }
    }
}
