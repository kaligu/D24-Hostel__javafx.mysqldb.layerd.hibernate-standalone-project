/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 8:39 AM
*/
package lk.d24.hostelsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="Student")
@Table(name="Student")
public class Student implements SuperEntity, Serializable {
    @Id
    @Column(name="student_id",columnDefinition = "VARCHAR(255)")
    private String student_id;

    @Column(name="name",columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name="address",columnDefinition = "TEXT")
    private String address;

    @Column(name="contact_no",columnDefinition = "VARCHAR(255)")
    private String contact_no;

    @Column(name="dob",columnDefinition = "DATE")
    private LocalDate dob;

    @Column(name="gender",columnDefinition = "VARCHAR(255)")
    private String gender;

    @OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Reservation> reservationList= new ArrayList<>();

    public Student() {
    }

    public Student(String student_id, String name, String address, String contact_no, String gender) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", reservationList=" + reservationList +
                '}';
    }
}
