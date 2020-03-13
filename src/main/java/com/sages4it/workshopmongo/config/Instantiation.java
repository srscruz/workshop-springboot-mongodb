package com.sages4it.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sages4it.workshopmongo.domain.Post;
import com.sages4it.workshopmongo.domain.User;
import com.sages4it.workshopmongo.repository.PostRepository;
import com.sages4it.workshopmongo.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getDefault());
		
		// userRepository.deleteAll();
		
		User u1 = new User(null, "Carlos Alberto da Silva", "carlossilva@gmail.com");
		User u2 = new User(null, "Welington Gonçalves de Souza", "wsouza@gmail.com");
		User u3 = new User(null, "Mike Brown", "mikebrown@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post post1 = new Post(null, sdf.parse("12/03/2020"), "Corona Virus", "O mundo está complicado!", u2);
		Post post2 = new Post(null, sdf.parse("13/03/2020"), "Suspensão de Aulas", "Governo do Estado de São Paulo suspenderá as aulas à partir da proxima semana.", u1);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
	}

}
