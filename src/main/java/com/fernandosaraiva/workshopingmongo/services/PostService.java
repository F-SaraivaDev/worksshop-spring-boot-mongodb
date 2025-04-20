package com.fernandosaraiva.workshopingmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosaraiva.workshopingmongo.domain.Post;
import com.fernandosaraiva.workshopingmongo.repository.PostRepository;
import com.fernandosaraiva.workshopingmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}






