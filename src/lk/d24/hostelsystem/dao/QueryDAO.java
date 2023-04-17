/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/12/2023
  @ Time         : 3:45 AM
*/
package lk.d24.hostelsystem.dao;

import lk.d24.hostelsystem.dao.SuperDAO;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.qaRoomDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<qaRoomDTO> findAllAvailableRooms(Session session);
}
