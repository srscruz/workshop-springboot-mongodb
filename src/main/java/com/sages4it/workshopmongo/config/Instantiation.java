package com.sages4it.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sages4it.workshopmongo.domain.User;
import com.sages4it.workshopmongo.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// userRepository.deleteAll();
		
		User u1 = new User(null, "Carlos Alberto da Silva", "carlossilva@gmail.com");
		User u2 = new User(null, "Welington Gonçalves de Souza", "wsouza@gmail.com");
		User u3 = new User(null, "Mike Brown", "mikebrown@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
	}

}
