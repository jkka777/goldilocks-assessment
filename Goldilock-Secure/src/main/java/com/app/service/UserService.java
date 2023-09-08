package com.app.service;

import com.app.exception.UserException;
import com.app.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public User getUserById(String  id) throws UserException;

    public User getUserByEmail(String email) throws UserException;

    public List<User> getAllUsers();
}
