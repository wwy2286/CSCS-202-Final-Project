package csc202.FinalProject.model;

import java.io.Serializable;

/**
 * Created by William Yu on 9/11/2017.
 */
public class Person implements Serializable, Comparable<Person> {
    private String firstName;
    private String lastName;
    private int SSN;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private String dob;
    private char gender;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private double latitude;
    private double longitude;


    public Person(){
        setFirstName("No first name");
        setLastName("No last name");
        setSSN(000000000);
        setDob("");
        setGender('f');

    }

    public Person(String fname, String address, String city, String state, int zipCode, double latitude, double longitude){
        this.firstName = fname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Person(String firstName, String lastName, int SSN, String dob, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.dob = dob;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String toString(){
        return firstName + " " + lastName + " " + SSN + " " + dob + " " + gender + " "+ zipCode + " " + latitude + " " + longitude;
    }





    @Override
    public int compareTo(Person o) {
        if (this.zipCode<o.zipCode) {
            return -1;
        } else if (this.zipCode > o.zipCode){
                return 1;
        }else{
            return 0;
        }

    }
}
