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
        if (textField.getText().matches("^([0-9]{9}[x|X|v|V]|[0-9]{12})$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
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
        if (textField.getText().matches("^(?:7|0|(?:\\+94))[0-9]{9,10}$")) {
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

    @Override
    public boolean validateTxtfldRoomTypeId(JFXTextField textField, Text text) {
        if (textField.getText().matches("^RM-[0-9]{4}$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a Valid Room Type ID.Such as 'RM-xxxx'.");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldRoomType(JFXTextField textField, Text text) {
        if (textField.getText().matches("(?:AC|Non-AC|AC/Food|Non_AC/Food)$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a Valid Room Type.Valid Room types are 'AC', 'Non-AC', 'AC/Food', 'Non_AC/Food'.");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldRoomQty(JFXTextField textField, Text text) {
        if (textField.getText().matches("^[0-9]*$") & textField.getText().length()>0) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a Valid Room Qty.Only natural numbers.");
            text.setVisible(true);
            return false;
        }
    }

    @Override
    public boolean validateTxtfldRoomKeymoney(JFXTextField textField, Text text) {
        if (textField.getText().matches("^(0|[1-9]\\d*)(\\.\\d+)?$")) {
            text.setText("");
            textField.setStyle("-fx-focus-color: #000000; -fx-unfocus-color: #000000");
            text.setVisible(false);
            return true;
        } else {
            textField.requestFocus();
            textField.setStyle("-fx-border-color: #ff0000; -fx-background-color:#fca4a4; -fx-focus-color:#ff0000");
            text.setFill(Color.RED);
            text.setText("Type a Valid Room Qty.natural values or decimal values.");
            text.setVisible(true);
            return false;
        }
    }
}
