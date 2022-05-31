package uy.edu.um.prog2.adt.LinkedList;

public class Node<T> {
    private Node nextNodo = null;
    private T value = null;

    public Node(T value){
        this.value = value;
    }

    public Node getNextNodo() {
        return nextNodo;
    }

    public void setNextNodo(Node nextNodo) {
        this.nextNodo = nextNodo;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
