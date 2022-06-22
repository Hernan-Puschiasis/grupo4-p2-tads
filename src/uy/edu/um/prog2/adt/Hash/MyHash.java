package uy.edu.um.prog2.adt.Hash;

import uy.edu.um.prog2.adt.ArrayList.ArrayList;

public interface MyHash<K,V>{
    void put(K key,V value);
    V get(K key);
    void delete(K key);
    int size();
    boolean inHash(K key);
    ArrayList<K> getKeys();
}
