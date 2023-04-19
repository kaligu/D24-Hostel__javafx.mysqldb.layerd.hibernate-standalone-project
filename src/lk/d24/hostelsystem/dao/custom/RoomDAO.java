/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 2:52 PM
*/
package lk.d24.hostelsystem.dao.custom;

import lk.d24.hostelsystem.dao.CrudDAO;
import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room , String> {
    List<Room> searchRoomByText(String text , Session session);

    List<Room> getAll(Session session);

    int getAllRoomCount(Session session);

    String getLastRoomID(Session session);
}
