package com.app.service;

import com.app.exception.UserException;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository ur;

    @Override
    public User saveUser(User user) {
        return ur.save(user);
    }

    @Override
    public User getUserById(String id) throws UserException {
        int userId = Integer.parseInt(id);
        return ur.findById(userId).orElseThrow(() -> new UserException("no user found with given id -> " + id));
    }

    @Override
    public User getUserByEmail(String email) throws UserException {
        return ur.findByUserEmail(email).orElseThrow(() -> new UserException("no user found with given email -> " + email));
    }

    @Override
    public List<User> getAllUsers() {
        return ur.findAll();
    }
}
