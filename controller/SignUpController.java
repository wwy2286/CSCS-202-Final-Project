package csc202.FinalProject.controller;

import csc202.FinalProject.model.User;
import csc202.FinalProject.model.UserDB;
import csc202.FinalProject.model.UserIO;
import csc202.FinalProject.util.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField SSN;
    @FXML
    DatePicker dateOfBirth;
    @FXML
    RadioButton male;
    @FXML
    RadioButton female;
    @FXML
    TextField email;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    PasswordField confirmPassword;
    @FXML
    Hyperlink login;
    @FXML
    Button signUp;
    @FXML
    Label signUpLabel;


    char gender = 'm';



    public void displayLogInView(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage)((Hyperlink)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/LoginJavaFX.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void signUpUser(ActionEvent actionEvent) throws IOException {
        boolean isUserNameCorrect = Validation.isUsernameUnique(UserDB.getUsers(),userName.getText());
        boolean isPasswordFormatCorrect = Validation.isPasswordFormatCorrect(password.getText());
        boolean doesPasswordMatch = password.getText().equals(confirmPassword.getText());
        boolean isEmailFormatCorrect = Validation.isEmailFormat(email.getText());

        if (isUserNameCorrect&&isPasswordFormatCorrect&&doesPasswordMatch&&isEmailFormatCorrect){
            User newUser = new User();
            newUser.setFirstName(firstName.getText());
            newUser.setLastName(lastName.getText());
            newUser.setSSN(Integer.parseInt(SSN.getText()));

            newUser.setDob(dateOfBirth.getValue().toString());
            newUser.setGender(gender);
            newUser.setEmail(email.getText());
            newUser.setPhoneNumber(phoneNumber.getText());
            newUser.setUsername(userName.getText());
            newUser.setPassword(password.getText());
            UserDB.getUsers().add(newUser);
            try {
                UserIO.writeUsers(UserDB.getUsers());
            } catch (IOException e){
                System.err.println("Cannot write UserDB to binary file.");
                e.printStackTrace();
            }
            signUpLabel.setText("User added");
        } else {
            Alert output = new Alert(Alert.AlertType.ERROR);
            String errorOutput ="";
            signUpLabel.setText("User not added.");
            if(!isUserNameCorrect)
                errorOutput += "Username already taken \n";
            if (!isPasswordFormatCorrect)
                errorOutput += "Password format is incorrect. Please have at least 1 digit, 1 lowercase letter, 1 uppercase letter and 1 special character. \n";
            if (!doesPasswordMatch)
                errorOutput += "Passwords do not match. \n";
            if (!isEmailFormatCorrect)
                errorOutput += "Email format is not correct. \n";
            output.setTitle("Error Dialog");
            output.setHeaderText("User not added");
            output.setContentText(errorOutput);
            output.showAndWait();

        }

        System.out.println(UserDB.getUsers());

    }

    public void radioSelect(ActionEvent event) throws Exception{
        char message='m';
        if (male.isSelected()){
            message = 'm';
        }
        if (female.isSelected()){
            message = 'f';
        }
        gender = message;
    }

    public void chooseFile(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Open Resource File");
        fc.showOpenDialog(primaryStage);



    }
}
