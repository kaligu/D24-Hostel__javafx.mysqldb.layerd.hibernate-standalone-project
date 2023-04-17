/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/17/2023
  @ Time         : 2:06 PM
*/
package lk.d24.hostelsystem.view.tm;

import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaidReservationsTM {
    private String res_id;
    private LocalDate date;
    private String status;
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;
}
