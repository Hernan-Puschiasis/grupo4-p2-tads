package uy.edu.um.prog2.adt.BSTree;

public interface MyTree<K extends Comparable<K>,T> {
    T find(K key);
    void insert(K key, T data);
    void delete (K key);
    int size();
}
