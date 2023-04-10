/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 10:20 AM
*/
package lk.d24.hostelsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="Reservation")
public class Reservation implements SuperEntity{
    @Id
    @Column(name="res_id",columnDefinition = "VARCHAR(255)")
    private String res_id;

    @Column(name="dob",columnDefinition = "DATE")
    private Date date;

    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name="student_id",referencedColumnName = "student_id"
    )
    private Student student;

    @ManyToOne(targetEntity = Room.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name="room_type_id",referencedColumnName = "room_type_id"
    )
    private Room room;

    @Column(name="status",columnDefinition = "VARCHAR(255)")
    private String status;

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", student=" + student +
                ", room=" + room +
                ", status='" + status + '\'' +
                '}';
    }
}
