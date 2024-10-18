package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    User findUserById(Long userId);
    List<User> getAllUsers();

}
