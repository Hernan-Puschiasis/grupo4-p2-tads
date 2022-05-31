package uy.edu.um.prog2.adt.Queue;

public class Nodo<T> {
    T value;
    Nodo<T> next = null;

    public Nodo(T value){
        this.value = value;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }


}
