package uy.edu.um.prog2.adt.BSTree;
import uy.edu.um.prog2.adt.LinkedList.*;


public class BSTree<K extends Comparable<K>,T> implements MyTree<K,T> {
    private Node<K,T> root = null;


    @Override
    public T find(K key) {
        if(root == null){
            return null;
        }
        else{
            return root.find(key);
        }
    }
    @Override
    public void insert(K key, T data) {
        if(root == null){
           root = new Node<>(key, data);
        }
        else{
            root.insert(key,data);
        }

    }

    @Override
    public void delete(K key) {
        if(root == null){
            return;
        }
        if(root.getKey().equals(key)){
            if(root.getLeftChild() == null && root.getRightChild() == null){
                root = null;
            }
            else if(root.getLeftChild() == null){
                root = root.getRightChild();
            }
            else if(root.getRightChild() == null){
                root = root.getLeftChild();
            }else{
                Node<K,T> reintroducir = root.minLeft(root.getRightChild());
                root.delete(reintroducir.getKey(), root,-1);
                root.setKey(reintroducir.getKey());
                root.setData(reintroducir.getData());
            }
        }
        else if(root.getKey().compareTo(key) > 0){
            root.getLeftChild().delete(key,root,1);
        }
        else{
            root.getRightChild().delete(key,root,-1);
        }

    }

    public int size(){
        if(root == null){
            return 0;
        }
        else {
            return root.size();
        }
    }
}
