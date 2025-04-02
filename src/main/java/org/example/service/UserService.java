package org.example.service;

import org.example.model.User;
import org.example.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void save(User user) {
        userDao.save(user);
    }
    public User getUserById(Long id) {
        return userDao.getById(id);
    }
    public void delete(Long id) {
        userDao.delete(id);
    }
    public void update(User user) {
        userDao.update(user);
    }
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
