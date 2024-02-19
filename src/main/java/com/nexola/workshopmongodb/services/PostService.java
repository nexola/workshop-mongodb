package com.nexola.workshopmongodb.services;

import com.nexola.workshopmongodb.models.dto.PostDTO;
import com.nexola.workshopmongodb.models.entities.Post;
import com.nexola.workshopmongodb.repositories.PostRepository;
import com.nexola.workshopmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Transactional(readOnly = true)
    public PostDTO findById(String id) {
        Post entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new PostDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<PostDTO> findByTitle(String text) {
        List<Post> list = repository.findByTitleContainingIgnoreCase(text);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum post encontrado");
        }
        return list.stream().map(PostDTO::new).collect(Collectors.toList());
    }
}
