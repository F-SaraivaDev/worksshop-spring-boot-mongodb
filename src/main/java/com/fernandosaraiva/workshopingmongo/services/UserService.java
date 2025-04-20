package com.fernandosaraiva.workshopingmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosaraiva.workshopingmongo.domain.User;
import com.fernandosaraiva.workshopingmongo.dto.UserDTO;
import com.fernandosaraiva.workshopingmongo.repository.UserRepository;
import com.fernandosaraiva.workshopingmongo.services.exception.ObjectNotFoundException;

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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
	    User newObj = repo.findById(obj.getId()).get(); // sem if, direto no get()
	    updateData(newObj, obj);
	    return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
	    newObj.setName(obj.getName()); // corrigido nome do método
	    newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
















