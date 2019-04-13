/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;



import com.coderbd.pojo.CustomerDetails;
import java.util.List;

/**
 *
 * @author User
 */
public interface CustomerDetailsDao {

    void save(CustomerDetails customer);

    void createTable();    

    void update(CustomerDetails cd);

    CustomerDetails getCustomerDetailsById(int id);

    CustomerDetails getCustomerDetailsByCustomerDetailsCode(String code);

    void delete(int id);

    List<CustomerDetails> getList();
}
