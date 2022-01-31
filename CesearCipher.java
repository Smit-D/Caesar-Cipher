/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cns;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class CesearCipher extends Application {
    
    
    public static StringBuffer encrypt(String text, String shift) {
        StringBuffer result = new StringBuffer();
 
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        Integer.parseInt(shift) - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        Integer.parseInt(shift) - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    public static StringBuffer decrypt(String cipher, String shift) {
        StringBuffer result = new StringBuffer();
 
        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) -
                        Integer.parseInt(shift) - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) -
                        Integer.parseInt(shift) - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Encrypt");
        Button btn2 = new Button();
        btn2.setText("Decrypt");
        TextField plainText = new TextField();
        plainText.setPromptText("Enter question here");
        Label enc=new Label("Answer:");
        Label plain=new Label("Question:");
        TextField encrypted = new TextField();
        plainText.setPromptText("Anser prints here");
        TextField shift = new TextField();
        shift.setPromptText("Enter keyvalue here");
  
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String pt=plainText.getText();
                String shifty=shift.getText();
                String cipher = encrypt(pt, shifty).toString();
                encrypted.setText(cipher);
                System.out.println(cipher);
            }
        });
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String pt=plainText.getText();
                String shifty=shift.getText();
                String decipher = decrypt(pt,shifty).toString();
                encrypted.setText(decipher);
                System.out.println(decipher);
            }
        });
        
        HBox root = new HBox();
        root.setSpacing(10);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);       
        root.getChildren().add(plain);
        root.getChildren().add(plainText);
        root.getChildren().add(enc);
        root.getChildren().add(encrypted);
        root.getChildren().add(shift);

        
        Scene scene = new Scene(root, 600, 350);
        
        primaryStage.setTitle("CAESAR CIPHER");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
   
}
