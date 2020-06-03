/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.service;

import com.me.DAO.UserDAO;
import com.me.model.Login;
import com.me.model.User;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Lord Aegon
 */
public class UserServiceImpl implements UserService{

    @Autowired

    UserDAO userDao;

    @Override

    public void register(User user) {

        userDao.register(user);

    }

    @Override

    public User validateUser(Login login) {

        return userDao.validateUser(login);

    }

    @Override

    public void update(User user) {

        userDao.update(user);

    }

    @Override

    public void getUser(User user) {

        userDao.getUser(user);

    }

}
