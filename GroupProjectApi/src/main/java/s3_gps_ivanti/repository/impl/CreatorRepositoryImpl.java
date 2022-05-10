package s3_gps_ivanti.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.repository.CreatorRepository;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.repository.DataBaseForNow;

import java.util.ArrayList;

@Primary
@Service
public class CreatorRepositoryImpl implements CreatorRepository {
    private DataBaseForNow database = new DataBaseForNow();

    @Override
    public ArrayList<Creator> getCreators() {
        return this.database.creators;
    }
}
