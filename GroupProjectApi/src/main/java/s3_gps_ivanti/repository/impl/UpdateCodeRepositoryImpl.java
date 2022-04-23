package s3_gps_ivanti.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.UpdateCodeRepository;

@Component
public class UpdateCodeRepositoryImpl implements UpdateCodeRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void UpdateCode(String username, float newCode) {
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("code", newCode);

        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);

        if (result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

    }
}
