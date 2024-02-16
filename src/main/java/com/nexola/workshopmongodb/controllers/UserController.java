package com.nexola.workshopmongodb.controllers;

import com.nexola.workshopmongodb.models.dto.UserDTO;
import com.nexola.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
