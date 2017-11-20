package csc202.FinalProject.util;

import csc202.FinalProject.model.User;

/**
 * Created by William Yu on 9/11/2017.
 */
public class Validation {

    static public boolean isUsernameUnique(MyArrayList<User> users, String username){
        boolean unique = true;
        for (User db: users){
            if (db.getUsername().equals(username)){
                unique = false;
            }
        }
        return unique;
    }



   static public boolean isPasswordFormatCorrect(String password){

        return hasDecimal(password)
                &&hasUppercase(password)
                &&hasLowercase(password)
                &&hasSpecialCharacter(password);
    }

   static public boolean hasDecimal(String s){
        boolean decimal = false;

        for (int i = 0; i<s.length(); i++){
            if ((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57){
                decimal = true;
            }
        }
        return decimal;
    }
    static public boolean hasUppercase(String s){
        boolean uppercase = false;

        for (int i = 0; i<s.length(); i++){
            if ((int)s.charAt(i)>=65&&(int)s.charAt(i)<=90){
                uppercase = true;
            }
        }
        return uppercase;
    }

    static public boolean hasLowercase(String s){
        boolean lowercase = false;

        for (int i = 0; i<s.length(); i++){
            if ((int)s.charAt(i)>=97&&(int)s.charAt(i)<=122){
                lowercase = true;
            }
        }
        return lowercase;
    }

    static public boolean hasSpecialCharacter(String s){
        boolean specialCharacter = false;

        for (int i = 0; i<s.length(); i++){
            if ((int)s.charAt(i)>=33&&(int)s.charAt(i)<=47){
                specialCharacter = true;
            }
        }
        return specialCharacter;
    }

    static public boolean isEmailFormat(String s) {
        boolean EmailFormat = true;
        boolean isContainAT = false;
        if (s.isEmpty()){
            EmailFormat=false;
        } else {
            if (!hasDecimal(Character.toString(s.charAt(0)))
                    && !hasLowercase(Character.toString(s.charAt(0)))
                    && !hasUppercase(Character.toString(s.charAt(0)))) {
                EmailFormat = false;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!hasDecimal(Character.toString(s.charAt(i)))
                    && !hasLowercase(Character.toString(s.charAt(i)))
                    && !hasUppercase(Character.toString(s.charAt(i)))
                    && s.charAt(i) != 46
                    && s.charAt(i) !=64) {
                EmailFormat = false;
            }
            if(s.charAt(i)==64){
                isContainAT = true;
            }
        }
        if (isContainAT==false){
            EmailFormat=false;
        }
        return EmailFormat;
    }

    static public boolean isEmailUnique(MyArrayList<User> users, String email){
        boolean unique = true;
        for (User db: users){
            if (db.getEmail().equals(email)){
                unique = false;
            }
        }
        return unique;
    }


}
