package com.sages4it.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sages4it.workshopmongo.domain.Post;
import com.sages4it.workshopmongo.domain.User;
import com.sages4it.workshopmongo.dto.AuthorDTO;
import com.sages4it.workshopmongo.dto.CommentsDTO;
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
		
	 userRepository.deleteAll();
	 postRepository.deleteAll();
		
		User carlos = new User(null, "Carlos Alberto da Silva", "carlossilva@gmail.com");
		User welington = new User(null, "Welington Gonçalves de Souza", "wsouza@gmail.com");
		User mike = new User(null, "Mike Brown", "mikebrown@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(carlos,welington,mike));
		
		Post post1 = new Post(null, sdf.parse("12/03/2020"), "Corona Virus", "O mundo está complicado!", new AuthorDTO(carlos));
		Post post2 = new Post(null, sdf.parse("13/03/2020"), "Suspensão de Aulas", "Governo do Estado de São Paulo suspenderá as aulas à partir da proxima semana.",new AuthorDTO(mike));
		
		CommentsDTO c1 = new CommentsDTO("Realmente estou muito preocupado com esta situação", sdf.parse("12/03/2020"), new AuthorDTO(welington));
		CommentsDTO c2 = new CommentsDTO("Eu também estou bastante preucupado", sdf.parse("12/03/2020"), new AuthorDTO(carlos));
		CommentsDTO c3 = new CommentsDTO("É eu vi a noticia, parece que já é a partir desta semana", sdf.parse("16/03/2020"), new AuthorDTO(welington));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		
	   //arlos.getPosts().addAll(Arrays.asList(post1, post2));
	   
	   //userRepository.save(u1);
	   
	}

}
