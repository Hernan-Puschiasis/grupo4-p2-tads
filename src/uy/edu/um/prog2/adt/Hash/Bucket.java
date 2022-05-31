package uy.edu.um.prog2.adt.Hash;

public class Bucket<K,V> {
    private K key;
    private V value;
    private boolean isDeleted = false;

    public Bucket(K key, V values) {
        this.key = key;
        this.value = values;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Bucket){
            return ((Bucket<K,V>) o).getKey().equals(key);
        }
        else {
            return false;
        }
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
