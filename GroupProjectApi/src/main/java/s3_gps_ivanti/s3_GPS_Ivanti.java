package s3_gps_ivanti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.UserRepository;

@SpringBootApplication
public class s3_GPS_Ivanti implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(s3_GPS_Ivanti.class, args);
	}
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
