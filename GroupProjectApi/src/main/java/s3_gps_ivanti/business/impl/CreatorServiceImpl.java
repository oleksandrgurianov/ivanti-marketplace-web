package s3_gps_ivanti.business.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.CreatorService;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.repository.CreatorRepository;

@Service
@Primary
@RequiredArgsConstructor
public class CreatorServiceImpl implements CreatorService {
    private final CreatorRepository repository;

    public Creator getCreator(int id) {
        for (Creator creator: repository.getCreators()){
            if(creator.getId()==id){
                return creator;
            }
        }
        return null;
    }
}
