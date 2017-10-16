package csc202.FinalProject.controller;

import csc202.FinalProject.model.UserDB;
import csc202.FinalProject.util.HeapSort;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoggedInController {
    @FXML
    Label welcomeLabel;
    @FXML
    Button sortButton;



    public void sort(ActionEvent actionEvent) {
       HeapSort.heapSort(UserDB.getUsers());

        System.out.println(UserDB.getUsers());


    }
}
