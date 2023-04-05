/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : D24-Hostel__javafx,mysqldb,layerd,hibernate-standalone-project
  @ Date         : 4/3/2023
  @ Time         : 1:48 AM
*/
package lk.d24.hostelsystem.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Room_form_controller {
    public Circle navCircle1;
    public Circle navCircle2;
    public Circle navCircle3;
    public Circle navCircle4;
    public AnchorPane paneSearch;
    public AnchorPane paneAdd;
    public AnchorPane paneRemove;
    public AnchorPane paneUpdate;



    public void initialize(){
        clearAllPanes(); //clear all panes

        paneSearch.setVisible(true);  //load search pane
        navCircle1.setStroke(Paint.valueOf("#027a6c"));
        navCircle1.setFill(Paint.valueOf("#027a6c"));
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
}
