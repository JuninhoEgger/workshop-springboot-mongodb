package com.juninhoegger.workshopmongo.service;

import com.juninhoegger.workshopmongo.domain.Post;
import com.juninhoegger.workshopmongo.exception.ObjectNotFoundException;
import com.juninhoegger.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        //MÉTODOS ALTERNATIVOS
        //return postRepository.findByTitleContainingIgnoreCase(text);

        return postRepository.findByTitle(text);
    }

}
