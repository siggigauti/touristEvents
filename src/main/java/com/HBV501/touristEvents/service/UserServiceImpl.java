package com.HBV501.touristEvents.service;

import com.HBV501.touristEvents.dao.EventDao;
import com.HBV501.touristEvents.dao.UserDao;
import com.HBV501.touristEvents.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Siggigauti on 01/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {

    }

}
