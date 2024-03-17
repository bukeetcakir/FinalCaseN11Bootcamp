package com.bukeetcakir.userService.service;

import com.bukeetcakir.userService.entity.User;
import com.bukeetcakir.userService.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserRepository> {
    protected UserEntityService(UserRepository repository) {
        super(repository);
    }
}
