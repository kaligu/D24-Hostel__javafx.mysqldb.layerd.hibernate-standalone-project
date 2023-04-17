/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/12/2023
  @ Time         : 3:45 AM
*/
package lk.d24.hostelsystem.dao.custom.impl;

import lk.d24.hostelsystem.dao.QueryDAO;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.qaRoomDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<qaRoomDTO> findAllAvailableRooms(Session session) {
        List<qaRoomDTO> roomList1 = new ArrayList<>();
        String hql = "SELECT r.room_type_id, r.key_money, r.type, CAST((r.qty - COALESCE(COUNT(res), 0)) AS integer) AS AvailableRoomsQTY " +
                "FROM Room r " +
                "LEFT JOIN Reservation res ON r.room_type_id = res.room.room_type_id AND res.date >= CURRENT_DATE " +
                "GROUP BY r.room_type_id";
        Query<Object[]> query = session.createQuery(hql);
        List<Object[]> result = query.getResultList();
        for (Object[] row : result) {
            String roomTypeId = (String) row[0];
            Double keyMoney = (Double) row[1];
            String type = (String) row[2];
            Integer availableRoomsQty = (Integer) row[3];
            qaRoomDTO room = new qaRoomDTO(roomTypeId, type, keyMoney, availableRoomsQty);
            roomList1.add(room);
        }
        return roomList1;
    }

}

