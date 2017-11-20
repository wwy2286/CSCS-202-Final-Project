package csc202.FinalProject.model;

import java.io.Serializable;

/**
 * Created by William Yu on 9/11/2017.
 */
public class User extends Person implements Serializable{

    public String username;
    public String email;
    public String phoneNumber;
    public String password;
    public String profilePhoto;

    public User(){
        super();
        setUsername("No Username");
        setEmail("No email");
        setPhoneNumber("");
        setPassword("No password");
        setProfilePhoto("");
    }

    public User(String username, String email, String phoneNumber, String password, String profilePhoto) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }


    public User(String firstName, String lastName, int SSN, String dob, char gender, String username, String email, String phoneNumber, String password, String profilePhoto) {
        super(firstName, lastName, SSN, dob, gender);
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String toString(){
        return super.toString() + " " + username + " " + email + " " + phoneNumber + " " + password;
    }

    public boolean equals(Object o){
        if (!(o instanceof User))
            return false;
        else
            return (this == o);
    }
}
