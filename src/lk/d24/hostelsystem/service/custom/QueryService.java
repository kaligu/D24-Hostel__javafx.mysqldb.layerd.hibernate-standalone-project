/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/12/2023
  @ Time         : 8:12 AM
*/
package lk.d24.hostelsystem.service.custom;

import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.qaRoomDTO;

import java.util.List;

public interface QueryService {
    List<qaRoomDTO> findAllAvailableRooms();
}
