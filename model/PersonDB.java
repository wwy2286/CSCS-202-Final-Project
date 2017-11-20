package csc202.FinalProject.model;

import csc202.FinalProject.util.AVLTree;

public class PersonDB {
    public static int personIndex;
    public static AVLTree<Person> person = new AVLTree<Person>();

    public static AVLTree<Person> getPersonList(){
        return person;
    }

    public static void setPerson(AVLTree<Person> person){
        PersonDB.person = person;
    }
}
