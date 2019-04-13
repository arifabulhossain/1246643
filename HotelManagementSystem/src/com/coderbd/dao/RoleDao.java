/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.Role;
import java.util.List;

/**
 *
 * @author User
 */
public interface RoleDao {
    void createTable();

    void save(Role role);

    void update(Role role);

    Role getRoleById(int id);

    Role getRoleByRoleName(String roleName);

    void delete(int id);

    List<Role> getRoles();  
}
