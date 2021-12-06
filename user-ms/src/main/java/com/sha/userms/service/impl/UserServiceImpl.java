package com.sha.userms.service.impl;

import com.sha.userms.entity.User;
import com.sha.userms.repository.UserRepository;
import com.sha.userms.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(long id, User user) {
        User dbUser = userRepository.findById(id).get();
        dbUser.setId(id);
        dbUser.setName(user.getName());
        dbUser.setEmail(user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
