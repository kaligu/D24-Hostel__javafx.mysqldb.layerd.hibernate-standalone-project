/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/13/2023
  @ Time         : 11:09 AM
*/
package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.d24.hostelsystem.dto.LoginDetailDTO;
import lk.d24.hostelsystem.dto.StudentDTO;
import lk.d24.hostelsystem.entity.LoginDetail;
import lk.d24.hostelsystem.service.ServiceFactory;
import lk.d24.hostelsystem.service.ServiceTypes;
import lk.d24.hostelsystem.service.custom.LoginDetailService;
import lombok.SneakyThrows;

public class Setting_form_controller {
    public Text txtUsernameBack;
    public Text txtPasswordBack;
    public JFXPasswordField txtfldNewPassword;
    public JFXPasswordField txtfldOldPassword;
    public Text txtUserId;
    public JFXTextField txtfldUsername;

    private final String UserID = "user1"; //this is user row id
    public AnchorPane panefullLoading;

    LoginDetailService loginDetailService;

    LoginDetailDTO loginDetailDTO;

    public void initialize(){
        loginDetailDTO=null;
        loginDetailService= ServiceFactory.getInstance().getService(ServiceTypes.LOGINDETAIL);

        loadData();
    }
    public void clickedActionUpdateChanges(ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setHeaderText("Login account Settings Information");
        alert1.setContentText("This Login Details updated successfully.");

        Alert alert2=new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("Login account Settings Information");
        alert2.setContentText("This Login Details updated not successfully!");

        Alert alert3=new Alert(Alert.AlertType.ERROR);
        alert3.setHeaderText("Login account Settings Information");
        alert3.setContentText("This entered old password is incorrect.Please try again!");

        if(true){ //validate
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Login Detail Updating Confirmation");
            alert.setContentText("Are you sure to want you to update changes in this Login account?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    panefullLoading.setVisible(true); //start show loading ui

                    if(txtfldOldPassword.getText().equals(loginDetailDTO.getPassword())){
                        LoginDetailDTO loginDetailDTO1 = new LoginDetailDTO(
                                txtUserId.getText(),
                                txtfldUsername.getText(),
                                txtfldNewPassword.getText()
                        );
                        if(loginDetailService.update(loginDetailDTO1)){
                            loadData();
                            cleartxtflds();
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
                    }else{
                        txtfldOldPassword.requestFocus();
                        Platform.runLater(() ->
                                alert3.show()
                        );
                        panefullLoading.setVisible(false); //after task completed hide loading pane
                    }
                }
            });

        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid data entered!");
            alert.setContentText("You have entered invalid data.Please retype and try again. ");
            alert.show();
        }
    }

    private void cleartxtflds() {
        txtfldUsername.clear();
        txtfldNewPassword.clear();
        txtfldOldPassword.clear();
    }

    private void loadData() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                panefullLoading.setVisible(true);

                loginDetailDTO=loginDetailService.findByPk(UserID);
                txtUsernameBack.setText(loginDetailDTO.getUserID());
                txtPasswordBack.setText(loginDetailDTO.getUsername());
                txtUserId.setText(loginDetailDTO.getUserID());
                txtfldUsername.setText(loginDetailDTO.getUsername());

                panefullLoading.setVisible(false);
            }
        });
        thread.start();
    }
}
