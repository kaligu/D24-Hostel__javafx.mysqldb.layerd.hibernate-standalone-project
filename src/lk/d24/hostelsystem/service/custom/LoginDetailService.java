/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/13/2023
  @ Time         : 12:08 PM
*/
package lk.d24.hostelsystem.service.custom;

import lk.d24.hostelsystem.dto.LoginDetailDTO;
import lk.d24.hostelsystem.dto.RoomDTO;

public interface LoginDetailService {
    LoginDetailDTO findByPk(String pk);

    boolean update(LoginDetailDTO loginDetailDTO);
}
