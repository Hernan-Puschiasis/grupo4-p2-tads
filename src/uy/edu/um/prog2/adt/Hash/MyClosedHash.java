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
            else if(buckets[function(key,counter)].getKey().equals(key)){
                buckets[function(key,counter)].setValue(value);
                return;
            }
            else{
                counter++;
            }
        }
        occupied ++;
        if((float)occupied/size >= 0.8){
            this.resize();
        }
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
                return;
            }
            else if(buckets[function(key,counter)].getKey().equals(key) ){
                if(buckets[function(key,counter)].isDeleted()){
                    return;
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


    public void resize(){
        MyClosedHash<K,V> newHash = new MyClosedHash<>(2 * size);
        for(int i = 0; i < size; i++){
            if (buckets[i] != null) {
                newHash.put(buckets[i].getKey(),buckets[i].getValue());
            }
        }
        size *= 2;
        buckets = newHash.getBuckets();
    }

    public Bucket<K, V>[] getBuckets() {
        return buckets;
    }

    private int function(K key, int i){
        return (key.hashCode() + i) % size;
    }
}
