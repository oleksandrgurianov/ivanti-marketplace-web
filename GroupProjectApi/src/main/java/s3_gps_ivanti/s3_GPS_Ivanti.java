package s3_gps_ivanti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import s3_gps_ivanti.repository.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import s3_gps_ivanti.repository.entity.*;

import java.util.List;

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
	ApplicationRepository applicationRepository;

	public static void main(String[] args) {
		SpringApplication.run(s3_GPS_Ivanti.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(new User("1","lars","lars", List.of("11","22")));
		applicationRepository.save(new Application("1","1","ivanti","description","icon",List.of("screenshot","screenshot"),false,List.of(new Version(1.0,0,"app_location")),List.of(new Review("1","5","review1","description1",null),new Review("2","5","review2","description2",null)),new RatingAnalytics(0,0,0,0,0)));
		creatorRepository.save(new Creator("1","1",List.of("1","2")));
		customerRepository.save(new Customer("1","1",List.of("1")));
	}
}

