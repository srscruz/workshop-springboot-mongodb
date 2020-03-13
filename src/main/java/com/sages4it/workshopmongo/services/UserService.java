package com.sages4it.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sages4it.workshopmongo.domain.User;
import com.sages4it.workshopmongo.dto.UserDTO;
import com.sages4it.workshopmongo.repository.UserRepository;
import com.sages4it.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
