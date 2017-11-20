package csc202.FinalProject.view;

import csc202.FinalProject.model.*;
import csc202.FinalProject.util.MyArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadUserDB();
        Parent root = FXMLLoader.load(getClass().getResource("LoginJavaFX.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void loadUserDB() throws Exception {

        try{
            UserDB.setUsers((MyArrayList<User>)(UserIO.readUsers()));
        } catch (IOException e){
            System.err.print("Fail to open/read users.dat file.");
        } catch (ClassNotFoundException e){
            System.err.print("Fail reading and casting the UserDB due to User class issue!");
        }
        System.out.println(UserDB.getUsers());
        //Reads and shows Excel file
        //ReadExcel.showExcelData(ReadExcel.excelReader("C:\\Users\\William Yu\\IdeaProjects\\Final Project1\\src\\csc202\\FinalProject\\Database\\Person List.xls"));
       List personList = new ArrayList();
        personList =  ReadExcel.excelReader("C:\\Users\\William Yu\\IdeaProjects\\Final Project1\\src\\csc202\\FinalProject\\Database\\Person List.xls");

        for (int i = 0; i < personList.size(); i++) {
            List record = (List) personList.get(i);
            Person p = new Person(String.valueOf(record.get(0)),
                    String.valueOf(record.get(1)),
                    String.valueOf(record.get(2)),
                    String.valueOf(record.get(3)),
                    (int)Double.parseDouble(String.valueOf(record.get(5))),
                    Double.parseDouble(String.valueOf(record.get(6))),
                    Double.parseDouble(String.valueOf(record.get(7))));
            PersonDB.person.insert(p);
        }
        PersonDB.getPersonList().inorder();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
