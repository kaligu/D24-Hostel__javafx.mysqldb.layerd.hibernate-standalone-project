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
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.RoomService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    RoomService roomService;

    public void initialize(){
        roomService= ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
        clearAllPanes(); //clear all panes

        colroomid1.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colroomtype1.setCellValueFactory(new PropertyValueFactory<>("type"));
        colroomkeymoney1.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colroomqty.setCellValueFactory(new PropertyValueFactory<>("qty"));


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
        txtDay.setText(String.valueOf(d.getDay()));

        loadAllRooms();
    }

    private void loadAllRooms(){
        Thread threadTableRun = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                ObservableList<RoomDTO> roomDTOObservableList = FXCollections.observableArrayList();

                List<RoomDTO> roomDTOList = roomService.getAllRooms();
                txtallRooms.setText(String.valueOf(roomService.getAllRoomCount()));

                roomDTOObservableList.addAll(roomDTOList);

                tbl1.setItems(roomDTOObservableList);
                panefullLoading.setVisible(false);
            }
        });
        threadTableRun.start();
    }

    private void clearAllPanes(){ //clear all panes
        paneallroom.setVisible(false);
        paneavailablerooms.setVisible(false);
        panelreservedrooms.setVisible(false);
        panenotpaidrooms.setVisible(false);
        paneroomexpiretoday.setVisible(false);
        box1.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box2.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box3.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box4.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box5.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
    }

    public void actionMouseClickednavbox1(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneallroom.setVisible(true);
        box1.setVisible(true);
        box1.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
        loadAllRooms();
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

    public void actionMouseClickednavbox2(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        panelreservedrooms.setVisible(true);
        box2.setVisible(true);
        box2.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    public void actionMouseEnterednavbox2(MouseEvent mouseEvent) {
        if(!panelreservedrooms.isVisible()) {
            box2.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox2(MouseEvent mouseEvent) {
        if(!panelreservedrooms.isVisible()) {
            box2.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox3(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneavailablerooms.setVisible(true);
        box3.setVisible(true);
        box3.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
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
