package uy.edu.um.prog2.adt.Queue;

public interface MyQueue <T>{
    void enqueue(T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();
    int getSize();
}
