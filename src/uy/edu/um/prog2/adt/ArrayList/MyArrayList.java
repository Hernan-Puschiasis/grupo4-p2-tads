package uy.edu.um.prog2.adt.ArrayList;

public interface MyArrayList<T> {
    void add(T value);
    T get(int position) throws IndexOutOfRangeException;
    int size();
}
