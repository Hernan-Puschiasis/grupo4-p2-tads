package uy.edu.um.prog2.adt.Heap;

public interface MyHeap<T extends Comparable<T>> {
    void insert(T value) throws HeapOverflow;
    T delete() throws EmptyHeapException;
    int size();
    boolean isEmpty();
    //String toString();

}
