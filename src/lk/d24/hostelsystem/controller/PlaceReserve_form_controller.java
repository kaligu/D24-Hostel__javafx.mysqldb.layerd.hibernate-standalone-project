/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 2:34 AM
*/
package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.d24.hostelsystem.dto.ReserveDTO;
import lk.d24.hostelsystem.dto.RoomDTO;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.dto.qaRoomDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.QueryService;
import lk.d24.hostelsystem.service.custom.ReserveService;
import lk.d24.hostelsystem.service.custom.RoomService;
import lk.d24.hostelsystem.service.custom.StudentService;
import lk.d24.hostelsystem.service.custom.impl.StudentServiceImpl;
import lk.d24.hostelsystem.view.custom.Validatetxtfld;
import lk.d24.hostelsystem.view.custom.impl.ValidatetxtfldImpl;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceReserve_form_controller {
    public JFXComboBox cmbboxStudentIds;
    public AnchorPane panefullLoading;
    public Text resStudentID;
    public Text resStudentName;
    public Text resStudentAddress;
    public Text resStudentContactno;
    public Text resStudentDob;
    public Text resStudentGender;
    public TableView tblSelectRoom;
    public TableColumn collRoomTypeIdroom;
    public TableColumn colTyperoom;
    public TableColumn colKeyMoneyroom;
    public TableColumn colavailableRoomsqtyroom;
    public Text lblSelectRoomTypeID;
    public JFXTextField txtfldKeymoney;
    public JFXDatePicker txtfldperiodDate;
    public JFXTextField txtfldReserveID;
    public JFXButton btnCreateReservation;
    public Text txtpaidnotpaid;
    public Text txttimePeriod;
    public Text txtselectstudent;
    public Text txttable;
    public Text txtRoomTabl;

    StudentService studentService;

    ReserveService reserveService;

    QueryService queryService;

    ArrayList<String> studentIDlist;

    List<qaRoomDTO> qaRoomDTOS;

    StudentDTO studentDTO;

    RoomService roomService;

    Validatetxtfld validatetxtfld;

    boolean isValidatingOnAdd;

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
        isValidatingOnAdd=false;
        validatetxtfld = new ValidatetxtfldImpl();
        studentDTO=null;
        qaRoomDTOS = new ArrayList<>();

        studentService = ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);

        roomService = ServiceFactory.getInstance().getService(ServiceTypes.ROOM);

        reserveService = ServiceFactory.getInstance().getService(ServiceTypes.RESERVE);

        queryService = ServiceFactory.getInstance().getService(ServiceTypes.QUERY);
        addStudentIdsintoCmbox(); //set all student ids into combobox

        collRoomTypeIdroom.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colTyperoom.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoneyroom.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colavailableRoomsqtyroom.setCellValueFactory(new PropertyValueFactory<>("availableRoomsQty"));

    }
    private void addStudentIdsintoCmbox() {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                //add data into combobox
                ObservableList<String> stringObservableList = FXCollections.observableArrayList();
                studentIDlist = (ArrayList<String>) studentService.getAllStudentIds();
                stringObservableList.addAll(studentIDlist);
                cmbboxStudentIds.setItems(stringObservableList);

                //add data into table
                loadRoomTable();

                //load last order ID
                loadID();

                panefullLoading.setVisible(false);
            }
        });
        thread.start();
    }

    private void loadRoomTable(){
        qaRoomDTOS.clear();;
        tblSelectRoom.getItems().clear();
        qaRoomDTOS=queryService.findAllAvailableRooms();
        ObservableList<qaRoomDTO> qaRoomDTOObservableList = FXCollections.observableArrayList();
        qaRoomDTOObservableList.addAll(qaRoomDTOS);
        tblSelectRoom.setItems(qaRoomDTOObservableList);

        int count =0;
        for(qaRoomDTO qaRoomDTO : qaRoomDTOS){  //when not any available rooms disable reservation button
            count+=qaRoomDTO.getAvailableRoomsQty();
        }
        if(count==0){
            btnCreateReservation.setDisable(true);
        }else{
            btnCreateReservation.setDisable(false);
        }
    }

    private void loadID(){
        String oldID=reserveService.getLastOrderID();
        String newID="RS-0000";
        if(oldID.equals("null")){
            txtfldReserveID.setText(newID);
        }else{
            txtfldReserveID.setText(incrementRM(oldID));
        }
    }

    private String incrementRM(String input) {   //increment Order ID
        String prefix = input.substring(0, 3);
        int num = Integer.parseInt(input.substring(3));
        String paddedNum;
        if (num > 9999) {
            // If the numerical portion is already at the maximum value, return the original input string
            paddedNum=String.valueOf(num);
        }else{
            num++;
            paddedNum = String.format("%04d", num);
        }
        return prefix + paddedNum;
    }


    public void actionCmbox(ActionEvent actionEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateIsSelectedCombobox(cmbboxStudentIds, txtselectstudent);
        }
        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                studentDTO = studentService.findByPk(studentIDlist.get(cmbboxStudentIds.getSelectionModel().getSelectedIndex()));
                resStudentID.setText(studentDTO.getStudent_id());
                resStudentContactno.setText(studentDTO.getContact_no());
                resStudentAddress.setText(studentDTO.getAddress());
                resStudentName.setText(studentDTO.getName());
                resStudentDob.setText(String.valueOf(studentDTO.getDob()));
                resStudentGender.setText(studentDTO.getGender());

                panefullLoading.setVisible(false);
            }
        });
        thread.start();
    }

    public void clickedActiontblSelectRoom(MouseEvent mouseEvent) {
        if(isValidatingOnAdd){
            validatetxtfld.validateIsSelectedTable(tblSelectRoom,txtRoomTabl);
        }
        lblSelectRoomTypeID.setText(String.valueOf(qaRoomDTOS.get(tblSelectRoom.getSelectionModel().getSelectedIndex()).getRoom_type_id()));
    }

    public void clickedbtncreateReservation(ActionEvent actionEvent){
    Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Reservation Adding Information");
        alert1.setContentText("This reservation created Ssuccessfully.");

    Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Reservation Adding Information");
        alert2.setContentText("This reservation created not successfully!");

        //persist data using thread
        Thread threadAdd =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length

                LocalDate localDate = LocalDate.now();
                ReserveDTO reserveDTO = new ReserveDTO(
                        txtfldReserveID.getText(),
                        txtfldperiodDate.getValue(),
                        resStudentID.getText(),
                        lblSelectRoomTypeID.getText(),
                        "Status:"+txtfldKeymoney.getText()+" ,Reserved Date:"+localDate
                );
                if(reserveService.saveReservation(reserveDTO)){
                    clearAllPanetxtflds();
                    loadID();
                    loadRoomTable();
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
        if(validatetxtfld.validateTxtfldPaidNotPaid(txtfldKeymoney,txtpaidnotpaid)&
                validatetxtfld.validateTxtfldTimePeiod(txtfldperiodDate,txttimePeriod)&
                  validatetxtfld.validateIsSelectedCombobox(cmbboxStudentIds,txtselectstudent)&
                    validatetxtfld.validateIsSelectedTable(tblSelectRoom,txtRoomTabl)){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Reservation Adding Confirmation");
            alert.setContentText("Are you sure to want you to add this Reserve?");
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

    private void clearAllPanetxtflds() {
        txtfldKeymoney.clear();
        txtfldperiodDate.getEditor().clear();
    }

    public void typeActiontxtfldPaidNotpaid(KeyEvent keyEvent) {
        if(isValidatingOnAdd){
            validatetxtfld.validateTxtfldPaidNotPaid(txtfldKeymoney,txtpaidnotpaid);
        }
    }

    public void OnactionAddedPeriodDate(ActionEvent actionEvent) {
        if(isValidatingOnAdd){
            validatetxtfld.validateTxtfldTimePeiod(txtfldperiodDate,txttimePeriod);
        }
    }
}
