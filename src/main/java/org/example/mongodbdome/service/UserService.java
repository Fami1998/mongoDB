package org.example.mongodbdome.service;

import org.example.mongodbdome.model.User;
import org.example.mongodbdome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Faim
 * @create 2024/6/7 17:05
 */
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
