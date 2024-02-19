package com.nexola.workshopmongodb.services;

import com.nexola.workshopmongodb.models.dto.UserDTO;
import com.nexola.workshopmongodb.models.entities.User;
import com.nexola.workshopmongodb.repositories.UserRepository;
import com.nexola.workshopmongodb.services.exceptions.DatabaseException;
import com.nexola.workshopmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional(readOnly = true)
    public UserDTO findById(String id) {
        User entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User();
        copyDtoToEntity(dto, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(String id, UserDTO dto) {
            User entity = repository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Recurso não encontrado")
            );
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new UserDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}
