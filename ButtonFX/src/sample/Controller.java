package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;


public class Controller {

    @FXML
    private Button clickMeButton;

    public void initialize(){
//        clickMeButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
//            @Override
//            public void handle(javafx.event.ActionEvent event) {
//                System.out.println("You clicked me");
//            }
//        });


        clickMeButton.setOnAction(event -> System.out.println("You clicked me"));
    }



}


