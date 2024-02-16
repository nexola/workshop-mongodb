package com.nexola.workshopmongodb.services;

import com.nexola.workshopmongodb.models.dto.UserDTO;
import com.nexola.workshopmongodb.models.entities.User;
import com.nexola.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> result = repository.findAll();
        return result.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
