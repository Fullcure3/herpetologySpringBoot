package org.portfolio.services;

import org.portfolio.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements LoginService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValidUser(String username, String password) {
        return repository.getUserByUsernameAndPassword(username, password) != null;
    }
}
