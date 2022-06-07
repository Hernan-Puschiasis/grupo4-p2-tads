package uy.edu.um.prog2.adt.LinkedList;

public class LinkedList<T> implements MyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> last = null;
    private int size = 0;


    @Override
    public void add(T value) {
        if (this.getHead() == null){
            Node<T> firstNodo = new Node<T>(value);
            this.head = firstNodo;
            this.last = firstNodo;
        }
        else{
            Node<T> newNodo = new Node<T>(value);
            last.setNextNodo(newNodo);
            last = newNodo;
        }
        this.size = this.getSize() + 1;

    }

    @Override
    public void remove(int position) throws ListIndexOutOfRange{
        if(position < 0 || position > size - 1 ){
            throw new ListIndexOutOfRange();
        }
        else if (position == 0) {
            if (head.getNextNodo() == null){
                head = null;
                last = null;
            }
            else{
                head = head.getNextNodo();
            }
        }
        else {
            Node<T> currentNodo = this.getHead();
            Node<T> previousNodo = null;
            for (int i = 0; i < position; i++) {
                previousNodo = currentNodo;
                currentNodo = currentNodo.getNextNodo();

            }
            if (currentNodo.getNextNodo() == null) {
                previousNodo.setNextNodo(null);
                last = previousNodo;
            }
            else{
                Node<T> nextNodo = currentNodo.getNextNodo();
                previousNodo.setNextNodo(nextNodo);
            }
        }
        this.size = this.getSize() - 1;
    }

    @Override
    public T get(int position) throws ListIndexOutOfRange{
        if(position < 0 || position > size - 1 ){
            throw new ListIndexOutOfRange();
        }
        else if (position == 0){
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
        while(currentNode != null && !encontrado && position < size - 1){
            position ++;
            if(currentNode.getValue().equals(value)){
                deletePosition = position;
                encontrado = true;
            }
            currentNode = currentNode.getNextNodo();
        }
        if(deletePosition != -1){
            try{
                this.remove(deletePosition);
            }catch (ListIndexOutOfRange e){

            }

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
            last = newNodo;
        }
        else{
            Node<T> firstNodo = new Node<T>(value);
            Node<T> nextNodo = head;
            firstNodo.setNextNodo(nextNodo);
            head = firstNodo;

        }
        this.size = this.getSize() + 1;
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
