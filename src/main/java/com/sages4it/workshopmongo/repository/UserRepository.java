package com.sages4it.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sages4it.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

}
