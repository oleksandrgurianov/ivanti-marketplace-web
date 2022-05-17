package s3_gps_ivanti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import s3_gps_ivanti.repository.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import s3_gps_ivanti.repository.entity.Creator;
import s3_gps_ivanti.repository.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EnableMongoRepositories
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class s3_GPS_Ivanti implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	@Autowired
	CreatorRepository creatorRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	ApplicationRepository applicationRepository;

	List<Creator> creatorList = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(s3_GPS_Ivanti.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(new User("1","lars","lars", List.of("11","22")));

		creatorRepository.save(new Creator("first","1", "1"));
		creatorList = creatorRepository.findAll();

		for (Creator u: creatorList) {
			System.out.println(u.getUser_id());
			System.out.println(
					userRepo.findById(u.getUser_id()).get().getEmail()
			);
		}
	}
}

