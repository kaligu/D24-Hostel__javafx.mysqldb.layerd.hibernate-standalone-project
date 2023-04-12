/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 8:06 AM
*/
package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.ReserveService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Reservedetail_form_controller {
    public TableView tvlviewallReservations;
    public TableColumn colReservationID;
    public TableColumn colRoomTypeID;
    public TableColumn colStudentID;
    public TableColumn colReserveExpireDate;
    public TableColumn colResStatusAndCreatedDate;
    public AnchorPane panefullLoading;
    public TableView tvlviewallReservationsactive;
    public TableColumn colReservationIDactive;
    public TableColumn colRoomTypeIDactive;
    public TableColumn colStudentIDactive;
    public TableColumn colReserveExpireDateactive;
    public TableColumn colResStatusAndCreatedDateactive;
    public TableView tvlviewallReservationsnotpaid;
    public TableColumn colReservationIDnotpaid;
    public TableColumn colRoomTypeIDnotpaid;
    public TableColumn colStudentIDnotpaid;
    public TableColumn colReserveExpireDatenotpaid;
    public TableColumn colResStatusAndCreatedDatenotpaid;
    public TableView tvlviewallReservationsnotpaidedit;
    public TableColumn colReservationIDnotpaidedit;
    public TableColumn colRoomTypeIDnotpaidedit;
    public TableColumn colStudentIDnotpaidedit;
    public TableColumn colReserveExpireDatenotpaidedit;
    public TableColumn colResStatusAndCreatedDatenotpaidedit;
    public JFXDatePicker txtfldperiodDate;
    public JFXTextField txtfldKeymoney;
    ReserveService reserveService;
    List<ReserveDTO> reserveDTOSforEdit;
    public void initialize(){
        reserveDTOSforEdit = new ArrayList<>();
        reserveService= ServiceFactory.getInstance().getService(ServiceTypes.RESERVE);
       // searchAllIds();

        colReservationID.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colRoomTypeID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colReserveExpireDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colResStatusAndCreatedDate.setCellValueFactory(new PropertyValueFactory<>("status"));

        colReservationIDactive.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colRoomTypeIDactive.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colStudentIDactive.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colReserveExpireDateactive.setCellValueFactory(new PropertyValueFactory<>("date"));
        colResStatusAndCreatedDateactive.setCellValueFactory(new PropertyValueFactory<>("status"));

        colReservationIDnotpaid.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colRoomTypeIDnotpaid.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colStudentIDnotpaid.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colReserveExpireDatenotpaid.setCellValueFactory(new PropertyValueFactory<>("date"));
        colResStatusAndCreatedDatenotpaid.setCellValueFactory(new PropertyValueFactory<>("status"));

        colReservationIDnotpaidedit.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colRoomTypeIDnotpaidedit.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colStudentIDnotpaidedit.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colReserveExpireDatenotpaidedit.setCellValueFactory(new PropertyValueFactory<>("date"));
        colResStatusAndCreatedDatenotpaidedit.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void searchAllIds() {
       // List<String> studentIdlist;
       // ObservableList<String> studentIdsList = FXCollections.observableArrayList();

      //  studentIdlist = reserveService.(searchText);

     //   roomDTOObservableList.addAll(roomDTOList);

      //  tblRoom.setItems(roomDTOObservableList);
    }

    public void actionMouseClickednavCircle1(MouseEvent mouseEvent) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                ObservableList<ReserveDTO> reserveDTOObservableList = FXCollections.observableArrayList();
                reserveDTOSforEdit = reserveService.viewActiveReservations();
                reserveDTOObservableList.setAll(reserveDTOSforEdit);
                tvlviewallReservationsnotpaidedit.setItems(reserveDTOObservableList);

                panefullLoading.setVisible(false);

            }
        });
        thread.start();
    }

    public void actionMouseClickednavCircle2(MouseEvent mouseEvent) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                List<ReserveDTO> reserveDTOS = new ArrayList<>();
                ObservableList<ReserveDTO> reserveDTOObservableList = FXCollections.observableArrayList();
                reserveDTOS = reserveService.viewNotpaidReservations();
                reserveDTOObservableList.setAll(reserveDTOS);
                tvlviewallReservationsnotpaid.setItems(reserveDTOObservableList);

                panefullLoading.setVisible(false);

            }
        });
        thread.start();
    }

    public void actionMouseClickednavCircle3(MouseEvent mouseEvent) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                List<ReserveDTO> reserveDTOS = new ArrayList<>();
                ObservableList<ReserveDTO> reserveDTOObservableList = FXCollections.observableArrayList();
                reserveDTOS = reserveService.viewActiveReservations();
                reserveDTOObservableList.setAll(reserveDTOS);
                tvlviewallReservationsactive.setItems(reserveDTOObservableList);

                panefullLoading.setVisible(false);

            }
        });
        thread.start();
    }

    public void actionMouseEnterednavCircle1(MouseEvent mouseEvent) {
    }

    public void actionMouseExitednavCircle1(MouseEvent mouseEvent) {
    }

    public void actionMouseEnterednavCircle2(MouseEvent mouseEvent) {
    }

    public void actionMouseExitednavCircle2(MouseEvent mouseEvent) {
    }

    public void actionMouseEnterednavCircle3(MouseEvent mouseEvent) {
    }

    public void actionMouseExitednavCircle3(MouseEvent mouseEvent) {
    }

    public void actionMouseExitednavCircle4(MouseEvent mouseEvent) {
    }

    public void actionMouseEnterednavCircle4(MouseEvent mouseEvent) {
    }

    public void actionMouseClickednavCircle4(MouseEvent mouseEvent) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                List<ReserveDTO> reserveDTOS = new ArrayList<>();
                ObservableList<ReserveDTO> reserveDTOObservableList = FXCollections.observableArrayList();
                reserveDTOS = reserveService.viewAllReservations();
                reserveDTOObservableList.setAll(reserveDTOS);
                tvlviewallReservations.setItems(reserveDTOObservableList);

                panefullLoading.setVisible(false);

            }
        });
        thread.start();
    }

    public void clickedbtncreateReservation(ActionEvent actionEvent) {
    }

    public void clickedActionEditReservationtbl(MouseEvent mouseEvent) {
        String statusText = reserveDTOSforEdit.get(tvlviewallReservationsnotpaidedit.getSelectionModel().getSelectedIndex()).getStatus();
        String[] strArray = statusText.split(",");
        String[] strArray2 = strArray[0].split(":");
        //strArray2[1] = "not paid";  //split text to get status

        String[] strArray1 = statusText.split(",");
        String[] strArray12 = strArray[1].split(":");
        //strArray12[1] = "2020-02-02"; //split text to get status

        txtfldperiodDate.setValue(LocalDate.parse(strArray12[1]));
        txtfldKeymoney.setText(strArray2[1]);
       // String finalText = "Status:"+txtfldKeymoney.getText()+" , Reserved Date:"+localDate;
    }
}
