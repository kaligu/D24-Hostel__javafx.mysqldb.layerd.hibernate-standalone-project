/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/6/2023
  @ Time         : 9:53 AM
*/
package lk.d24.hostelsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="Room")
public class Room implements SuperEntity, Serializable {
    @Id
    @Column(name="room_type_id",columnDefinition = "VARCHAR(255)")
    private String room_type_id;

    @Column(name="type",columnDefinition = "VARCHAR(255)")
    private String type;

    @Column(name="key_money",columnDefinition = "VARCHAR(255)")
    private double key_money;

    @Column(name="qty",columnDefinition = "INT")
    private int qty;

    @OneToMany(mappedBy = "room", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservationList= new ArrayList<>();

    public Room(String room_type_id, String type, double key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public Room(String roomTypeId, String type, Double keyMoney, Integer availableRoomsQty) {
    }


    @Override
    public String toString() {
        return "Room{" +
                "room_type_id='" + room_type_id + '\'' +
                ", type='" + type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                ", reservationList=" + reservationList +
                '}';
    }
}
