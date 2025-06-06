package com.sprinboot.learn;

import com.sprinboot.learn.aop.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication implements CommandLineRunner {

	@Autowired
	UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		userService.createUser("Arjun");
		userService.deleteUser("Arjun");
	}
}


/**
 * why not call userService.createUser() from main() directly?
 * Because:
 *
 * main() runs before Spring finishes creating beans
 *
 * So @Autowired fields like userService would be null
 *
 * But run() (from CommandLineRunner) is called after Spring has set everything up, including proxies
 *
 *
 *
 *
 * 2️⃣ implements CommandLineRunner
 *
 * public class DemoApplication implements CommandLineRunner
 * ✅ What does this mean?
 * Spring Boot has an interface called CommandLineRunner
 *
 * If your @SpringBootApplication class implements it, Spring will automatically call the run() method after the application context is loaded.
 *
 * It’s perfect for testing, debugging, or running startup logic (like calling a method without writing a controller or UI).
 */