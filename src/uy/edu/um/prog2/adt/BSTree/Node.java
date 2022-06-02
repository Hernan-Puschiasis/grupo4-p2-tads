package uy.edu.um.prog2.adt.BSTree;
import uy.edu.um.prog2.adt.LinkedList.*;
import uy.edu.um.prog2.adt.Queue.*;




public class Node<K extends Comparable<K>,T> {
    private K key;
    private T data;
    private Node<K, T> leftChild = null;
    private Node<K, T> rightChild = null;

    public Node(K key,T data){
        this.key = key;
        this.data = data;
    }

    public K getKey(){
        return key;
    }

    public boolean equals(Object o){
        return key.equals(((Node) o).getKey());
    }

    public T getData(){return data;}

    //direction = 1 es izquierda y -1 es derecha
    public void delete(K key, Node<K,T> parent,int direction){
        if(this.key.equals(key)){
            if(rightChild == null && leftChild == null){
                if(direction == 1){
                    parent.setLeftChild(null);
                }
                else{
                    parent.setRightChild(null);
                }
            }
            else if(leftChild == null){
                if(direction == 1){
                    parent.setLeftChild(rightChild);
                }
                else{
                    parent.setRightChild(rightChild);
                }
            }
            else if(rightChild == null){
                if(direction == 1){
                    parent.setLeftChild(leftChild);
                }
                else{
                    parent.setRightChild(leftChild);
                }
            }
            else{
                Node<K,T> reintroducir = this.deleteRight(rightChild);
                this.key = reintroducir.getKey();
                this.data = reintroducir.getData();
            }
        }
        else if(this.key.compareTo(key) > 0){
            if(leftChild == null){

            }
            else{
                leftChild.delete(key,this,1);
            }

        }
        else{
            if(rightChild == null){

            }
            else{
                rightChild.delete(key,this,-1);
            }
        }

    }

    public Node<K,T> deleteRight(Node<K,T> node){
        if(node.getRightChild() == null){
            rightChild = null;
            return node;
        }
        else{
            return deleteRight(node.getRightChild());
        }
    }

    public T find(K key){
        if(this.key.compareTo(key) > 0){
            if(leftChild == null){
                return null;
            }
            else{
                return leftChild.find(key);
            }

        }
        else if(this.key.compareTo(key) < 0){
            if(rightChild == null){
                return null;
            }
            else{
                return rightChild.find(key);
            }
        }
        else{
            return data;
        }
    }

    public void insert(K key, T data){
        if(this.key.compareTo(key) > 0){
            if(leftChild == null){
                leftChild = new Node<>(key, data);
            }
            else{
                leftChild.insert(key,data);
            }

        }
        else if(this.key.compareTo(key) < 0){
            if(rightChild == null){
                rightChild = new Node<>(key, data);
            }
            else{
                rightChild.insert(key,data);
            }
        }
    }

    public int size(){
        if(leftChild == null && rightChild == null){
            return 1;
        }
        else if(leftChild == null){
            return rightChild.size() + 1;
        }
        else if(rightChild == null){
            return leftChild.size() + 1;
        }
        else{
            return leftChild.size() + rightChild.size() + 1;
        }
    }

    public int countLeaf(){
        if(leftChild == null && rightChild == null){
            return 1;
        }
        else if(leftChild == null){
            return rightChild.countLeaf();
        }
        else if(rightChild == null){
            return leftChild.countLeaf();
        }
        else{
            return leftChild.countLeaf() + rightChild.countLeaf();
        }
    }

    public int countCompleteElements(){
        if(leftChild == null && rightChild == null){
            return 0;
        }
        else if(leftChild == null){
            return rightChild.countCompleteElements();
        }
        else if(rightChild == null){
            return leftChild.countCompleteElements();
        }
        else{
            return 1 + leftChild.countCompleteElements() + rightChild.countCompleteElements();
        }
    }

    public void preOrder(LinkedList<T> elements){
        elements.add(data);
        if(leftChild == null && rightChild == null){

        }
        else if(leftChild == null){
            rightChild.preOrder(elements);
        }
        else if(rightChild == null){
            leftChild.preOrder(elements);
        }
        else{
            leftChild.preOrder(elements);
            rightChild.preOrder(elements);
        }
    }

    public void postOrder(LinkedList<T> elements){
        if(leftChild == null && rightChild == null){
            elements.add(data);
        }
        else if(leftChild == null){
            rightChild.postOrder(elements);
            elements.add(data);
        }
        else if(rightChild == null){
            leftChild.postOrder(elements);
            elements.add(data);
        }
        else{
            leftChild.postOrder(elements);
            rightChild.postOrder(elements);
            elements.add(data);
        }
    }

    public void inOrder(LinkedList<T> elements){
        if(leftChild == null && rightChild == null){
            elements.add(data);
        }
        else if(leftChild == null){
            elements.add(data);
            rightChild.inOrder(elements);

        }
        else if(rightChild == null){
            leftChild.inOrder(elements);
            elements.add(data);
        }
        else{
            leftChild.inOrder(elements);
            elements.add(data);
            rightChild.inOrder(elements);

        }
    }

    public LinkedList<T> recorrerPorNivel(){
        LinkedList<T> recorridos = new LinkedList<T>();
        QueueTwoPointers<Node<K,T>> cola = new QueueTwoPointers<Node<K, T>>();
        cola.enqueue(this);
        while(cola.getSize() != 0){
            try{
                Node<K,T> actualNode = cola.dequeue();
                recorridos.add(actualNode.getData());
                if(actualNode.getLeftChild() != null){
                    cola.enqueue(actualNode.getLeftChild());
                }
                if(actualNode.getRightChild() != null){
                    cola.enqueue(actualNode.getRightChild());
                }
            }catch (EmptyQueueException e){}


        }

        return recorridos;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setData(T data) {
        this.data = data;
    }
}
