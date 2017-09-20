package csc202.FinalProject.controller;

import csc202.FinalProject.model.User;
import csc202.FinalProject.model.UserDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Hyperlink signUp;
    public void authenticate(){
        Alert outputConfirm = new Alert(Alert.AlertType.CONFIRMATION);
        Alert outputError = new Alert(Alert.AlertType.ERROR);
        int count = -1;
        for (User db : UserDB.getUsers()){
            count ++;
            if (db.getUsername().equals(username.getText())&&db.getPassword().equals(password.getText())) {
                break;
            }
        }
        if(doesUserExist(UserDB.getUsers(), username.getText())&&(UserDB.getUsers().get(count).getPassword().equals(password.getText()))&&UserDB.getUsers().get(count).getUsername().equals(username.getText())) {

            outputConfirm.setTitle("Welcome");
            outputConfirm.setContentText("Welcome "+ UserDB.getUsers().get(count).getUsername());
            outputConfirm.showAndWait();

        } else{

            outputError.setTitle("Access Denied");
            outputError.setContentText("Wrong username or password");
            outputError.showAndWait();


        }

    }

    public static boolean doesUserExist(ArrayList<User> users, String userName){
        boolean userExist=false;
        for(User db: users){
            if(db.getUsername().equals(userName)){
                userExist=true;
            }
        }

        return userExist;
    }

    public void displaySignUpView(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage)((Hyperlink)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/SignUpJavaFX.fxml"));

        primaryStage.setScene(new Scene(root, 500, 600));

        primaryStage.show();
    }
}
