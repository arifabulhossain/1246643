/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.EmployeeDetails;
import com.coderbd.pojo.RoomBooking;
import java.util.List;

/**
 *
 * @author User
 */
public interface RoomBookingDao {

    void createTable();

    void save(RoomBooking rbd);

    void update(RoomBooking rbd);

    RoomBooking getRoomBookingById(int id);

    RoomBooking getRoomBookingByRoomBookingCode(String code);

    void delete(int id);

    List<RoomBooking> getList();

   
}
