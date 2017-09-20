package csc202.FinalProject.view;

import csc202.FinalProject.model.User;
import csc202.FinalProject.model.UserDB;
import csc202.FinalProject.model.UserIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadUserDB();
        Parent root = FXMLLoader.load(getClass().getResource("LoginJavaFX.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void loadUserDB(){
        try{
            UserDB.setUsers((ArrayList<User>) UserIO.readUsers());
        } catch (IOException e){
            System.err.print("Fail to open/read users.dat file.");
        } catch (ClassNotFoundException e){
            System.err.print("Fail reading and casting the UserDB due to User class issue!");
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
