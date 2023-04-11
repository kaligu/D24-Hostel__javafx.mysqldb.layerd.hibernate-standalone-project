/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 8:06 AM
*/
package lk.d24.hostelsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.ReserveService;

import java.util.List;



public class Reservedetail_form_controller {
    ReserveService reserveService;
    public void initialize(){
        reserveService= ServiceFactory.getInstance().getService(ServiceTypes.RESERVE);
        searchAllIds();
    }

    private void searchAllIds() {
        List<String> studentIdlist;
        ObservableList<String> studentIdsList = FXCollections.observableArrayList();

      //  studentIdlist = reserveService.(searchText);

     //   roomDTOObservableList.addAll(roomDTOList);

      //  tblRoom.setItems(roomDTOObservableList);
    }
}
