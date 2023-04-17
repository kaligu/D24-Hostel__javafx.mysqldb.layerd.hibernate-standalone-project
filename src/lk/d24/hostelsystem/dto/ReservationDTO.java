/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/12/2023
  @ Time         : 6:06 PM
*/
package lk.d24.hostelsystem.dto;

import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO {
    private String res_id;
    private LocalDate date;
    private Student student;
    private Room room;
    private String status;
}
