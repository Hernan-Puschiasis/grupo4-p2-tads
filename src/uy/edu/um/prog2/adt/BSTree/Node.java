package uy.edu.um.prog2.adt.BSTree;


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
                Node<K,T> reintroducir = this.minLeft(rightChild);
                rightChild.delete(reintroducir.getKey(),this,-1);
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

    public Node<K,T> minLeft(Node<K,T> node){
        if(node.getLeftChild() == null){
            return node;
        }
        else{
            return minLeft(node.getLeftChild());
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
