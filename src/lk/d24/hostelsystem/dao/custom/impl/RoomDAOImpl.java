/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 2:58 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.custom.RoomDAO;
import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity, Session session) {
        if(session.save(entity)!=null) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Room entity, Session session) {
        return false;
    }

    @Override
    public boolean delete(Room entity, Session session) {
        return false;
    }

    @Override
    public Room findByPk(String pk, Session session) {
        return null;
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public List<Room> searchRoomByText(String text, Session session) {
        List<Room> roomList = new ArrayList<>();

        String hql = "FROM Room E WHERE E.room_type_id like '%"+text+"%'";
        Query query = session.createQuery(hql);
        roomList=query.list();
        return roomList;
    }
}
