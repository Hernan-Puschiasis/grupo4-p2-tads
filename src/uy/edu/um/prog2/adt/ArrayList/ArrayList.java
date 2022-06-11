package uy.edu.um.prog2.adt.ArrayList;

public class ArrayList<T> implements MyArrayList<T>{
    int maxSize;
    int currentSize = 0;
    T[] elements;

    public ArrayList(int size){
        this.maxSize = size;
        this.elements = (T[]) new Object[size];
    }
    @Override
    public void add(T value) {
        elements[currentSize] = value;
        currentSize++;
        if((float)currentSize/maxSize > 0.8){
            this.resize();
        }
    }

    @Override
    public T get(int position) throws IndexOutOfRangeException {
        if(position < 0 || position >= currentSize){
            throw new IndexOutOfRangeException();
        }
        else{
            return elements[position];
        }
    }

    @Override
    public int size() {
        return currentSize;
    }

    private void resize(){
        T[] newArray = (T[]) new Object[2*maxSize];
        for(int i = 0;i < maxSize;i++){
            newArray[i] = elements[i];
        }
        elements = newArray;
        maxSize *= 2;
    }
}
