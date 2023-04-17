/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 9:40 PM
*/
package lk.d24.hostelsystem.service.util;

import lk.d24.hostelsystem.dto.*;
import lk.d24.hostelsystem.entity.LoginDetail;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;

public class Convertor {
    public StudentDTO fromStudent(Student student){
        return new StudentDTO(student.getStudent_id(), student.getName(),student.getAddress(),student.getContact_no(),student.getDob(),student.getGender(),student.getReservationList());
    }

    public Student toStudent(StudentDTO studentDTO){
        return new Student(studentDTO.getStudent_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact_no(),studentDTO.getDob(),studentDTO.getGender(),studentDTO.getReservationList());
    }

    public RoomDTO fromRoom(Room room){
        return new RoomDTO(room.getRoom_type_id(), room.getType(), room.getKey_money(), room.getQty(), room.getReservationList());
    }

    public Room toRoom(RoomDTO roomDTO){
        return new Room(roomDTO.getRoom_type_id(), roomDTO.getType(), roomDTO.getKey_money(), roomDTO.getQty(), roomDTO.getReservationList());
    }

    public LoginDetailDTO fromLoginDetail(LoginDetail loginDetail){
        return new LoginDetailDTO(loginDetail.getUserID(),loginDetail.getUsername(), loginDetail.getPassword());
    }

    public LoginDetail toLoginDetail(LoginDetailDTO loginDetailDTO){
        return new LoginDetail(loginDetailDTO.getUserID(), loginDetailDTO.getUsername(), loginDetailDTO.getPassword());
    }

    public Reservation toReservation(ReservationDTO reservationDTO){
        return new Reservation(reservationDTO.getRes_id(),reservationDTO.getDate(), reservationDTO.getStudent(), reservationDTO.getRoom(), reservationDTO.getStatus());
    }

    public ReservationDTO fromReservation(Reservation reservation){
        return new ReservationDTO(reservation.getRes_id(),reservation.getDate(), reservation.getStudent(), reservation.getRoom(), reservation.getStatus());
    }

}
