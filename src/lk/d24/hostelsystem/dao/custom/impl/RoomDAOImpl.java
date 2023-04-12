/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 2:58 PM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.custom.RoomDAO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.HibernateException;
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
        try {
            session.update(entity);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Room entity, Session session) {
        try {
            session.delete(entity);
            return true;

        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public Room findByPk(String pk, Session session) {
        try {
            return session.get(Room.class,pk);

        } catch (HibernateException e) {
            return  null;
        }
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public List<Room> searchRoomByText(String text, Session session) {
        List<Room> roomList = new ArrayList<>();
        String hql = "FROM Room E WHERE E.room_type_id like '%"+text+"%' or E.type like '%"+text+"%'";
        Query query = session.createQuery(hql);
        roomList=query.list();
        return roomList;
    }
}
