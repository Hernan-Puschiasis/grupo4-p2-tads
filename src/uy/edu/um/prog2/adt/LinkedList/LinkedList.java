package uy.edu.um.prog2.adt.LinkedList;

public class LinkedList<T> implements MyLinkedList<T> {
    private Node<T> head = null;
    private int size = 0;


    @Override
    public void add(T value) {
        if (this.getHead() == null){
            Node<T> firstNodo = new Node<T>(value);
            this.head = firstNodo;
        }
        else{
            Node currentNodo = this.getHead();
            while(currentNodo.getNextNodo() != null){
                currentNodo = currentNodo.getNextNodo();
            }
            Node<T> newNodo = new Node<T>(value);
            currentNodo.setNextNodo(newNodo);
        }
        this.size = this.getSize() + 1;

    }

    @Override
    public void remove(int position) {
        if (position == 0) {
            if (head.getNextNodo() == null){
                this.getHead().setNextNodo(null);
                this.getHead().setValue(null);
            }
            else{
                head = head.getNextNodo();
            }

        } else {
            Node<T> currentNodo = this.getHead();
            Node<T> previousNodo = null;
            for (int i = 0; i < position; i++) {
                previousNodo = currentNodo;
                currentNodo = currentNodo.getNextNodo();

            }
            if (currentNodo.getNextNodo() == null) {
                previousNodo.setNextNodo(null);
            }
            else{
                Node<T> nextNodo = currentNodo.getNextNodo();
                previousNodo.setNextNodo(nextNodo);


            }
        }
        this.size = this.getSize() - 1;
    }

    @Override
    public T get(int position) {
        if (position == 0){
            if (this.getHead() == null){
                return null;
            }
            else{
                return this.getHead().getValue();
            }
        }
        else{
            Node<T> currentNodo = this.getHead();
            for (int i = 0; i < position;i++){
                currentNodo = currentNodo.getNextNodo();
            }
            return currentNodo.getValue();
        }

    }

    public void removeValue(T value){
        int position = -1;
        int deletePosition = -1;
        Node<T> currentNode =  head;
        boolean encontrado = false;
        while(currentNode != null && !encontrado){
            position ++;
            if(currentNode.getValue().equals(value)){
                deletePosition = position;
                encontrado = true;
            }
            currentNode = currentNode.getNextNodo();
        }
        if(deletePosition != -1){
            this.remove(deletePosition);
        }

    }



    public boolean inList(T value){
        boolean isInList = false;
        Node<T> currentNodo = this.getHead();
        if (this.getHead() == null){

        }
        else{
            while(currentNodo != null){
                if (currentNodo.getValue().equals(value)){
                    isInList = true;
                }
                currentNodo = currentNodo.getNextNodo();

            }
        }
        return isInList;

    }

    public void addFirst(T value){
        if (head == null){
            Node newNodo = new Node<T>(value);
            head = newNodo;
        }
        else{
            Node<T> firstNodo = new Node<T>(value);
            Node<T> nextNodo = head;
            firstNodo.setNextNodo(nextNodo);
            head = firstNodo;

        }
        this.size = this.getSize() + 1;
    }

    public void display(){
        Node<T> currentNodo = this.head;
        while(currentNodo.getNextNodo() != null){
            System.out.print(currentNodo.getValue());
            System.out.print(" ");
            currentNodo = currentNodo.getNextNodo();
        }
        System.out.println(currentNodo.getValue());
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
