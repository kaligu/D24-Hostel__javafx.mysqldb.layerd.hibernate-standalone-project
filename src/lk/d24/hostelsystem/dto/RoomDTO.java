/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 4:01 PM
*/
package lk.d24.hostelsystem.dto;

import lk.d24.hostelsystem.entity.Reservation;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDTO {
    private String room_type_id;

    private String type;

    private double key_money;

    private int qty;

    private List<Reservation> reservationList= new ArrayList<>();

    public RoomDTO(String room_type_id, String type, double key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }
}
