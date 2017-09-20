package csc202.FinalProject.model;

/**
 * Created by William Yu on 9/11/2017.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int SSN;
    private String dob;
    private char gender;

    public Person(){
        setFirstName("No first name");
        setLastName("No last name");
        setSSN(000000000);
        setDob("");
        setGender('f');

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
        return firstName + " " + lastName + " " + SSN + " " + dob + " " + gender;
    }
}
