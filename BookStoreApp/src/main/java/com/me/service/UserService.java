/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.service;

/**
 *
 * @author Lord Aegon
 */
import com.me.model.Login;
import com.me.model.User;

public interface UserService {

    public void register(User user);
    public void update(User user);
    public void getUser(User user);
    public User validateUser(Login login);

}
