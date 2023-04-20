/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 8:06 AM
*/
package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.ReserveService;
import lk.d24.hostelsystem.view.custom.Validatetxtfld;
import lk.d24.hostelsystem.view.custom.impl.ValidatetxtfldImpl;
import lombok.SneakyThrows;

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
    public Circle navCircle1;
    public Circle navCircle2;
    public Circle navCircle3;
    public Circle navCircle4;
    public AnchorPane paneViewAll;
    public AnchorPane paneAvailableRooms;
    public AnchorPane paneNotpaid;
    public AnchorPane paneeditstatus;
    public Text txtpaidnotpaid;
    public Text txttimePeriod;
    ReserveService reserveService;
    List<ReserveDTO> reserveDTOSforEdit;
    Validatetxtfld validatetxtfld;
    
    public void initialize(){
        //block past days in date picker
        txtfldperiodDate.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0);
            }
        });
        validatetxtfld=new ValidatetxtfldImpl();
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

        loadFirstPane();
    }

    public void actionMouseClickednavCircle1(MouseEvent mouseEvent) {
        loadFirstPane();
    }

    private void loadFirstPane(){
        clearAllPanes();
        navCircle1.setStroke(Paint.valueOf("#027a6c"));
        navCircle1.setFill(Paint.valueOf("#027a6c"));
        loadEditTbl();
    }

    private void loadEditTbl(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                reserveDTOSforEdit.clear();
                tvlviewallReservationsnotpaidedit.getItems().clear();
                ObservableList<ReserveDTO> reserveDTOObservableList = FXCollections.observableArrayList();
                reserveDTOSforEdit = reserveService.viewActiveReservations();
                reserveDTOObservableList.setAll(reserveDTOSforEdit);
                tvlviewallReservationsnotpaidedit.setItems(reserveDTOObservableList);

                paneeditstatus.setVisible(true);

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

                clearAllPanes();
                paneNotpaid.setVisible(true);
                navCircle2.setStroke(Paint.valueOf("#027a6c"));
                navCircle2.setFill(Paint.valueOf("#027a6c"));
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

                clearAllPanes();
                paneAvailableRooms.setVisible(true);
                navCircle3.setStroke(Paint.valueOf("#027a6c"));
                navCircle3.setFill(Paint.valueOf("#027a6c"));

                panefullLoading.setVisible(false);

            }
        });
        thread.start();
    }
    private void clearAllPanes(){ //clear all panes
        paneeditstatus.setVisible(false);
        paneViewAll.setVisible(false);
        paneNotpaid.setVisible(false);
        paneAvailableRooms.setVisible(false);
        navCircle1.setStroke(Paint.valueOf("#ffffff"));
        navCircle1.setFill(Paint.valueOf("#ffffff"));
        navCircle2.setStroke(Paint.valueOf("#ffffff"));
        navCircle2.setFill(Paint.valueOf("#ffffff"));
        navCircle3.setStroke(Paint.valueOf("#ffffff"));
        navCircle3.setFill(Paint.valueOf("#ffffff"));
        navCircle4.setStroke(Paint.valueOf("#ffffff"));
        navCircle4.setFill(Paint.valueOf("#ffffff"));
    }

    public void actionMouseEnterednavCircle1(MouseEvent mouseEvent) {
        if(!paneeditstatus.isVisible()) {
            navCircle1.setStroke(Paint.valueOf("#6be8d9"));
            navCircle1.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle1(MouseEvent mouseEvent) {
        if(!paneeditstatus.isVisible()) {
            navCircle1.setStroke(Paint.valueOf("#ffffff"));
            navCircle1.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseEnterednavCircle2(MouseEvent mouseEvent) {
        if(!paneNotpaid.isVisible()) {
            navCircle2.setStroke(Paint.valueOf("#6be8d9"));
            navCircle2.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle2(MouseEvent mouseEvent) {
        if(!paneNotpaid.isVisible()) {
            navCircle2.setStroke(Paint.valueOf("#ffffff"));
            navCircle2.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseEnterednavCircle3(MouseEvent mouseEvent) {
        if(!paneAvailableRooms.isVisible()) {
            navCircle3.setStroke(Paint.valueOf("#6be8d9"));
            navCircle3.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle3(MouseEvent mouseEvent) {
        if(!paneAvailableRooms.isVisible()) {
            navCircle3.setStroke(Paint.valueOf("#ffffff"));
            navCircle3.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseExitednavCircle4(MouseEvent mouseEvent) {
        if(!paneViewAll.isVisible()) {
            navCircle4.setStroke(Paint.valueOf("#ffffff"));
            navCircle4.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseEnterednavCircle4(MouseEvent mouseEvent) {
        if(!paneViewAll.isVisible()) {
            navCircle4.setStroke(Paint.valueOf("#6be8d9"));
            navCircle4.setFill(Paint.valueOf("#6be8d9"));
        }
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

                clearAllPanes();
                paneViewAll.setVisible(true);
                navCircle4.setStroke(Paint.valueOf("#027a6c"));
                navCircle4.setFill(Paint.valueOf("#027a6c"));

                panefullLoading.setVisible(false);

            }
        });
        thread.start();
    }
    
    public void clickedActionEditReservationtbl(MouseEvent mouseEvent) {
        String statusText = reserveDTOSforEdit.get(tvlviewallReservationsnotpaidedit.getSelectionModel().getSelectedIndex()).getStatus();
        String[] strArray = statusText.split(",");
        String[] strArray2 = strArray[0].split(":");
        //strArray2[1] = "not paid";  //split text to get status

        String[] strArray1 = statusText.split(",");
        String[] strArray12 = strArray[1].split(":");
        //strArray12[1] = "2020-02-02"; //split text to get status

        txtfldperiodDate.setValue(reserveDTOSforEdit.get(tvlviewallReservationsnotpaidedit.getSelectionModel().getSelectedIndex()).getDate());
        txtfldKeymoney.setText(strArray2[1]);
    }

    public void clickedbtnupdateReservation(ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Reservation Updating Information");
        alert1.setContentText("This reservation updated Ssuccessfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Reservation Updating Information");
        alert2.setContentText("This reservation Updated not successfully!");

        //persist data using thread
        Thread threadAdd =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length

                ReserveDTO reserveDTO = new ReserveDTO(
                        reserveDTOSforEdit.get(tvlviewallReservationsnotpaidedit.getSelectionModel().getSelectedIndex()).getRes_id(),
                        txtfldperiodDate.getValue(),
                        reserveDTOSforEdit.get(tvlviewallReservationsnotpaidedit.getSelectionModel().getSelectedIndex()).getStudentID(),
                        reserveDTOSforEdit.get(tvlviewallReservationsnotpaidedit.getSelectionModel().getSelectedIndex()).getRoomID(),
                        "Status:"+txtfldKeymoney.getText()+" ,Reserved Date:"+txtfldperiodDate.getEditor().getText()
                );
                if(reserveService.update(reserveDTO)){
                    clearAllPanetxtflds();
                    panefullLoading.setVisible(false); //after task completed hide loading pane
                    loadEditTbl();
                    Platform.runLater(() ->
                            alert1.show()
                    );
                }else{
                    Platform.runLater(() ->
                            alert2.show()
                    );
                    panefullLoading.setVisible(false); //after task completed hide loading pane
                }
            }
        });
        if(validatetxtfld.validateTxtfldPaidNotPaid(txtfldKeymoney,txtpaidnotpaid)&
                validatetxtfld.validateTxtfldTimePeiod(txtfldperiodDate,txttimePeriod)){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Reservation Updating Confirmation");
            alert.setContentText("Are you sure to want you to update this Reservation?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    threadAdd.start();  //start thread
                }
            });
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid data entered!");
            alert.setContentText("You have entered invalid data.Please retype and try again. ");
            alert.show();
        }
    }
    private void clearAllPanetxtflds() {
        txtfldKeymoney.clear();
        txtfldperiodDate.getEditor().clear();
    }
}
