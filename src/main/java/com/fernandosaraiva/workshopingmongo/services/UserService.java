package com.fernandosaraiva.workshopingmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosaraiva.workshopingmongo.domain.User;
import com.fernandosaraiva.workshopingmongo.repository.UserRepository;
import com.fernandosaraiva.workshopingmongo.services.exception.*;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}