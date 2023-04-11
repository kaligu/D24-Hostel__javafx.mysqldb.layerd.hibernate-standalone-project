/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 2:38 PM
*/
package lk.d24.hostelsystem.service.custom;

import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.StudentDTO;

import java.util.List;

public interface RoomService {
    boolean saveRoom(RoomDTO roomDTO);

    List<RoomDTO> searchRoomByText(String text);
}