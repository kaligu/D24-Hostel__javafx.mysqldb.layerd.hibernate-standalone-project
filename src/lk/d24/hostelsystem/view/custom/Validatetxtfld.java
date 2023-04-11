/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/9/2023
  @ Time         : 11:51 PM
*/
package lk.d24.hostelsystem.view.custom;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.text.Text;

public interface Validatetxtfld {
    boolean validateTxtfldStudentId(JFXTextField textField , Text text);   //CheckRegax new and old
    boolean validateTxtfldStudentName(JFXTextField textField , Text text);   //CheckRegax name
    boolean validateTxtfldStudentAddress(JFXTextField textField , Text text);   //CheckRegax Address
    boolean validateTxtfldStudentContactNo(JFXTextField textField , Text text);   //NicCheckRegax ContactNo
    boolean validateTxtfldStudentGender(JFXTextField textField , Text text);   //NicCheckRegax Gender
    boolean validateTxtfldStudentdob(JFXDatePicker textField , Text text);   //CheckRegax dob

    boolean validateTxtfldRoomTypeId(JFXTextField textField , Text text);   //CheckRegax RoomTypeId
    boolean validateTxtfldRoomType(JFXTextField textField , Text text);   //CheckRegax RoomType
    boolean validateTxtfldRoomQty(JFXTextField textField , Text text);   //CheckRegax RoomQty
    boolean validateTxtfldRoomKeymoney(JFXTextField textField , Text text);   //CheckRegax RoomKeymoney
}
