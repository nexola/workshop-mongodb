package com.nexola.workshopmongodb.controllers;

import com.nexola.workshopmongodb.models.dto.PostDTO;
import com.nexola.workshopmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping()
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(name = "title", defaultValue = "") String text) {
        List<PostDTO> result = service.findByTitle(text);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostDTO>> findByTitle(
            @RequestParam(name = "text", defaultValue = "") String text,
            @RequestParam(name = "start", defaultValue = "") String start,
            @RequestParam(name = "end", defaultValue = "") String end) {
        List<PostDTO> result = service.fulSearch(text, start, end);
        return ResponseEntity.ok(result);
    }
}
