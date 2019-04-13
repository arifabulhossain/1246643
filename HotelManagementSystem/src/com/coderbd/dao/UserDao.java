/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserDao {
       void createTable();

    void save(User user);

    void update(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    void delete(int id);

    List<User> getUsers();
}
