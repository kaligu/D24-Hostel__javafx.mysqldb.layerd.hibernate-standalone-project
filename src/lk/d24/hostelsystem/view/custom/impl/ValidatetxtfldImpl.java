/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 11:51 PM
*/
package lk.d24.hostelsystem.view.custom.impl;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import lk.d24.hostelsystem.view.custom.Validatetxtfld;

public class ValidatetxtfldImpl implements Validatetxtfld {
    @Override
    public boolean validateTxtfldStudentId(JFXTextField textField, Text text) {
        if (textField.getText().length() == 10 || textField.getText().length() == 12) {
            if (textField.getText().length() == 10) {
                if (textField.getText().matches("^[0-9]{9}[vV]$")) {
                    text.setText("");
                    textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
                    text.setVisible(false);
                } else {
                    textField.requestFocus();
                    textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
                    text.setFill(Color.RED);
                    text.setText("Type a valid Old or New NIC");
                    text.setVisible(true);
                    return false;
                }
            } else if (textField.getText().length() == 12) {
                if (textField.getText().matches("^[0-9]{7}[0][0-9]{4}$")) {
                    text.setText("");
                    textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
                    text.setVisible(false);
                } else {
                    textField.requestFocus();
                    textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
                    text.setFill(Color.RED);
                    text.setText("Type a valid Old or New NIC");
                    text.setVisible(true);
                    return false;
                }
            }
            return false;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a valid Old or New NIC");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldStudentName(JFXTextField textField, Text text) {
        if (textField.getText().matches("^[A-Za-z]+(\\s*[A-Za-z]+)*(\\.[A-Za-z]+(\\s*[A-Za-z]+)*)*$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a valid Name and this field can contain english letters[a-z,A-Z],space,dot.");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldStudentAddress(JFXTextField textField, Text text) {
        if (textField.getText().matches("^[A-Za-z0-9,.\\s]*$")&textField.getText().length() >= 1) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a valid Name and this field can contain english letters[a-z,A-Z], numbers,dot,comma,space.");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldStudentContactNo(JFXTextField textField, Text text) {
        if (textField.getText().matches("^(?:\\\\+94|0094|0)(?:1|7\\\\d|9)(?:\\\\d{8})$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a valid Srilankan Phone No[0xxxxxxxxx,...].");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldStudentGender(JFXTextField textField, Text text) {
        if (textField.getText().matches("(?:male|Male|female|Female|FEMALE|MALE|Not prefer to say|not prefer to say|NOT PREFER TO SAY)$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a valid Gender type.valid types are male , female or not prefer to say.");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldStudentdob(JFXDatePicker textField, Text text) {
        System.out.println(text.getText());
        if (textField.getEditor().getText().length() >= 2) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Select Date of Birth.");
            text.setVisible(true);
            return false;
        }
    }
}
