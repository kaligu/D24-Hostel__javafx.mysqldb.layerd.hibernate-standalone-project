package lk.d24.hostelsystem.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Start_load_form_controller {
    public ProgressBar pbarLoad;
    public Text txtLoading;
    public Text txtLoadDescribe;
    public AnchorPane mainPane;

    public void initialize() throws InterruptedException {
        Timeline timeline = new Timeline();

        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(700),actionEvent ->{
           txtLoading.setText("Loading.");
           pbarLoad.setProgress(0.1);
           txtLoadDescribe.setText("Initializing Application....");
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1400),actionEvent ->{
            txtLoading.setText("Loading..");
            pbarLoad.setProgress(0.2);
            txtLoadDescribe.setText("Initializing Internal Resources....");
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(2100),actionEvent ->{
            txtLoading.setText("Loading...");
            pbarLoad.setProgress(0.3);
            txtLoadDescribe.setText("Initializing Images....");
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(2800),actionEvent ->{
            txtLoading.setText("Loading....");
            pbarLoad.setProgress(0.4);
            txtLoadDescribe.setText("Loading UIs....");
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(3500),actionEvent ->{
            txtLoading.setText("Loading.");
            pbarLoad.setProgress(0.6);
            txtLoadDescribe.setText("Loading Internal Resources....");
        });
        KeyFrame keyFrame6 = new KeyFrame(Duration.millis(4200),actionEvent ->{
            txtLoading.setText("Loading..");
            pbarLoad.setProgress(0.8);
            txtLoadDescribe.setText("Loading Images....");
        });KeyFrame keyFrame7 = new KeyFrame(Duration.millis(4900),actionEvent ->{
            txtLoading.setText("Loading...");
            pbarLoad.setProgress(0.9);
            txtLoadDescribe.setText("Loading UIs....");
        });
        KeyFrame keyFrame8 = new KeyFrame(Duration.millis(5600),actionEvent ->{
            txtLoading.setText("Loading....");
            pbarLoad.setProgress(1);
            txtLoadDescribe.setText("Welcome to D24 Hostel System v1.0.0");
        });
        KeyFrame keyFrame9 = new KeyFrame(Duration.millis(6400),actionEvent ->{
            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            primaryStage.close();
        });


        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5,keyFrame6,keyFrame7,keyFrame8,keyFrame9);
        timeline.playFromStart();
    }
}
