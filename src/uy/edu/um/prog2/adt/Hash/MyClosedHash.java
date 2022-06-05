package uy.edu.um.prog2.adt.Hash;

public class MyClosedHash<K,V> implements MyHash<K,V> {
    Bucket<K,V>[] buckets;
    int size;
    int occupied = 0;

    @SuppressWarnings("unchecked")
    public MyClosedHash(int size) {
        this.size = size;
        buckets = new Bucket[size];
    }

    @SuppressWarnings("unchecked")
    public MyClosedHash() {
        buckets = new Bucket[size];
        size = 10;
    }
    //El put reescribe
    @Override
    public void put(K key, V value) {
        boolean is_put = false;
        int counter = 0;
        while(!is_put && counter < size){
            if (buckets[function(key,counter)] == null) {
                Bucket<K,V> newBucket = new Bucket<>(key,value);
                buckets[function(key,counter)] = newBucket;
                is_put = true;
            }
            else if(buckets[function(key,counter)].isDeleted()){
                buckets[function(key,counter)].setKey(key);
                buckets[function(key,counter)].setValue(value);
                buckets[function(key,counter)].setDeleted(false);
                is_put = true;
            }
            else{
                counter++;
            }
        }
        occupied ++;
    }

    @Override
    public V get(K key) {
        V valueSearched = null;
        boolean found = false;
        int counter = 0;
        while(!found && counter < size){
            if(buckets[function(key,counter)] == null){
                found = true;
            }
            else if(buckets[function(key,counter)].getKey().equals(key) ){
                if(buckets[function(key,counter)].isDeleted()){
                    found = true;
                }
                else{
                    valueSearched = buckets[function(key,counter)].getValue();
                    found = true;
                }
            }
            else{
                counter ++;
            }
        }
        return valueSearched;
    }

    @Override
    public void delete(K key) {
        boolean found = false;
        int counter = 0;
        while(!found && counter < size){
            if(buckets[function(key,counter)] == null){
                found = true;
            }
            else if(buckets[function(key,counter)].getKey().equals(key) ){
                if(buckets[function(key,counter)].isDeleted()){
                    found = true;
                }
                else{
                    buckets[function(key,counter)].setDeleted(true);
                    found = true;
                }
            }
            else{
                counter ++;
            }
        }
        occupied --;
    }

    @Override
    public int size() {
        return occupied;
    }

    private int function(K key,int i){
        return (key.hashCode() + i) % size;
    }
}
