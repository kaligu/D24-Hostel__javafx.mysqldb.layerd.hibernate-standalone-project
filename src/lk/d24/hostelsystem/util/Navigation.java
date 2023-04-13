/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 1:22 AM
*/
package lk.d24.hostelsystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Navigation {
    private static AnchorPane maincontext;

    public static void navigate(Route route, AnchorPane maincontext) throws IOException {
        Navigation.maincontext = maincontext;
        Navigation.maincontext.getChildren().clear();

        switch (route){
            case RESERVATION:
                setUi("../view/forms/Reservation_form.fxml");
                break;
        }
        switch (route){
            case RESERVATION_DETAIL:
                setUi("../view/forms/Reservedetail_form.fxml");
                break;
        }
        switch (route){
            case ROOM:
                setUi("../view/forms/Room_form.fxml");
                break;
        }
        switch (route){
            case STUDENT:
                setUi("../view/forms/Student_form.fxml");
                break;
        }
        switch (route){
            case HOME:
                setUi("../view/forms/Home_form.fxml");
                break;

        }
        switch (route){
            case SETTINGS:
                setUi("../view/forms/Setting_form.fxml");
                break;

        }
    }

    public static void setUi(String location) throws IOException {
        Navigation.maincontext.getChildren().add(FXMLLoader.load(Route.class.getResource("" +location)));
    }
}
