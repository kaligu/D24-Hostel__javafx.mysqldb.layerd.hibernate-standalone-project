/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/12/2023
  @ Time         : 9:36 AM
*/
package lk.d24.hostelsystem.dto;

import lk.d24.hostelsystem.entity.Room;
import lk.d24.hostelsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReserveDTO {
    private String res_id;

    private LocalDate date;

    private String studentID;

    private String roomID;

    private String status;
}
