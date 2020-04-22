package com.gnatienko.reader.service;

import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserEntity save(UserEntity entity) {
        return repository.save(entity);
    }

    public UserEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}