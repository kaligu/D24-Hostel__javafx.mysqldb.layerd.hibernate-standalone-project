/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 11:00 AM
*/
package lk.d24.hostelsystem.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

public class Home_form_controller {
    public AnchorPane box1;
    public AnchorPane box2;
    public AnchorPane box3;
    public AnchorPane box4;
    public AnchorPane box5;
    public AnchorPane paneroomexpiretoday;
    public AnchorPane panenotpaidrooms;
    public AnchorPane paneavailablerooms;
    public AnchorPane panelreservedrooms;
    public AnchorPane paneallroom;

    public void initialize(){
        clearAllPanes(); //clear all panes

        paneallroom.setVisible(true);  //load search pane
        box1.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    private void clearAllPanes(){ //clear all panes
        paneallroom.setVisible(false);
        paneavailablerooms.setVisible(false);
        panelreservedrooms.setVisible(false);
        panenotpaidrooms.setVisible(false);
        paneroomexpiretoday.setVisible(false);
        box1.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box2.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box3.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box4.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        box5.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
    }

    public void actionMouseClickednavbox1(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneallroom.setVisible(true);
        box1.setVisible(true);
        box1.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    public void actionMouseEnterednavbox1(MouseEvent mouseEvent) {
        if(!paneallroom.isVisible()) {
            box1.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox1(MouseEvent mouseEvent) {
        if(!paneallroom.isVisible()) {
            box1.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox2(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        panelreservedrooms.setVisible(true);
        box2.setVisible(true);
        box2.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    public void actionMouseEnterednavbox2(MouseEvent mouseEvent) {
        if(!panelreservedrooms.isVisible()) {
            box2.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox2(MouseEvent mouseEvent) {
        if(!panelreservedrooms.isVisible()) {
            box2.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox3(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneavailablerooms.setVisible(true);
        box3.setVisible(true);
        box3.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    public void actionMouseEnterednavbox3(MouseEvent mouseEvent) {
        if(!paneavailablerooms.isVisible()) {
            box3.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox3(MouseEvent mouseEvent) {
        if(!paneavailablerooms.isVisible()) {
            box3.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox4(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        panenotpaidrooms.setVisible(true);
        box4.setVisible(true);
        box4.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    public void actionMouseEnterednavbox4(MouseEvent mouseEvent) {
        if(!panenotpaidrooms.isVisible()) {
           box4.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox4(MouseEvent mouseEvent) {
        if(!panenotpaidrooms.isVisible()) {
            box4.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }

    public void actionMouseClickednavbox5(MouseEvent mouseEvent) {
        clearAllPanes(); //clear all panes
        paneroomexpiretoday.setVisible(true);
        box5.setVisible(true);
        box5.setStyle("-fx-background-color: #7b848f; -fx-background-radius: 48");
    }

    public void actionMouseEnterednavbox5(MouseEvent mouseEvent) {
        if(!paneroomexpiretoday.isVisible()) {
            box5.setStyle("-fx-background-color: #89a7cc; -fx-background-radius: 48");
        }
    }

    public void actionMouseExitednavbox5(MouseEvent mouseEvent) {
        if(!paneroomexpiretoday.isVisible()) {
            box5.setStyle("-fx-background-color: #0b88e0; -fx-background-radius: 48");
        }
    }
}
