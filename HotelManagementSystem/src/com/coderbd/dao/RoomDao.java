/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.pojo.CustomerDetails;
import com.coderbd.pojo.Room;
import com.coderbd.pojo.RoomType;
import java.util.List;

/**
 *
 * @author User
 */
public interface RoomDao {
       void createTable();

    void save( Room r);

    void update( Room r);

     Room getRoomById(int id);

    Room getRoomByRoomCode(String code);

    void delete(int id);

    List<Room> getList();
}
