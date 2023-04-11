package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.StudentService;
import lk.d24.hostelsystem.view.custom.Validatetxtfld;
import lk.d24.hostelsystem.view.custom.impl.ValidatetxtfldImpl;
import lombok.SneakyThrows;
import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student_form_controller {
    public Circle navCircle1;
    public Circle navCircle2;
    public Circle navCircle3;
    public Circle navCircle4;
    public AnchorPane paneSearch;
    public AnchorPane paneAdd;
    public AnchorPane paneRemove;
    public AnchorPane paneUpdate;
    public AnchorPane panefullLoading;
    public JFXTextField txtfldAddStudentid;
    public JFXTextField txtfldAddStudentname;
    public JFXTextField txtfldAddStudentaddress;
    public JFXTextField txtfldAddStudentcontactno;
    public JFXTextField txtfldAddStudentgender;
    public JFXDatePicker txtfldAddStudentdob;
    public AnchorPane paneLoading;
    public TableView tblStudent;
    public TableColumn colStudentid;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactno;
    public TableColumn colDob;
    public TableColumn colGender;
    public JFXTextField txtfldStudentIDName;
    public Text txtfldSearchStudentid;
    public Text txtfldSearchStudentname;
    public Text txtfldSearchStudentaddress;
    public Text txtfldSearchStudentcontactno;
    public Text txtfldSearchStudentdob;
    public Text txtfldSearchStudentgender;
    public JFXTextField txtfldUpdateStudentid;
    public JFXTextField txtfldUpdateStudentname;
    public JFXTextField txtfldUpdateStudentaddress;
    public JFXTextField txtfldUpdateStudentcontactno;
    public JFXTextField txtfldUpdateStudentgender;
    public JFXDatePicker txtfldUpdateStudentdob;
    public Text txtfldRemoveStudentid;
    public Text txtfldRemoveStudentname;
    public Text txtfldRemoveStudentaddress;
    public Text txtfldRemoveStudentcontactno;
    public Text txtfldRemoveStudentdob;
    public Text txtfldRemoveStudentgender;
    public JFXButton btnAdd;
    public Text txthinttxtfldAddStudentid;
    public Text txthinttxtfldAddStudentname;
    public Text txthinttxtfldAddStudentaddress;
    public Text txthinttxtfldAddStudentcontactno;
    public Text txthinttxtfldAddStudentgender;
    public Text txthinttxtfldAddStudentdob;
    public Text txthinttxtfldUpdateStudentdob1;
    public Text txthinttxtfldUpdateStudentgender1;
    public Text txthinttxtfldUpdateStudentcontactno1;
    public Text txthinttxtfldUpdateStudentaddress1;
    public Text txthinttxtfldUpdateStudentname1;
    public Text txthinttxtfldUpdateStudentid1;

    boolean isValidatingOnAdd;
    boolean isValidatingOnUpdate;

    StudentService studentService;

    List<StudentDTO> studentDTOList;

    private String searchText;

    Validatetxtfld validatetxtfld;

    public void initialize(){
        isValidatingOnAdd = false;

        isValidatingOnUpdate = false;

        validatetxtfld = new ValidatetxtfldImpl(); //text field validation interface

        studentService= ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);

        studentDTOList=new ArrayList<>();

        searchText="";

        colStudentid.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactno.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        searchStudent(searchText);

        clearAllPanes(); //clear all panes

        paneSearch.setVisible(true);  //load search pane
        navCircle1.setStroke(Paint.valueOf("#027a6c"));
        navCircle1.setFill(Paint.valueOf("#027a6c"));
    }

    private void searchStudent(String searchText){
        Thread threadTableRun = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);
                tblStudent.getItems().clear();
                studentDTOList.clear();

                ObservableList<StudentDTO> studentDTOObservableList = FXCollections.observableArrayList();

                studentDTOList = studentService.searchStudentByText(searchText);

                studentDTOObservableList.addAll(studentDTOList);

                tblStudent.setItems(studentDTOObservableList);
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
    public void clickedActionStudentAdd(ActionEvent actionEvent) throws ParseException {

        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Student Adding Information");
        alert1.setContentText("This Student added successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Student Adding Information");
        alert2.setContentText("This Student added not successfully!");

        //persist data using thread
        Thread threadAdd =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length
                SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
                Date dob=formatter.parse(txtfldAddStudentdob.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                StudentDTO studentDTO = new StudentDTO(
                        txtfldAddStudentid.getText(),
                        txtfldAddStudentname.getText(),
                        txtfldAddStudentaddress.getText(),
                        txtfldAddStudentcontactno.getText(),
                        txtfldAddStudentdob.getValue(),
                        txtfldAddStudentgender.getText()
                );

                if(studentService.saveStudent(studentDTO)){
                    clearAllPanetxtflds();
                    txtfldStudentIDName.clear();
                    searchStudent("");
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

        if((validatetxtfld.validateTxtfldStudentId(txtfldAddStudentid , txthinttxtfldAddStudentid))&
                (validatetxtfld.validateTxtfldStudentName(txtfldAddStudentname , txthinttxtfldAddStudentname))&
                (validatetxtfld.validateTxtfldStudentAddress(txtfldAddStudentaddress , txthinttxtfldAddStudentaddress))&
                (validatetxtfld.validateTxtfldStudentContactNo(txtfldAddStudentcontactno , txthinttxtfldAddStudentcontactno))&
                (validatetxtfld.validateTxtfldStudentGender(txtfldAddStudentgender , txthinttxtfldAddStudentgender))&
                (validatetxtfld.validateTxtfldStudentdob(txtfldAddStudentdob , txthinttxtfldAddStudentdob)) ){

            isValidatingOnAdd=false;
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Student Adding Confirmation");
            alert.setContentText("Are you sure to want you to add this Student?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                   threadAdd.start();  //start thread
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
    private void clearAllPanetxtflds(){
        if(paneRemove.isVisible()) {
            txtfldRemoveStudentid.setText("");
            txtfldRemoveStudentname.setText("");
            txtfldRemoveStudentaddress.setText("");
            txtfldRemoveStudentcontactno.setText("");
            txtfldRemoveStudentgender.setText("");
            txtfldRemoveStudentdob.setText(""); //clear date picker
        }
        if(paneAdd.isVisible()) {
            txtfldAddStudentid.clear();
            txtfldAddStudentname.clear();
            txtfldAddStudentaddress.clear();
            txtfldAddStudentcontactno.clear();
            txtfldAddStudentgender.clear();
            txtfldAddStudentdob.getEditor().clear(); //clear date picker
        }
        if(paneUpdate.isVisible()) {
            txtfldUpdateStudentid.clear();
            txtfldUpdateStudentname.clear();
            txtfldUpdateStudentaddress.clear();
            txtfldUpdateStudentcontactno.clear();
            txtfldUpdateStudentcontactno.clear();
            txtfldUpdateStudentdob.getEditor().clear(); //clear date picker
        }
    }

    public void actionKeyReleasedSearchStudentIDOrName(KeyEvent keyEvent) {
        searchStudent(txtfldStudentIDName.getText());
        if(paneSearch.isVisible()){
            txtfldSearchStudentid.setText("");
            txtfldSearchStudentname.setText("");
            txtfldSearchStudentaddress.setText("");
            txtfldSearchStudentcontactno.setText("");
            txtfldSearchStudentdob.setText("");
            txtfldSearchStudentgender.setText("");
        }
        if(paneRemove.isVisible()){
            txtfldRemoveStudentid.setText("");
            txtfldRemoveStudentname.setText("");
            txtfldRemoveStudentaddress.setText("");
            txtfldRemoveStudentcontactno.setText("");
            txtfldRemoveStudentdob.setText("");
            txtfldRemoveStudentgender.setText("");
        }
    }

    public void clickedTableRow(MouseEvent mouseEvent) {
        if(paneSearch.isVisible()){
            txtfldSearchStudentid.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getStudent_id());
            txtfldSearchStudentname.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getName());
            txtfldSearchStudentaddress.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getAddress());
            txtfldSearchStudentcontactno.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getContact_no());
            txtfldSearchStudentdob.setText(String.valueOf(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getDob()));
            txtfldSearchStudentgender.setText(String.valueOf(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getGender()));
        }
        if(paneUpdate.isVisible()){
            txtfldUpdateStudentid.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getStudent_id());
            txtfldUpdateStudentname.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getName());
            txtfldUpdateStudentaddress.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getAddress());
            txtfldUpdateStudentcontactno.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getContact_no());
            txtfldUpdateStudentdob.setValue(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getDob());
            txtfldUpdateStudentgender.setText(String.valueOf(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getGender()));
        }
        if(paneRemove.isVisible()){
            txtfldRemoveStudentid.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getStudent_id());
            txtfldRemoveStudentname.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getName());
            txtfldRemoveStudentaddress.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getAddress());
            txtfldRemoveStudentcontactno.setText(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getContact_no());
            txtfldRemoveStudentdob.setText(String.valueOf(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getDob()));
            txtfldRemoveStudentgender.setText(String.valueOf(studentDTOList.get(tblStudent.getSelectionModel().getSelectedIndex()).getGender()));
        }
    }

    public void clickedActionStudentUpdate(ActionEvent actionEvent) throws ParseException {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Student Updating Information");
        alert1.setContentText("This Room Updated successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Student Updating Information");
        alert2.setContentText("This Student updated not successfully!");

        //persist data using thread
        Thread threadAdd =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true); //start show loading ui
                Thread.sleep(500); //make virtual database accessing time length

                StudentDTO studentDTO = new StudentDTO(
                        txtfldUpdateStudentid.getText(),
                        txtfldUpdateStudentname.getText(),
                        txtfldUpdateStudentaddress.getText(),
                        txtfldUpdateStudentcontactno.getText(),
                        txtfldUpdateStudentdob.getValue(),
                        txtfldUpdateStudentgender.getText()
                );

                if(studentService.updateStudent(studentDTO)){
                    clearAllPanetxtflds();
                    txtfldStudentIDName.clear();
                    isValidatingOnUpdate=false;
                    searchStudent("");
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
        if((validatetxtfld.validateTxtfldStudentId(txtfldUpdateStudentid , txthinttxtfldUpdateStudentid1))&
                (validatetxtfld.validateTxtfldStudentName(txtfldUpdateStudentname , txthinttxtfldUpdateStudentname1))&
                (validatetxtfld.validateTxtfldStudentAddress(txtfldUpdateStudentaddress , txthinttxtfldUpdateStudentaddress1))&
                (validatetxtfld.validateTxtfldStudentContactNo(txtfldUpdateStudentcontactno , txthinttxtfldUpdateStudentcontactno1))&
                (validatetxtfld.validateTxtfldStudentGender(txtfldUpdateStudentgender , txthinttxtfldUpdateStudentgender1))&
                (validatetxtfld.validateTxtfldStudentdob(txtfldUpdateStudentdob , txthinttxtfldUpdateStudentdob1)) ){

            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Student Updating Confirmation");
            alert.setContentText("Are you sure to want you to Update this student?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    threadAdd.start();  //start thread
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

    public void clickedActionStudentRemove(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(
                txtfldRemoveStudentid.getText(),
                txtfldRemoveStudentname.getText(),
                txtfldRemoveStudentaddress.getText(),
                txtfldRemoveStudentcontactno.getText(),
                LocalDate.parse(txtfldRemoveStudentdob.getText()),
                txtfldRemoveStudentgender.getText()
        );
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Student Removed");
        alert1.setContentText("This Student removed successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Student Removing Confirmation");
        alert2.setContentText("This Student removed not successfully!");

        Thread threadBack =  new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                panefullLoading.setVisible(true);
                Thread.sleep(500);
                if(studentService.deleteStudent(studentDTO)){
                    clearAllPanetxtflds();
                    txtfldStudentIDName.clear();
                    searchStudent("");
                    panefullLoading.setVisible(false);
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
        alert.setHeaderText("Student Removing Confirmation");
        alert.setContentText("Are you sure to want you to Remove this student?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                threadBack.start();  //start thread
            }
        });
    }


    public void typeActiontxtfldAddStudentid(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldStudentId(txtfldAddStudentid , txthinttxtfldAddStudentid);
            System.out.println(validatetxtfld.validateTxtfldStudentId(txtfldAddStudentid , txthinttxtfldAddStudentid));
        }
    }

    public void typeActiontxtfldAddStudentname(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldStudentName(txtfldAddStudentname , txthinttxtfldAddStudentname);
        }
    }

    public void typeActiontxtfldAddStudentAddress(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldStudentAddress(txtfldAddStudentaddress , txthinttxtfldAddStudentaddress);
        }
    }

    public void typeActiontxtfldAddStudentContactno(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldStudentContactNo(txtfldAddStudentcontactno , txthinttxtfldAddStudentcontactno);
        }
    }

    public void typeActiontxtfldAddStudentGender(KeyEvent keyEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldStudentGender(txtfldAddStudentgender , txthinttxtfldAddStudentgender);
        }
    }

    public void typeActiontxtfldAddStudentdob(ActionEvent actionEvent) {
        if(isValidatingOnAdd) {
            validatetxtfld.validateTxtfldStudentdob(txtfldAddStudentdob , txthinttxtfldAddStudentdob);
        }
    }

    public void typeActiontxtfldUpdateStudentdob(ActionEvent actionEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldStudentdob(txtfldAddStudentdob , txthinttxtfldUpdateStudentdob1);
        }
    }

    public void typeActiontxtfldUpdateStudentgender(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldStudentGender(txtfldUpdateStudentgender , txthinttxtfldUpdateStudentgender1);
        }
    }

    public void typeActiontxtfldUpdateStudentcontactno(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldStudentContactNo(txtfldUpdateStudentcontactno , txthinttxtfldUpdateStudentcontactno1);
        }
    }

    public void typeActiontxtfldUpdateStudentaddress(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldStudentAddress(txtfldUpdateStudentaddress , txthinttxtfldUpdateStudentaddress1);
        }
    }

    public void typeActiontxtfldUpdateStudentname(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldStudentName(txtfldUpdateStudentname , txthinttxtfldUpdateStudentname1);
        }
    }

    public void typeActiontxtfldUpdateStudentid1(KeyEvent keyEvent) {
        if(isValidatingOnUpdate) {
            validatetxtfld.validateTxtfldStudentId(txtfldUpdateStudentid , txthinttxtfldUpdateStudentid1);
        }
    }
}
