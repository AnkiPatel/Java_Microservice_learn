package com.pravisolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);

		/* Usage of  builder
		User user = User.builder().firstName("Aaradya").lastName("Pandit").email("ap@ps.com").build();
		 */
	}

}
