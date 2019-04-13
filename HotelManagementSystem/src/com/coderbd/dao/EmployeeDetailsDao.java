/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.CustomerDetails;
import com.coderbd.pojo.EmployeeDetails;
import java.util.List;

/**
 *
 * @author User
 */
public interface EmployeeDetailsDao {

    void createTable();

    void save(EmployeeDetails ed);

    void update(EmployeeDetails ed);

    EmployeeDetails getEmployeeDetailsById(int id);

    EmployeeDetails getEmployeeDetailsByEmployeeDetailsCode(String code);

    void delete(int id);

    List<EmployeeDetails> getList();
}
