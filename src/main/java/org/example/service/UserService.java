package org.example.service;

import org.example.model.User;
import org.example.dao.UserDao;
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
        return userDao.findById(id);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }
    public void update(User user) {
        userDao.save(user);
    }
    public List<User> getAllUser() {
        return userDao.findAllUser();
    }
}
