package com.codegym.service;

import com.codegym.model.User;

public interface IUserService {
    void save(User user);

    User findByName(String name);

    void delete(User user);
}
