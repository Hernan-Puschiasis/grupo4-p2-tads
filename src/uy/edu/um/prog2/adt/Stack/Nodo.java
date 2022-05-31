package uy.edu.um.prog2.adt.Stack;

public class Nodo<T> {
    Nodo<T> underNodo = null;
    T value = null;

    public Nodo(T element) {
        this.value = element;
    }

    public Nodo<T> getUnderNodo() {
        return underNodo;
    }

    public void setUnderNodo(Nodo<T> underNodo) {
        this.underNodo = underNodo;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
