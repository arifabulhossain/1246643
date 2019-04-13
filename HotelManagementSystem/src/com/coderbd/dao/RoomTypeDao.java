/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.CustomerDetails;
import com.coderbd.pojo.EmployeeDetails;
import com.coderbd.pojo.HotelDetails;
import com.coderbd.pojo.RoomType;
import java.util.List;

/**
 *
 * @author User
 */
public interface RoomTypeDao {
     void createTable();

    void save( RoomType rd);

    void update( RoomType rd);

     RoomType getRoomTypeById(int id);

    CustomerDetails getRoomTypeByRoomTypeCode(String code);

    void delete(int id);

    List<RoomType> getList();
}
