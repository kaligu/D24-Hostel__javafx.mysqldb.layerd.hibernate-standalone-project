/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 11:51 PM
*/
package lk.d24.hostelsystem.view.custom.impl;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import lk.d24.hostelsystem.view.custom.Validatetxtfld;

public class ValidatetxtfldImpl implements Validatetxtfld {
    boolean isValidate;
    @Override
    public boolean validateTxtfldStudentId(JFXTextField textField, Text text) {
        //check regax using thread , why - thread still fill textfield character 10 or 12 characters(old , new nic) and user typing data check and return validation instantly
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(textField.getText().length()==10) {  //if contain 10 charcters
                    if (textField.getText().matches("^[0-9]{9}[vV]$")) {
                        text.setText("");
                        textField.setStyle("-jfx-focus-color: #000000; -jfx-unfocus-color: #000000");
                        text.setVisible(false);
                        isValidate=true;
                    }else {
                        textField.requestFocus();
                        textField.setFocusColor(Color.RED);
                        textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4");
                        text.setFill(Color.RED);
                        text.setText("Type a valid Old or New NIC");
                        text.setVisible(true);
                        isValidate=false;
                    }
                }else if(textField.getText().length()==12) { //if contain 12 charcters
                    if (textField.getText().matches("^[0-9]{7}[0][0-9]{4}$")) {
                        text.setText("");
                        textField.setStyle("-jfx-focus-color: #000000; -jfx-unfocus-color: #000000");
                        text.setVisible(false);
                        isValidate=true;
                    }else {
                        textField.requestFocus();
                        textField.setFocusColor(Color.RED);
                        textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4");
                        text.setFill(Color.RED);
                        text.setText("Type a valid Old or New NIC");
                        text.setVisible(true);
                        isValidate=false;
                    }
                }else if(textField.getText().length()>=12){
                    textField.requestFocus();
                    textField.setFocusColor(Color.RED);
                    textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4");
                    text.setFill(Color.RED);
                    text.setText("Type a valid Old or New NIC");
                    text.setVisible(true);
                    isValidate=false;
                }
            }
        });
        thread.start();
        System.out.println(isValidate);
        return isValidate;
    }
}
