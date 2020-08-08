package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

/**
 * @Auther: lhq
 * @Date: 2020/8/4 15:29
 * @Description:
 */
public interface UserService {

    public void addUser(User user);

    public void updateUser(User user, Long id);

    public void delete(Long id);

    public User findOne(Long id);

    public List<User> findUserList();
}

