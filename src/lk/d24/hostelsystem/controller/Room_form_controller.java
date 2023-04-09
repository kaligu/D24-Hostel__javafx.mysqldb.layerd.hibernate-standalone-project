/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 1:48 AM
*/
package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.RoomService;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Room_form_controller {
    public Circle navCircle1;
    public Circle navCircle2;
    public Circle navCircle3;
    public Circle navCircle4;
    public AnchorPane paneSearch;
    public AnchorPane paneAdd;
    public AnchorPane paneRemove;
    public AnchorPane paneUpdate;
    public TableView tblRoom;
    public TableColumn collRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomsqty;
    public JFXTextField txtfldRoomTypeIdType;
    public JFXTextField txtfldAddRoomTypeID;
    public JFXTextField txtfldAddtype;
    public JFXTextField txtfldAddKeyMoney;
    public JFXTextField txtfldAddqty;
    public AnchorPane panefullLoading;

    RoomService roomService;

    List<RoomDTO> roomDTOList;

    private String searchText;


    public void initialize(){
        roomService= ServiceFactory.getInstance().getService(ServiceTypes.ROOM);

        roomDTOList=new ArrayList<>();

        searchText="";

        clearAllPanes(); //clear all panes

        collRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colRoomsqty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        searchRooms(searchText);

        paneSearch.setVisible(true);  //load search pane
        navCircle1.setStroke(Paint.valueOf("#027a6c"));
        navCircle1.setFill(Paint.valueOf("#027a6c"));
    }

    private void searchRooms(String searchText){
        Thread threadTableRun = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);
                tblRoom.getItems().clear();
                roomDTOList.clear();

                ObservableList<RoomDTO> roomDTOObservableList = FXCollections.observableArrayList();

                roomDTOList = roomService.searchRoomByText(searchText);

                roomDTOObservableList.addAll(roomDTOList);

                tblRoom.setItems(roomDTOObservableList);
                panefullLoading.setVisible(false);
            }
        });
        threadTableRun.start();

    }

    private void clearAllPanes(){ //clear all panes
        paneSearch.setVisible(false);
        paneAdd.setVisible(false);
        paneRemove.setVisible(false);
        paneUpdate.setVisible(false);
        navCircle1.setStroke(Paint.valueOf("#ffffff"));
        navCircle1.setFill(Paint.valueOf("#ffffff"));
        navCircle2.setStroke(Paint.valueOf("#ffffff"));
        navCircle2.setFill(Paint.valueOf("#ffffff"));
        navCircle3.setStroke(Paint.valueOf("#ffffff"));
        navCircle3.setFill(Paint.valueOf("#ffffff"));
        navCircle4.setStroke(Paint.valueOf("#ffffff"));
        navCircle4.setFill(Paint.valueOf("#ffffff"));
    }

    public void actionMouseClickednavCircle1(MouseEvent mouseEvent) {
        clearAllPanes();
        paneSearch.setVisible(true);
        navCircle1.setStroke(Paint.valueOf("#027a6c"));
        navCircle1.setFill(Paint.valueOf("#027a6c"));
    }

    public void actionMouseClickednavCircle2(MouseEvent mouseEvent) {
        clearAllPanes();
        paneAdd.setVisible(true);
        navCircle2.setStroke(Paint.valueOf("#027a6c"));
        navCircle2.setFill(Paint.valueOf("#027a6c"));
    }

    public void actionMouseClickednavCircle3(MouseEvent mouseEvent) {
        clearAllPanes();
        paneUpdate.setVisible(true);
        navCircle3.setStroke(Paint.valueOf("#027a6c"));
        navCircle3.setFill(Paint.valueOf("#027a6c"));
    }

    public void actionMouseClickednavCircle4(MouseEvent mouseEvent) {
        clearAllPanes();
        paneRemove.setVisible(true);
        navCircle4.setStroke(Paint.valueOf("#027a6c"));
        navCircle4.setFill(Paint.valueOf("#027a6c"));
    }

    public void actionMouseEnterednavCircle1(MouseEvent mouseEvent) {
        if(!paneSearch.isVisible()) {
            navCircle1.setStroke(Paint.valueOf("#6be8d9"));
            navCircle1.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle1(MouseEvent mouseEvent) {
        if(!paneSearch.isVisible()) {
            navCircle1.setStroke(Paint.valueOf("#ffffff"));
            navCircle1.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseEnterednavCircle2(MouseEvent mouseEvent) {
        if(!paneAdd.isVisible()) {
            navCircle2.setStroke(Paint.valueOf("#6be8d9"));
            navCircle2.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle2(MouseEvent mouseEvent) {
        if(!paneAdd.isVisible()) {
            navCircle2.setStroke(Paint.valueOf("#ffffff"));
            navCircle2.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseEnterednavCircle3(MouseEvent mouseEvent) {
        if(!paneUpdate.isVisible()) {
            navCircle3.setStroke(Paint.valueOf("#6be8d9"));
            navCircle3.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle3(MouseEvent mouseEvent) {
        if(!paneUpdate.isVisible()) {
            navCircle3.setStroke(Paint.valueOf("#ffffff"));
            navCircle3.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionMouseEnterednavCircle4(MouseEvent mouseEvent) {
        if(!paneRemove.isVisible()) {
            navCircle4.setStroke(Paint.valueOf("#6be8d9"));
            navCircle4.setFill(Paint.valueOf("#6be8d9"));
        }
    }

    public void actionMouseExitednavCircle4(MouseEvent mouseEvent) {
        if(!paneRemove.isVisible()) {
            navCircle4.setStroke(Paint.valueOf("#ffffff"));
            navCircle4.setFill(Paint.valueOf("#ffffff"));
        }
    }

    public void actionKeyReleasedSearchRoomByIdandType(KeyEvent keyEvent) {
    }

    public void ClickedAddRoom(ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Room Adding Information");
        alert1.setContentText("This Room added successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Room Adding Information");
        alert2.setContentText("This Room added not successfully!");

        RoomDTO roomDTO = new RoomDTO(
                txtfldAddRoomTypeID.getText(),
                txtfldAddtype.getText(),
                txtfldAddKeyMoney.getText(),
                Integer.parseInt(txtfldAddqty.getText())
        );

        //persist data using thread
        Thread threadAdd =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length
                ;

                if(roomService.saveRoom(roomDTO)){
                    Platform.runLater(() ->
                            alert1.show()
                    );
                    ClearAllAddPanetxtflds();
                    panefullLoading.setVisible(false); //after task completed hide loading pane
                }else{
                    Platform.runLater(() ->
                            alert2.show()
                    );
                    panefullLoading.setVisible(false); //after task completed hide loading pane
                }
            }
        });
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Room Adding Confirmation");
        alert.setContentText("Are you sure to want you to add this room?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                threadAdd.start();  //start thread
            }
        });

    }

    private void ClearAllAddPanetxtflds() {
        txtfldAddRoomTypeID.clear();
        txtfldAddtype.clear();
        txtfldAddqty.clear();
        txtfldAddKeyMoney.clear();
    }
}
