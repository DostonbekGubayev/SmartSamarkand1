package com.example.smartsamarkand1;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable, EventHandler {
    @FXML
    private Label welcomeText;
    @FXML
    private Button btnLogin,btnSignup;
    @FXML
    private ImageView shahRasmlari;
    @FXML
    private TextArea izohText;
    @FXML
    private ImageView rasmlar;
    @FXML
   public  ComboBox languageBox;
   String [] languages={"English","Russian","Uzbek"};
    SignUpControli signUpControli =new SignUpControli();
    public void initialize(URL location, ResourceBundle resources) {
        izohText.setWrapText(true);
        izohText.setEditable(false);
        izohText.setFont(new Font("Tahoma",16));
        File file=new File("izohlar/samarkand.txt");
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNext()){
                String text=scanner.nextLine();
                izohText.setText(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            tilRoyxati();
          tilOrnat();
        try {
           faylControli.faylOchuvchi();
           faylControli.faylgaYozuvchi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void tilRoyxati(){
        for (String x:languages){
            languageBox.getItems().add(x);
            languageBox.setValue("English");
        }
    }

    public void izhTextOrnat(String text) {
        izohText.setText(text);
    }

    public void loginButtonClick(ActionEvent event) {

    }
    @FXML
    public void onClickLoginButton(ActionEvent event) throws IOException {
        new LoginControli().loginOyna();
    }
    @FXML
    public void onClickSignUpButton() throws IOException {
        signUpControli.loginOyna();
    }

    @Override
    public void handle(Event event) {
        izohText.setText("text");
        welcomeText.setText("Salom");
        btnLogin.setText("Salom");
       
    }
    public void tilOrnat(){
        languageBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String yangiText=(String )t1;
                if(yangiText.equals("Uzbek")){
                    btnLogin.setText("Kirish");
                    File file=new File("izohlar/samarqandUzbek.txt");
                    try {
                        Scanner scanner=new Scanner(file);
                        while (scanner.hasNext()){
                            String matn=scanner.nextLine();
                            izohText.setText(matn);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }if (yangiText.equals("Russian")){
                    btnLogin.setText("Вход");
                    File file=new File("izohlar/samarqandRus.txt");
                    try {
                        Scanner scanner=new Scanner(file);
                        while (scanner.hasNext()){
                            String text=scanner.nextLine();
                            izohText.setText(text);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }if (yangiText.equals("English")){
                    btnLogin.setText("Login");
                    File file=new File("izohlar/samarkand.txt");
                    try {
                        Scanner scanner=new Scanner(file);
                        while (scanner.hasNext()){
                            String text=scanner.nextLine();
                            izohText.setText(text);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    class faylControli{
        public static void faylOchuvchi() throws IOException {
            File file=new File("izohlar/samarqandRus.txt");
            file.createNewFile();
            File file1=new File("izohlar/samarkand.txt");
            file1.createNewFile();
        }
        public static void faylgaYozuvchi() throws IOException {
            File file=new File("D:/Vaqtincha/faylim.txt");
            FileWriter fileWriter=new FileWriter("izohlar/samarqandRus.txt");
            String qator=null;
            Scanner scanner=new Scanner(file);
            while (scanner.hasNext()){
                qator=scanner.nextLine();
            }
            fileWriter.write(qator);
            fileWriter.flush();
            fileWriter.close();

            String text1=null;
            File file1=new File("D:/Vaqtincha/fayl.txt");
            FileWriter fileWriter1=new FileWriter("izohlar/samarkand.txt");
            Scanner scanner1=new Scanner(file1);
            while (scanner1.hasNext()){
                text1=scanner1.nextLine();
            }
            fileWriter1.write(text1);
            fileWriter1.flush();
            fileWriter1.close();
        }
    }
}


