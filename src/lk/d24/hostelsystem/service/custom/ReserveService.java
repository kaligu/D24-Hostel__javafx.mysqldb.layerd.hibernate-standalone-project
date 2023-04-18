/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/11/2023
  @ Time         : 4:48 PM
*/
package lk.d24.hostelsystem.service.custom;

import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface ReserveService {
    boolean saveReservation(ReserveDTO reserveDTO);

    List<ReserveDTO> viewAllReservations();

    List<ReserveDTO> viewActiveReservations();

    List<ReserveDTO> viewNotpaidReservations();

    boolean update(ReserveDTO reserveDTO);

    List<ReservationDTO> findAllRoomExpireTodayReservations();

    List<ReservationDTO> viewAllNotpaidReservationsStRoom();

    String getLastOrderID();
}
