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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class UserDAOImpl implements UserDAO {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;


  public void getUser(User user){
    String sql = "select * from users where email='" + user.getEmail()
            + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
  }

  public void register(User user) {

    String sql = "select * from users where email='" + user.getEmail()
            + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    if(users.size() == 0){
      String sql2 = "insert into users values(?,?,?,?)";
      jdbcTemplate.update(sql2, new Object[] { user.getEmail(),user.getPassword(),
              user.getFirstname(), user.getLastname() });
    }

    else {System.out.println("Email already exists!");}
  }



  public void update(User user) {
String updateQuery = "update users set password = ? , firstname = ? , lastname = ? where email = ?";
    jdbcTemplate.update(updateQuery, user.getPassword(), user.getFirstname(),user.getLastname(),user.getEmail());
  }



  public User validateUser(Login login) {




      String sql = "select * from users where email='" + login.getEmail()
              + "' and password='" + login.getPassword()+ "'";
      List<User> users = jdbcTemplate.query(sql, new UserMapper());
      return users.size() > 0 ? users.get(0) : null;




  }



  class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
      User user = new User();

      user.setEmail(rs.getString("email"));

      user.setPassword(rs.getString("password"));

      user.setFirstname(rs.getString("firstname"));
      user.setLastname(rs.getString("lastname"));


      return user;
    }
  }
}
