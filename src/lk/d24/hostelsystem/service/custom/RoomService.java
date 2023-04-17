/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 2:38 PM
*/
package lk.d24.hostelsystem.service.custom;

import lk.d24.hostelsystem.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    boolean saveRoom(RoomDTO roomDTO);

    boolean updateRoom(RoomDTO roomDTO);

    boolean deleteRoom(RoomDTO roomDTO);

    List<RoomDTO> searchRoomByText(String text);

    RoomDTO findByPk(String pk);

    List<RoomDTO> getAllRooms();
}
