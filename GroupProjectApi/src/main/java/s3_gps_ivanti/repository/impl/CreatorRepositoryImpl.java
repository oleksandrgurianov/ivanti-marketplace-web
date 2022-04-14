package s3_gps_ivanti.repository.impl;

import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.repository.CreatorRepository;
import s3_gps_ivanti.repository.DataBaseForNow;

import java.util.ArrayList;

public class CreatorRepositoryImpl implements CreatorRepository {
    private DataBaseForNow database = new DataBaseForNow();

    private ArrayList<Creator> creators;

    public CreatorRepositoryImpl(){

    }

    @Override
    public ArrayList<Creator> getCreators() {
        return this.database.creators;
    }
}
