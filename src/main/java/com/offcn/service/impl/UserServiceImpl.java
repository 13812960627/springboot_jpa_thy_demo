package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user, Long id) {
        user.setId(id);
        userDao.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findOne(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> findUserList() {
        return userDao.findAll();
    }
}
