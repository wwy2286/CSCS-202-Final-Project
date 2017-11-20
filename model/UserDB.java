package csc202.FinalProject.model;

import csc202.FinalProject.util.MyArrayList;

public class UserDB {
    public static int userIndex;
    private static MyArrayList<User> users = new MyArrayList<User>();
    public static MyArrayList<User> getUsers(){
        return users;
    }
    public static void setUsers(MyArrayList<User> users){
        UserDB.users = users;
    }

}
