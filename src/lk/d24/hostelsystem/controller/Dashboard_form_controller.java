package lk.d24.hostelsystem.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.d24.hostelsystem.util.Navigation;
import lk.d24.hostelsystem.util.Route;

import java.io.IOException;

public class Dashboard_form_controller {
    public AnchorPane panemain;
    public AnchorPane box1;
    public AnchorPane box2;
    public AnchorPane box3;
    public AnchorPane box4;
    public AnchorPane box5;
    public AnchorPane panecontext;
    public AnchorPane boxHome;

    String isNameofpane="null";

    public void initialize() throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="boxHome";
        boxHome.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.HOME,panecontext);

    }

    private void clearAllPanesBoxes(){ //clear all pane
        boxHome.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        box1.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        box2.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        box3.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        box4.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        box5.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
    }


    public void ActionMainPaneMouseEntered(MouseEvent mouseEvent) {
        //Stage primaryStage = (Stage) panemain.getScene().getWindow();

    }

    public void actionMouseClickednavbox1(MouseEvent mouseEvent) throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="box1";
        box1.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.RESERVATION,panecontext);
    }

    public void actionMouseEnterednavbox1(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box1")) {
            box1.setStyle("-fx-background-color:  #2e134f; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox1(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box1")) {
            box1.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox2(MouseEvent mouseEvent) throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="box2";
        box2.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.RESERVATION_DETAIL,panecontext);
    }

    public void actionMouseEnterednavbox2(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box2")) {
            box2.setStyle("-fx-background-color:  #2e134f; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox2(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box2")) {
            box2.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox3(MouseEvent mouseEvent) throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="box3";
        box3.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.STUDENT,panecontext);
    }

    public void actionMouseEnterednavbox3(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box3")) {
            box3.setStyle("-fx-background-color:  #2e134f; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox3(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box3")) {
            box3.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox4(MouseEvent mouseEvent) throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="box4";
        box4.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.ROOM,panecontext);
    }

    public void actionMouseEnterednavbox4(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box4")) {
            box4.setStyle("-fx-background-color:  #2e134f; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox4(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box4")) {
            box4.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox5(MouseEvent mouseEvent) throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="box5";
        box5.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.SETTINGS,panecontext);
    }

    public void actionMouseEnterednavbox5(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box5")) {
            box5.setStyle("-fx-background-color:  #2e134f; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox5(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("box5")) {
            box5.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavHome(MouseEvent mouseEvent) throws IOException {
        clearAllPanesBoxes(); //clear all panes
        isNameofpane="boxHome";
        boxHome.setStyle("-fx-background-color:  #0f061a; -fx-background-radius: 48");
        Navigation.navigate(Route.HOME,panecontext);
    }

    public void actionMouseEnterednavHome(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("boxHome")) {
            boxHome.setStyle("-fx-background-color:  #2e134f; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavHome(MouseEvent mouseEvent) {
        if(!isNameofpane.equals("boxHome")) {
            boxHome.setStyle("-fx-background-color:  #41018a; -fx-background-radius: 48");
        }
    }
}
