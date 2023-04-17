/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 11:00 AM
*/
package lk.d24.hostelsystem.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.d24.hostelsystem.dto.ReservationDTO;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.qaRoomDTO;
import lk.d24.hostelsystem.entity.Reservation;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.QueryService;
import lk.d24.hostelsystem.service.custom.ReserveService;
import lk.d24.hostelsystem.service.custom.RoomService;
import lk.d24.hostelsystem.view.tm.PaidReservationsTM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Home_form_controller {
    public AnchorPane box1;
    public AnchorPane box2;
    public AnchorPane box3;
    public AnchorPane box4;
    public AnchorPane box5;
    public AnchorPane paneroomexpiretoday;
    public AnchorPane panenotpaidrooms;
    public AnchorPane paneavailablerooms;
    public AnchorPane panelreservedrooms;
    public AnchorPane paneallroom;
    public Text txtDate;
    public Text txtDay;
    public Text txttime;
    public TableView tbl1;
    public TableColumn colroomid1;
    public TableColumn colroomtype1;
    public TableColumn colroomkeymoney1;
    public TableColumn colroomqty;
    public AnchorPane panefullLoading;
    public Text txtallRooms;
    public TableView tbl13;
    public TableColumn colroomid3;
    public TableColumn colroomtype3;
    public TableColumn colroomkeymoney3;
    public TableColumn colroomqty3;
    public TableColumn colstatus4;
    public TableColumn colid4;
    public TableColumn colexpiredate4;
    public TableColumn colresid4;
    public TableColumn colresname4;
    public TableColumn colresadress4;
    public TableColumn colrescontact4;
    public TableColumn colresdob4;
    public TableColumn colresgender4;
    public TableColumn colroomid4;
    public TableColumn colroomtype4;
    public TableColumn colroomkeymoney4;
    public TableColumn colroomqty4;
    public TableColumn colid5;
    public TableColumn colexpiredate5;
    public TableColumn colstatus5;
    public TableColumn colresid5;
    public TableColumn colresname5;
    public TableColumn colresadress5;
    public TableColumn colrescontact5;
    public TableColumn colresdob5;
    public TableColumn colresgender5;
    public TableColumn colroomid5;
    public TableColumn colroomtype5;
    public TableColumn colroomkeymoney5;
    public TableColumn colroomqty5;
    public TableView tb4;
    public TableView tb5;
    public Text txtAvailbaleRooms;
    public Text txtNotPaidrooms;
    public Text txtRoomExpireCount;

    RoomService roomService;

    ReserveService reserveService;

    QueryService queryService;

    public void initialize(){
        queryService = ServiceFactory.getInstance().getService(ServiceTypes.QUERY);
        roomService= ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
        reserveService= ServiceFactory.getInstance().getService(ServiceTypes.RESERVE);
        clearAllPanes(); //clear all panes

        colroomid1.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colroomtype1.setCellValueFactory(new PropertyValueFactory<>("type"));
        colroomkeymoney1.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colroomqty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        colroomid3.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colroomtype3.setCellValueFactory(new PropertyValueFactory<>("type"));
        colroomkeymoney3.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colroomqty3.setCellValueFactory(new PropertyValueFactory<>("availableRoomsQty"));

        colid4.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colexpiredate4.setCellValueFactory(new PropertyValueFactory<>("date"));
        colstatus4.setCellValueFactory(new PropertyValueFactory<>("status"));
        colresid4.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colresname4.setCellValueFactory(new PropertyValueFactory<>("name"));
        colresadress4.setCellValueFactory(new PropertyValueFactory<>("address"));
        colrescontact4.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colresdob4.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colresgender4.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colroomid4.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colroomtype4.setCellValueFactory(new PropertyValueFactory<>("type"));
        colroomkeymoney4.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colroomqty4.setCellValueFactory(new PropertyValueFactory<>("qty"));

        colid5.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colexpiredate5.setCellValueFactory(new PropertyValueFactory<>("date"));
        colstatus5.setCellValueFactory(new PropertyValueFactory<>("status"));
        colresid5.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colresname5.setCellValueFactory(new PropertyValueFactory<>("name"));
        colresadress5.setCellValueFactory(new PropertyValueFactory<>("address"));
        colrescontact5.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colresdob5.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colresgender5.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colroomid5.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colroomtype5.setCellValueFactory(new PropertyValueFactory<>("type"));
        colroomkeymoney5.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colroomqty5.setCellValueFactory(new PropertyValueFactory<>("qty"));

        //settime
        // setTime
        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e->{
                    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm:ss");
                    txttime.setText(LocalDateTime.now().format(formatter));
                }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

        paneallroom.setVisible(true);  //load search pane
        box1.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
        //settmonth
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        txtDate.setText(month);
        //set date
        Date d = new Date();
        txtDay.setText("23");

        loadAllWidgets();
    }

    private void loadAllWidgets(){
        Thread threadTableRun = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                ObservableList<RoomDTO> roomDTOObservableList = FXCollections.observableArrayList();  //load all room table data
                List<RoomDTO> roomDTOList = roomService.getAllRooms();
                roomDTOObservableList.addAll(roomDTOList);
                tbl1.setItems(roomDTOObservableList);

                //load available room count
                int countAllRooms=0;
                for(RoomDTO roomDTO:roomDTOList){
                    countAllRooms+=roomDTO.getQty();
                }
                txtallRooms.setText(String.valueOf(countAllRooms));

                ObservableList<qaRoomDTO> qaRoomDTOObservableList = FXCollections.observableArrayList();  //load available room table data
                List<qaRoomDTO> qaRoomDTOS = queryService.findAllAvailableRooms();
                qaRoomDTOObservableList.addAll(qaRoomDTOS);
                tbl13.setItems(qaRoomDTOObservableList);

                //load available room count
                int countAvailbleRooms=0;
                for(qaRoomDTO qaRoomDT:qaRoomDTOS){
                    countAvailbleRooms+=qaRoomDT.getAvailableRoomsQty();
                }
                txtAvailbaleRooms.setText(String.valueOf(countAvailbleRooms));

                //load not paid rooms to table
                ObservableList<PaidReservationsTM> dtoObservableList = FXCollections.observableArrayList();
                List<PaidReservationsTM> paidReservationsTMS=new ArrayList<>();
                for(ReservationDTO reservationDTO:reserveService.viewAllNotpaidReservationsStRoom()){
                    paidReservationsTMS.add(new PaidReservationsTM(
                            reservationDTO.getRes_id(),
                            reservationDTO.getDate(),
                            reservationDTO.getStatus(),
                            reservationDTO.getStudent().getStudent_id(),
                            reservationDTO.getStudent().getName(),
                            reservationDTO.getStudent().getAddress(),
                            reservationDTO.getStudent().getContact_no(),
                            reservationDTO.getStudent().getDob(),
                            reservationDTO.getStudent().getGender(),
                            reservationDTO.getRoom().getRoom_type_id(),
                            reservationDTO.getRoom().getType(),
                            reservationDTO.getRoom().getKey_money(),
                            1
                    ));
                }
                dtoObservableList.addAll(paidReservationsTMS);
                tb4.setItems(dtoObservableList);

                //load notpaid room count
                int countNotPaidRooms=0;
                for(PaidReservationsTM paidReservationsTMm:paidReservationsTMS){
                    countNotPaidRooms+=1;
                }
                txtNotPaidrooms.setText(String.valueOf(countNotPaidRooms));

                //load reservation expire table
                ObservableList<PaidReservationsTM> dtoObservableList2 = FXCollections.observableArrayList();
                List<PaidReservationsTM> paidReservationsTMS2=new ArrayList<>();
                for(ReservationDTO reservationDTO2:reserveService.findAllRoomExpireTodayReservations()){
                    paidReservationsTMS2.add(new PaidReservationsTM(
                            reservationDTO2.getRes_id(),
                            reservationDTO2.getDate(),
                            reservationDTO2.getStatus(),
                            reservationDTO2.getStudent().getStudent_id(),
                            reservationDTO2.getStudent().getName(),
                            reservationDTO2.getStudent().getAddress(),
                            reservationDTO2.getStudent().getContact_no(),
                            reservationDTO2.getStudent().getDob(),
                            reservationDTO2.getStudent().getGender(),
                            reservationDTO2.getRoom().getRoom_type_id(),
                            reservationDTO2.getRoom().getType(),
                            reservationDTO2.getRoom().getKey_money(),
                            1
                    ));
                }
                dtoObservableList2.addAll(paidReservationsTMS2);
                tb5.setItems(dtoObservableList2);

                //load expire room count
                int countExpireRooms=0;
                for(PaidReservationsTM paidReservationsTMm2:paidReservationsTMS2){
                    countExpireRooms+=1;
                }
                txtRoomExpireCount.setText(String.valueOf(countExpireRooms));


                panefullLoading.setVisible(false);
            }
        });
        threadTableRun.start();
    }

    private void clearAllPanes(){ //clear all panes
        paneallroom.setVisible(false);
        paneavailablerooms.setVisible(false);
        panenotpaidrooms.setVisible(false);
        paneroomexpiretoday.setVisible(false);
        box1.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box3.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box4.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box5.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
    }

    public void actionMouseClickednavbox1(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneallroom.setVisible(true);
        box1.setVisible(true);
        box1.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
        loadAllWidgets();
    }

    public void actionMouseEnterednavbox1(MouseEvent mouseEvent) {
        if(!paneallroom.isVisible()) {
            box1.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox1(MouseEvent mouseEvent) {
        if(!paneallroom.isVisible()) {
            box1.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox3(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneavailablerooms.setVisible(true);
        box3.setVisible(true);
        box3.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
        loadAllWidgets(); //load table data
    }

    public void actionMouseEnterednavbox3(MouseEvent mouseEvent) {
        if(!paneavailablerooms.isVisible()) {
            box3.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox3(MouseEvent mouseEvent) {
        if(!paneavailablerooms.isVisible()) {
            box3.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox4(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        panenotpaidrooms.setVisible(true);
        box4.setVisible(true);
        box4.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
        loadAllWidgets(); //load table data
    }

    public void actionMouseEnterednavbox4(MouseEvent mouseEvent) {
        if(!panenotpaidrooms.isVisible()) {
           box4.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox4(MouseEvent mouseEvent) {
        if(!panenotpaidrooms.isVisible()) {
            box4.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox5(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneroomexpiretoday.setVisible(true);
        box5.setVisible(true);
        box5.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
        loadAllWidgets();
    }

    public void actionMouseEnterednavbox5(MouseEvent mouseEvent) {
        if(!paneroomexpiretoday.isVisible()) {
            box5.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox5(MouseEvent mouseEvent) {
        if(!paneroomexpiretoday.isVisible()) {
            box5.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }
}
