package s3_gps_ivanti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class s3_GPS_Ivanti implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(s3_GPS_Ivanti.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this methode is empty because I think it looks nice. DO YOU HAVE A PROBLEM WITH THAT!!!!!!
	}
}
