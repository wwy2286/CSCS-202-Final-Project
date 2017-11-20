package csc202.FinalProject.model;

import java.io.*;

public class UserIO {
    public static void writeUsers(Object data) throws IOException{
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\William Yu\\IdeaProjects\\Final Project1\\src\\csc202\\FinalProject\\Database\\users.dat"));
        output.writeObject(data);
    }
    public static Object readUsers() throws IOException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\William Yu\\IdeaProjects\\Final Project1\\src\\csc202\\FinalProject\\Database\\users.dat"));
        return input.readObject();
    }
}
