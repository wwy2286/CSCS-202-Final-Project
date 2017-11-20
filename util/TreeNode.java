package csc202.FinalProject.util;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(){

    }

    public TreeNode(E e){
        element = e;
    }

    public E getElement(){
        return element;
    }

}
