package s3_gps_ivanti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.UpdateCodeRepository;
import s3_gps_ivanti.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
public class s3_GPS_Ivanti implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	@Autowired
	UpdateCodeRepository updateCodeRepo;

	List<User> userList = new ArrayList<User>();

	public static void main(String[] args) {
		SpringApplication.run(s3_GPS_Ivanti.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {

// Clean up any previous data
		//userRepo.deleteAll(); // Doesn't delete the collection

		System.out.println("-------------CREATE USERS-------------------------------\n");
		createUsers();

		System.out.println("\n----------------SHOW ALL USERS---------------------------\n");

		showAllUsers();

		System.out.println("\n--------------GET USER BY NAME-----------------------------------\n");

		getUsersByUsername("Noelia");

		System.out.println("\n-----------GET USERS BY PERMISSION---------------------------------\n");

		getUsersByPermission("creator");

		System.out.println("\n-----------UPDATE PERMISSION NAME OF ALL USERS----------------\n");

		updatePermissionName("creator");

		System.out.println("\n-----------UPDATE CODE OF AN USER------------------------\n");

		updateCode("Noelia", 111);

		System.out.println("\n----------DELETE AN USER---------------------------------\n");

		deleteUser(100);

		System.out.println("\n------------FINAL COUNT OF USERS-------------------------\n");

		findCountOfUsers();

		System.out.println("\n-------------------END---------------------------");

		System.out.println("\n--------------GET USER BY NAME-----------------------------------\n");

		getUsersByUsername("Noelia");
	}


	// CRUD operations

	//CREATE
	private void createUsers() {
		System.out.println("Data creation started...");

		userRepo.save(new User(1,"Noelia", "noelia", "creator", 100));
		userRepo.save(new User(2,"Esther", "esther", "creator", 100));
		userRepo.save(new User(3,"Lars", "lars", "creator", 100));
		userRepo.save(new User(4,"Aleksy", "noelia", "customer", 100));
		userRepo.save(new User(5,"Mohammad", "mohammad", "customer", 100));
		userRepo.save(new User(6,"Oleksander", "oleksander", "customer", 100));
		userRepo.save(new User(7,"Fabian", "fabian", "customer", 100));

		System.out.println("Data creation complete...");
	}

	// READ
	// 1. Show all the data
	public void showAllUsers() {
		userList = userRepo.findAll();
		userList.forEach(item -> System.out.println(getUserDetails(item)));
	}

	// 2. Get user by name
	public void getUsersByUsername(String username) {
		System.out.println("Getting user by name: " + username);
		User user = userRepo.findUserByUsername(username);
		System.out.println(getUserDetails(user));
	}

	// 3. Get name and code of users with a particular permission
	public void getUsersByPermission(String permission) {
		System.out.println("Getting users with permission: " + permission);
		List<User> list = userRepo.findAll(permission);

		list.forEach(user -> System.out.println("Username: " + user.getUsername() + ", Code: " + user.getUserCode()));
	}

	// 4. Get count of documents in the collection
	public void findCountOfUsers() {
		long count = userRepo.count();
		System.out.println("Number of documents in the collection = " + count);
	}

	// UPDATE APPROACH 1: Using MongoRepository
	public void updatePermissionName(String permission) {

		// Change to this new value
		String newPermission = "QueenAccess";

		// Find all the items with the category
		List<User> list = userRepo.findAll(permission);

		list.forEach(user-> {
			// Update the category in each document
			user.setPermission(newPermission);
		});

		// Save all the items in database
		List<User> usersUpdated = userRepo.saveAll(list);

		if(usersUpdated != null)
			System.out.println("Successfully updated " + usersUpdated.size() + " items.");
	}


	// UPDATE APPROACH 2: Using MongoTemplate
	public void updateCode(String username, float newCode) {
		System.out.println("Updating quantity for " + username);
		updateCodeRepo.UpdateCode(username, newCode);
	}
	// DELETE
	public void deleteUser(int id) {
		userRepo.deleteById(String.valueOf(id));
		System.out.println("User with id " + id + " deleted...");
	}
	// Print details in readable form

	public String getUserDetails(User user) {

		System.out.println(
				"Username: " + user.getUsername() +
						", \nUser Code: " + user.getUserCode() +
						", \nUser Permission: " + user.getPermission()
		);
		return "";
	}
}

