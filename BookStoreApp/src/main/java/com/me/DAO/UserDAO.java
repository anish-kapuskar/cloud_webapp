/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

/**
 *
 * @author anish
 */
import com.me.model.Login;
import com.me.model.User;
public interface UserDAO {
  void register(User user);
  void update(User user);
  void getUser(User user);
  User validateUser(Login login);
}