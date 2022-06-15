package uy.edu.um.prog2.adt.LinkedList;

public interface MyLinkedList<T>{
    void add(T value);
    T get(int i) throws ListIndexOutOfRange;
    void remove(int i) throws ListIndexOutOfRange;
    void removeValue(T value);
    boolean inList(T value);
    void addFirst(T value);
    int getSize();

}
