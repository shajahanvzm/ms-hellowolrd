package com.sha.userms.service;

import com.sha.userms.entity.User;

import java.util.List;

public interface UserService {
    public User save(User user);
    public User update(long id, User user);
    public List<User> findAll();
    public User findById(long id);
    public void deleteById(long id);
    public void deleteAll();
}
