package com.example.smartsamarkand1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginControli implements Initializable {
    @FXML
    private Label successLabel;
    @FXML
    private TextField usernameTxt,passwordTxt;
    @FXML
    private Button loginButton;

    public void initialize(URL location, ResourceBundle resources) {

        loginButton.setOnAction(event -> {
            boolean holat=rostlikkaTekshir();
            if (holat){
                successLabel.setText("Login Successfully");

            }else {
                successLabel.setText("Error");
                successLabel.setFont(new Font("Tahoma",18));
                successLabel.setTextFill(Color.RED);
            }
            successLabel.setFont(new Font("Arial",18));
            successLabel.setTextFill(Color.PERU);
        });
    }
    public  void loginOyna(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("login.fxml"));
        try {
            Parent parent=fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onLoginButtonClick(){

    }
    public boolean rostlikkaTekshir(){
        boolean rostmi=true;
        if(usernameTxt.getText().isEmpty()){
            rostmi=false;
        }if (passwordTxt.getText().isEmpty()){
            rostmi=false;
        }
        return rostmi;
    }
}
