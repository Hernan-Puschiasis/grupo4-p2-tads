package uy.edu.um.prog2.adt.Hash;
import uy.edu.um.prog2.adt.LinkedList.*;

public class MyOpenHashImpl<K, V> implements MyHash<K,V> {
    LinkedList<Bucket<K,V>>[] buckets;
    int size;
    int occupied = 0;

    @SuppressWarnings("unchecked")
    public MyOpenHashImpl(int size) {
        this.size = size;
        buckets = new LinkedList[size];
    }

    @SuppressWarnings("unchecked")
    public MyOpenHashImpl() {
        buckets = new LinkedList[10];
        size = 10;
    }

    private int function(K key){
        return (key.hashCode()) % size;
    }

    @Override
    public void put(K key, V value) {
        int position = function(key);
        Bucket<K,V> newBucket = new Bucket<K,V>(key,value);
        if(buckets[position] == null){
            buckets[position] = new LinkedList<Bucket<K,V>>();
            buckets[position].add(newBucket);
        }else{
            buckets[position].add(newBucket);
        }
        occupied++;
    }

    @Override
    public V get(K key) {
        int position = function(key);
        LinkedList<Bucket<K, V>> containingBucket = buckets[position];
        try{
            for (int i = 0; i < containingBucket.getSize();i++){
                if(containingBucket.get(i).getKey().equals(key)){
                    return containingBucket.get(i).getValue();
                }
            }

        }catch (ListIndexOutOfRange e){

        }
        return null;

    }

    @Override
    public void delete(K key) {
        int position = function(key);
        LinkedList<Bucket<K, V>> containingBucket = buckets[position];
        Bucket<K, V> auxiliarBucket = new Bucket<>(key,null);
        if(containingBucket.inList(auxiliarBucket)){
            containingBucket.removeValue(auxiliarBucket);
            occupied--;
        }

    }

    @Override
    public int size() {
        return occupied;
    }
}
