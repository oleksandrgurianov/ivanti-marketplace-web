package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.business.CreatorService;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.repository.CreatorRepository;

public class CreatorServiceImpl implements CreatorService {
    private final CreatorRepository repository;

    public CreatorServiceImpl(CreatorRepository repository){
        this.repository = repository;
    }

    public Creator getCreator(int id) {
        for (Creator creator: repository.getCreators()){
            if(creator.getId()==id){
                return creator;
            }
        }
        return null;
    }
}
