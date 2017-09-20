package csc202.FinalProject.model;

import java.util.ArrayList;

public class UserDB {
    private static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<User> getUsers(){
        return users;
    }
    public static void setUsers(ArrayList<User> users){
        UserDB.users = users;
    }

}
