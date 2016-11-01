package com.HBV501.touristEvents.dao;

import com.HBV501.touristEvents.model.User;

import java.util.List;

/**
 * Created by Siggigauti on 01/11/2016.
 */
public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(User user);
}
