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
import javafx.scene.text.Text;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.RoomService;
import lk.d24.hostelsystem.view.custom.Validatetxtfld;
import lk.d24.hostelsystem.view.custom.impl.ValidatetxtfldImpl;
import lombok.SneakyThrows;

import java.time.LocalDate;
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
    public JFXTextField txtfldUpdateRoomTypeId;
    public JFXTextField txtfldUpdateRoomType;
    public JFXTextField txtfldUpdateKeyMoney;
    public JFXTextField txtfldUpdateRoomqty;
    public Text txthinttxtfldUpdateRoomTypeId;
    public Text txhinttxtfldUpdateRoomType;
    public Text txhinttxtfldUpdateRoomqty;
    public Text txhinttxtfldUpdateKeyMoney;
    public JFXTextField txtfldAddRoomtype;
    public JFXTextField txtfldAddRoomqty;
    public Text txthinttxtfldAddRoomTypeId;
    public Text txhinttxtfldAddRoomType;
    public Text txhinttxtfldUpdateRoomqty1;
    public Text txhinttxtfldAddKeyMoney;
    public Text txtfldSearchRoomTypeID;
    public Text txtfldSearchRoomType;
    public Text txtfldSearchRoomqty;
    public Text txtfldSearchroomkeymoney;
    public Text txtfldRemoveRoomTypeID;
    public Text txtfldRemoveRoomType;
    public Text txtfldRemoveRoomqty;
    public Text txtfldRemoveroomkeymoney;
    public JFXTextField txtfldUpdateRoomTypeID;
    public JFXTextField txtfldUpdateroomkeymoney;

    boolean isValidatingOnAdd;
    boolean isValidatingOnUpdate;

    RoomService roomService;

    List<RoomDTO> roomDTOList;

    private String searchText;

    Validatetxtfld validatetxtfld;


    public void initialize(){
        validatetxtfld = new ValidatetxtfldImpl();
        isValidatingOnAdd = false;

        isValidatingOnUpdate = false;

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
        searchRooms(txtfldRoomTypeIdType.getText());
        if(paneSearch.isVisible()){
            txtfldSearchRoomTypeID.setText("");
            txtfldSearchRoomType.setText("");
            txtfldSearchRoomqty.setText("");
            txtfldSearchroomkeymoney.setText("");
        }
        if(paneRemove.isVisible()){
            txtfldRemoveRoomTypeID.setText("");
            txtfldRemoveRoomType.setText("");
            txtfldRemoveRoomqty.setText("");
            txtfldRemoveroomkeymoney.setText("");
        }
    }

    public void ClickedAddRoom(ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Room Adding Information");
        alert1.setContentText("This Room added successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Room Adding Information");
        alert2.setContentText("This Room added not successfully!");

        //persist data using thread
        Thread threadAdd =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length
                RoomDTO roomDTO = new RoomDTO(
                        txtfldAddRoomTypeID.getText(),
                        txtfldAddRoomtype.getText(),
                        Double.parseDouble(txtfldAddKeyMoney.getText()),
                        Integer.parseInt(txtfldAddRoomqty.getText())
                );
                if(roomService.saveRoom(roomDTO)){
                    txtfldRoomTypeIdType.clear();
                    searchRooms("");
                    ClearAllPanetxtflds();
                    panefullLoading.setVisible(false); //after task completed hide loading pane
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

        if((validatetxtfld.validateTxtfldRoomTypeId(txtfldAddRoomTypeID , txthinttxtfldAddRoomTypeId))&
                (validatetxtfld.validateTxtfldRoomType(txtfldAddRoomtype, txhinttxtfldAddRoomType))&
                (validatetxtfld.validateTxtfldRoomQty(txtfldAddRoomqty , txhinttxtfldUpdateRoomqty1))&
                (validatetxtfld.validateTxtfldRoomKeymoney(txtfldAddKeyMoney , txhinttxtfldAddKeyMoney)) ){

            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Room Adding Confirmation");
            alert.setContentText("Are you sure to want you to add this Room?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    threadAdd.start();  //start thread
                    isValidatingOnAdd=false;
                }
            });
        }else{
            isValidatingOnAdd=true;
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid data entered!");
            alert.setContentText("You have entered invalid data.Please retype and try again. ");
            alert.show();
        }
    }

    private void ClearAllPanetxtflds() {
        if(paneRemove.isVisible()) {
            txtfldRemoveRoomTypeID.setText("");
            txtfldRemoveRoomType.setText("");
            txtfldRemoveRoomqty.setText("");
            txtfldRemoveroomkeymoney.setText("");
        }
        if(paneAdd.isVisible()) {
            txtfldAddRoomTypeID.clear();
            txtfldAddtype.clear();
            txtfldAddqty.clear();
            txtfldAddKeyMoney.clear();
        }
        if(paneUpdate.isVisible()) {
            txtfldUpdateRoomTypeID.clear();
            txtfldUpdateRoomType.clear();
            txtfldUpdateRoomqty.clear();
            txtfldUpdateroomkeymoney.clear();
        }
    }

    public void typeActiontxtfldUpdateRoomTypeId(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldRoomTypeId(txtfldUpdateRoomTypeID , txthinttxtfldUpdateRoomTypeId);
        }
    }

    public void typeActiontxtfldUpdateRoomType(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldRoomType(txtfldUpdateRoomType, txhinttxtfldUpdateRoomType);
        }
    }

    public void typeActiontxtfldUpdateKeyMoney(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldRoomKeymoney(txtfldUpdateroomkeymoney , txhinttxtfldUpdateKeyMoney);
        }
    }

    public void typeActiontxtfldUpdateRoomqty(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldRoomQty(txtfldUpdateRoomqty , txhinttxtfldUpdateRoomqty);
        }
    }

    public void typeActiontxtfldAddRoomTypeID(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldRoomTypeId(txtfldAddRoomTypeID , txthinttxtfldAddRoomTypeId);
        }
    }

    public void typeActiontxtfldAddRoomtype(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldRoomType(txtfldAddRoomtype, txhinttxtfldAddRoomType);
        }
    }

    public void typeActiontxtfldAddKeyMoney(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldRoomKeymoney(txtfldAddKeyMoney , txhinttxtfldAddKeyMoney);
        }
    }

    public void typeActiontxtfldAddRoomqty(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldRoomQty(txtfldAddRoomqty , txhinttxtfldUpdateRoomqty1);
        }
    }

    public void clickedTableRow(MouseEvent mouseEvent) {
        if(paneSearch.isVisible()){
            txtfldSearchRoomTypeID.setText(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getRoom_type_id());
            txtfldSearchRoomType.setText(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getType());
            txtfldSearchRoomqty.setText(String.valueOf(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getQty()));
            txtfldSearchroomkeymoney.setText(String.valueOf(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getKey_money()));
        }
        if(paneUpdate.isVisible()){
            txtfldUpdateRoomTypeID.setText(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getRoom_type_id());
            txtfldUpdateRoomType.setText(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getType());
            txtfldUpdateRoomqty.setText(String.valueOf(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getQty()));
            txtfldUpdateroomkeymoney.setText(String.valueOf(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getKey_money()));
        }
        if(paneRemove.isVisible()){
            txtfldRemoveRoomTypeID.setText(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getRoom_type_id());
            txtfldRemoveRoomType.setText(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getType());
            txtfldRemoveRoomqty.setText(String.valueOf(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getQty()));
            txtfldRemoveroomkeymoney.setText(String.valueOf(roomDTOList.get(tblRoom.getSelectionModel().getSelectedIndex()).getKey_money()));
        }
    }

    public void ClickedUpdateRoom(ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Room Updating Information");
        alert1.setContentText("This Room Updated successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Room Updating Information");
        alert2.setContentText("This Room updated not successfully!");

        //persist data using thread
        Thread threadUpdate =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length

                RoomDTO roomDTO = new RoomDTO(
                        txtfldUpdateRoomTypeID.getText(),
                        txtfldUpdateRoomType.getText(),
                        Double.parseDouble(txtfldUpdateroomkeymoney.getText()),
                        Integer.parseInt(txtfldUpdateRoomqty.getText())
                );

                if(roomService.updateRoom(roomDTO)){
                    txtfldRoomTypeIdType.clear();
                    searchRooms("");
                    ClearAllPanetxtflds();
                    panefullLoading.setVisible(false); //after task completed hide loading pane
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
        if((validatetxtfld.validateTxtfldRoomTypeId(txtfldUpdateRoomTypeID , txthinttxtfldUpdateRoomTypeId))&
                (validatetxtfld.validateTxtfldRoomType(txtfldUpdateRoomType, txhinttxtfldUpdateRoomType))&
                (validatetxtfld.validateTxtfldRoomQty(txtfldUpdateRoomqty , txhinttxtfldUpdateRoomqty))&
                (validatetxtfld.validateTxtfldRoomKeymoney(txtfldUpdateroomkeymoney , txhinttxtfldUpdateKeyMoney)) ){

            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Room Updating Confirmation");
            alert.setContentText("Are you sure to want you to Update this Room?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    threadUpdate.start();  //start thread
                    isValidatingOnUpdate=false;
                }
            });

        }else{
            isValidatingOnUpdate=true;
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid data entered!");
            alert.setContentText("You have entered invalid data.Please retype and try again. ");
            alert.show();
        }
    }

    public void ClickedRemoveRoom(ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Remove Removed");
        alert1.setContentText("This Room removed successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Remove Removing Confirmation");
        alert2.setContentText("This Room removed not successfully!");

        Thread threadBack =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true);
                Thread.sleep(500);
                RoomDTO roomDTO = new RoomDTO(
                        txtfldRemoveRoomTypeID.getText(),
                        txtfldRemoveRoomType.getText(),
                        Double.parseDouble(txtfldRemoveroomkeymoney.getText()),
                        Integer.parseInt(txtfldRemoveRoomqty.getText())
                );

                if(roomService.deleteRoom(roomDTO)){
                    txtfldRoomTypeIdType.clear();
                    searchRooms("");
                    ClearAllPanetxtflds();
                    panefullLoading.setVisible(false); //after task completed hide loading pane
                    Platform.runLater(() ->
                            alert1.show()
                    );
                }else{
                    Platform.runLater(() ->
                            alert2.show()
                    );
                    panefullLoading.setVisible(false);
                }
            }
        });
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Room Removing Confirmation");
        alert.setContentText("Are you sure to want you to Remove this room?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                threadBack.start();  //start thread
            }
        });
    }
}
