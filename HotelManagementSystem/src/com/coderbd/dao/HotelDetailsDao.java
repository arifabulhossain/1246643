/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.CustomerDetails;
import com.coderbd.pojo.EmployeeDetails;
import com.coderbd.pojo.HotelDetails;
import java.util.List;

/**
 *
 * @author User
 */
public interface HotelDetailsDao {
   void createTable();

    void save(HotelDetails hd);

    void update(HotelDetails hd);

    EmployeeDetails getHotelDetailsById(int id);

    CustomerDetails getHotelDetailsByHotelDetailsCode(String code);

    void delete(int id);

    List<HotelDetails> getList();
}
