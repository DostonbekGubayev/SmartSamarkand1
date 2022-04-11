package com.example.smartsamarkand1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.*;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpControli implements Initializable {
    @FXML
    private Label succesLabel;
    @FXML
    private TextField firstNameText,lastNameText,
            usernameText,emailText,passText,confiPassText;
    Connection connection;
    PreparedStatement prst;
    boolean boshmi;
    HelloController controller;
//    public SignUpControli(HelloController controller){
//        this.controller=controller;
//    }
    public void initialize(URL location, ResourceBundle resources) {

    }
   @FXML
    public void onClickLoginButton() {
       boolean qanaqa = rostlikkaTekshir();

       if (qanaqa){
           submitSuccess();
           succesLabel.setText("Login Successfully");
           succesLabel.setFont(new Font("Tahoma",18));
           succesLabel.setTextFill(Color.ORANGE);
       }else {
           System.out.println("Xatolik sodir etildi");
           succesLabel.setText("Login not Inserted");
           succesLabel.setFont(new Font("Arial",18));
           succesLabel.setTextFill(Color.RED.darker());
       }
           }




    public void loginOyna() throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("signup-oynasi.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

    }
    public boolean rostlikkaTekshir() {
        boolean rostmi=true;
          if(firstNameText.getText().isEmpty()&&rostmi){
              rostmi=false;
          }if (lastNameText.getText().isEmpty()&&rostmi){
              rostmi=false;
        }if (usernameText.getText().isEmpty()&&rostmi){
              rostmi=false;
        }if (emailText.getText().isEmpty()&&rostmi){
              rostmi=false;
        }if (passText.getText().isEmpty()&&rostmi){
              rostmi=false;
        }if (confiPassText.getText().isEmpty()&&rostmi){
              rostmi=false;
        }
        return rostmi;
    }

    public void submitSuccess() {
        String url = "INSERT INTO `gullar`(`Ism`, `Familya`, `Otasining Ismi`, `Manzili`, `Telefoni`, `Guruhi`)  VALUES (?,?,?,?,?,?)";
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/talabalar", "root", "");
                prst = connection.prepareStatement(url);
                prst.setString(1, firstNameText.getText());
                prst.setString(2, lastNameText.getText());
                prst.setString(3, usernameText.getText());
                prst.setString(4, emailText.getText());
                prst.setString(5, passText.getText());
                prst.setString(6, confiPassText.getText());
                prst.executeUpdate();
                System.out.println("Ma'lumotlar bazaga joylandi");

            } catch (SQLException e) {
                System.out.println("Xatolik sodir etildi");
                e.printStackTrace();
            }
    }

}
