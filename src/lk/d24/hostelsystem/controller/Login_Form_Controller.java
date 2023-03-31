package lk.d24.hostelsystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Login_Form_Controller {
    public ImageView layer1;
    public Circle circle1;
    public AnchorPane loginPane;
    public ImageView imgloginPane;
    public ImageView imgpswdSavePane;
    public AnchorPane paneCmpnyDescribeResetPswd;
    public AnchorPane paneCmpnyDescribeLogin;
    public ImageView closeBtnImgView;
    public Button ClickLoginBtn;
    public RadioButton radioBtnShowPswrd;
    public AnchorPane paneWelcome;
    public JFXTextField txtfldUsername;
    public JFXPasswordField pswrdfldPassword;
    public JFXTextField txtfldPassword;


    ArrayList<String> wordArrayList;
    ArrayList<String> dotArrayList;

    public void initialize(){
        loadCircleGraphic();
        wordArrayList = new ArrayList<String>();
        dotArrayList = new ArrayList<String>();
    }

    private void loadCircleGraphic(){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.9));
        slide.setNode(circle1);

        slide.setToX(795);

        loginPane.setVisible(false);
        imgloginPane.setVisible(false);
        paneWelcome.setVisible(true);
        imgpswdSavePane.setVisible(true);
        paneCmpnyDescribeResetPswd.setVisible(true);
        paneCmpnyDescribeLogin.setVisible(false);
        circle1.setStroke(Paint.valueOf("#0c6611"));
        circle1.setFill(Paint.valueOf("#0c6611"));
        slide.play();
    }

    public void loginBtnOnAction(ActionEvent actionEvent) {

    }

    public void actionCloseBtnEntered(MouseEvent mouseEvent) {
        closeBtnImgView.setImage(new Image("lk/d24/hostelsystem/view/assests/icons/cancelred.png"));
    }

    public void actionCloseBtnExited(MouseEvent mouseEvent) {
        closeBtnImgView.setImage(new Image("lk/d24/hostelsystem/view/assests/icons/cancelblue.png"));
    }

    public void clickLoginBtnOnAction(ActionEvent actionEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.9));
        slide.setNode(circle1);
        slide.setToX(0);

        paneWelcome.setVisible(false);
        imgpswdSavePane.setVisible(false);
        loginPane.setVisible(true);
        imgloginPane.setVisible(true);
        paneCmpnyDescribeResetPswd.setVisible(false);
        paneCmpnyDescribeLogin.setVisible(true);
        circle1.setStroke(Paint.valueOf("#0e4c8f"));
        circle1.setFill(Paint.valueOf("#0e4c8f"));
        slide.play();
    }

    public void actionRadioBtnShowPswrd(ActionEvent actionEvent) {
        txtfldPassword.setText(pswrdfldPassword.getText());
        if(radioBtnShowPswrd.isSelected()){
            txtfldPassword.setVisible(true);
            pswrdfldPassword.setVisible(false);
        }else{
            txtfldPassword.setVisible(false);
            pswrdfldPassword.setVisible(true);
            pswrdfldPassword.requestFocus();
            pswrdfldPassword.end();
        }
    }

    public void keyReleaseActionTxtfldpswrd(KeyEvent keyEvent) {
        txtfldPassword.setText(pswrdfldPassword.getText());
    }

    public void clickedTxtfldPassword(MouseEvent mouseEvent) {
        txtfldPassword.setVisible(false);
        pswrdfldPassword.setVisible(true);
        pswrdfldPassword.requestFocus();
        pswrdfldPassword.end();
        radioBtnShowPswrd.selectedProperty().set(false);
    }

    public void ActionTxtUsername(ActionEvent actionEvent) {
        pswrdfldPassword.requestFocus();
        pswrdfldPassword.end();
    }

    public void actionBackBtn(MouseEvent mouseEvent) {
        loadCircleGraphic();
    }

    public void clickedCloseBtn(MouseEvent mouseEvent) {
        System.exit(0);
    }
}
