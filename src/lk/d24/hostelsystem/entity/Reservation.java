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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="Reservation")
public class Reservation implements SuperEntity, Serializable {
    @Id
    @Column(name="res_id",columnDefinition = "VARCHAR(255)")
    private String res_id;

    @Column(name="date",columnDefinition = "DATE")
    private LocalDate date;

    @ManyToOne()
    @JoinColumn(
            name="student_id",referencedColumnName = "student_id"
    )
    private Student student;

    public Reservation() {
    }

    public Reservation(String res_id, Student student, Room room) {
        this.res_id = res_id;
        this.student = student;
        this.room = room;
    }

    @ManyToOne()
    @JoinColumn(
            name="room_type_id",referencedColumnName = "room_type_id"
    )
    private Room room;

    @Column(name="status",columnDefinition = "VARCHAR(255)")
    private String status;
}
