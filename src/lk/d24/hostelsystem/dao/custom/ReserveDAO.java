/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/11/2023
  @ Time         : 4:49 PM
*/
package lk.d24.hostelsystem.dao.custom;

import lk.d24.hostelsystem.dao.CrudDAO;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface ReserveDAO extends CrudDAO<Reservation, String> {
    List<Reservation> viewAllReservations(Session session);

    List<Reservation> viewActiveReservations(Session session);

    List<Reservation> viewNotpaidReservations(Session session);
}
