package uy.edu.um.prog2.adt.Queue;

public class QueueTwoPointers<T> implements MyQueue<T> {

    Nodo<T> head = null; //Es el primero que llega
    Nodo<T> last = null;
    int size = 0;
    @Override
    public void enqueue(T element) {
        Nodo<T> newNodo = new Nodo<T>(element);
        if(head == null){
            head = newNodo;
            last = newNodo;
        }
        else{
            Nodo<T> almostLast = last;
            almostLast.setNext(newNodo);
            last = newNodo;
        }
        size ++;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(head == null){
            throw new EmptyQueueException();
        }
        else{
            Nodo<T> nextNodo = head.getNext();
            Nodo<T> firstNodo = head;
            head = nextNodo;
            size --;
            return firstNodo.getValue();
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public void visualizar(){
        Nodo<T> currentNodo = head;
        while(currentNodo.getNext() != null){
            System.out.print(currentNodo.getValue());
            System.out.print(" ");
            currentNodo = currentNodo.getNext();
        }
        System.out.println(currentNodo.getValue());

    }

    public int getSize(){
        return size;
    }
}
