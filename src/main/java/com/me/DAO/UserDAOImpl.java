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

    String sqlcreate1 = "CREATE TABLE IF NOT EXISTS users\n" +
            "(\n" +
            "email varchar(255),\n" +
            "password varchar(255),\n" +
            "firstname varchar(255),\n" +
            "lastname varchar(255)\n" +
            ");";

    jdbcTemplate.update(sqlcreate1);

    String sqlcreate2=  "CREATE TABLE IF NOT EXISTS Book " +
            "(\n" +
            "    id int(11) NOT NULL AUTO_INCREMENT,\n" +
            "    isbn varchar(255),\n" +
            "    title varchar(255),\n" +
            "    authors varchar(255),\n" +
            "    date varchar(255),\n" +
            "    quantity int(11),\n" +
            "    price double,\n" +
            "    seller varchar(255),\n" +
            "    time varchar(255),\n" +
            "    PRIMARY KEY (id)\n" +
            ");";

            jdbcTemplate.update(sqlcreate2);

    String sqlcreate3=  "CREATE TABLE IF NOT EXISTS Cart (\n" +
            "    id int(11) NOT NULL AUTO_INCREMENT,\n" +
            "    isbn varchar(255),\n" +
            "    title varchar(255),\n" +
            "    authors varchar(255),\n" +
            "    date varchar(255),\n" +
            "    quantity int(11),\n" +
            "    price int(11),\n" +
            "    buyer varchar(255),\n" +
            "    time varchar(255),\n" +
            "    PRIMARY KEY (id)\n" +
            ");\n";


    jdbcTemplate.update(sqlcreate3);


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
