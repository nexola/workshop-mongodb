package com.nexola.workshopmongodb.services;

import com.nexola.workshopmongodb.models.dto.PostDTO;
import com.nexola.workshopmongodb.models.entities.Post;
import com.nexola.workshopmongodb.repositories.PostRepository;
import com.nexola.workshopmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

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
        List<Post> list = repository.searchTitle(text);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum post encontrado");
        }
        return list.stream().map(PostDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostDTO> fulSearch(String text, String start, String end) {
        Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
        Instant endMoment = convertMoment(end, Instant.now());
        List<Post> list = repository.fullSearch(text, startMoment, endMoment);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum post encontrado");
        }
        return list.stream().map(PostDTO::new).collect(Collectors.toList());
    }

    private Instant convertMoment(String momentStr, Instant alterValue) {
        try {
            return Instant.parse(momentStr);
        } catch (DateTimeParseException e) {
            return Instant.parse(momentStr);
        }
    }
}
