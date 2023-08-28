package com.example.empik.githubapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApiServiceApplication.class, args);
		System.out.println("--- The simple Spring app return github user data and calculations, " +
				"also write data to H2 DB about operations ---\n" +
				"Use Postman app: http://localhost:8080/users/{login}\n"+
				"H2 DB Console: http://localhost:8080/h2-console JDBC URL:jdbc:h2:mem:testdb, Login:[sa], Pass:[]\n"+
				"Created by Anton Mekh for Empik");
	}

}
