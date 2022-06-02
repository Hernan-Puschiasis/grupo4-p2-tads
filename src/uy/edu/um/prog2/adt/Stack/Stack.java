package uy.edu.um.prog2.adt.Stack;


public class Stack<T> implements MyStack<T> {
    Nodo<T> top = null;

    @Override
    public void pop() throws EmptyStackException {
        if (this.top == null){
            throw new EmptyStackException();
        }
        else{
            this.top = this.top.getUnderNodo();
        }
    }

    @Override
    public T top() throws EmptyStackException {
        if(this.top == null){
            throw new EmptyStackException();
        }
        else{
            return this.top.getValue();
        }

    }

    @Override
    public void push(T element) {
        Nodo<T> newTop = new Nodo<T>(element);
        Nodo lastTop = this.top;
        newTop.setUnderNodo(lastTop);
        this.top = newTop;



    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void makeEmpty() {
        this.top = null;

    }
}
