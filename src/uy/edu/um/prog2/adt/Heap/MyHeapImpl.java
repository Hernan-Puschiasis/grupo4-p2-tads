package uy.edu.um.prog2.adt.Heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T>{
    private T[] values;
    private int heapSize;
    private int maxSize;

    public MyHeapImpl(int size){
        this.values = (T[]) new Comparable[size]; //Cambie Object por Comparable
        this.heapSize = 0;
        this.maxSize = size;
    }


    private int getFatherPosition(int position){
        return (position - 1)/2;
    }

    private int getLeftChildPosition(int position){
        return 2 * position + 1;
    }

    private int getRightChildPosition(int position){
        return 2 * position + 2;
    }

    @Override
    public void insert(T value) {
        int position = heapSize;
        heapSize++;
        this.values[position] = value;
        while(position != 0 && values[position].compareTo(values[getFatherPosition(position)]) > 0   ){
            values[position] = values[getFatherPosition(position)];
            values[getFatherPosition(position)] = value;
            position = getFatherPosition(position);
        }
    }


    @Override
    public T delete() throws EmptyHeapException{
        if(this.isEmpty()){
            throw new EmptyHeapException();
        }
        heapSize--;
        int position = heapSize;
        T max = values[0];
        T last = values[position];
        values[position] = null;
        values[0] = last;
        position = 0;
        while(2 * position < heapSize && values[getLeftChildPosition(position)] != null && values[getRightChildPosition(position)] != null && last.compareTo(max(values[getLeftChildPosition(position)],values[getRightChildPosition(position)])) < 0){
            if(values[getLeftChildPosition(position)].equals(max(values[getLeftChildPosition(position)],values[getRightChildPosition(position)]))){
                T temp = values[position];
                values[position] = values[getLeftChildPosition(position)];
                values[getLeftChildPosition(position)] = temp;
                position = getLeftChildPosition(position);
            }
            else{
                T temp = values[position];
                values[position] = values[getRightChildPosition(position)];
                values[getRightChildPosition(position)] = temp;
                position = getRightChildPosition(position);
            }
        }
        try{
            if(values[getLeftChildPosition(position)] == null && values[getRightChildPosition(position)] == null){

            }
            else if(values[getLeftChildPosition(position)] == null){
                T temp = values[position];
                values[position] = values[getRightChildPosition(position)];
                values[getRightChildPosition(position)] = temp;
            }
            else if(values[getRightChildPosition(position)] == null){
                T temp = values[position];
                values[position] = values[getLeftChildPosition(position)];
                values[getLeftChildPosition(position)] = temp;
            }
        }catch (ArrayIndexOutOfBoundsException e){

        }

        return max;
    }
    private T max(T value1,T value2){
        if(value1.compareTo(value2) < 0){
            return value2;
        }
        else{
            return value1;
        }
    }

    public String toString(){
        String heapString = "";
        int level = 0;
        int currentPosition = 0;
        while(currentPosition != size()){
            heapString += values[currentPosition].toString() + " ";
            if((Math.pow(2,level + 1)) - 2 == currentPosition){
                level++;
                heapString += "\n";

            }
            currentPosition++;

        }
        return heapString;
    }
    @Override
    public int size() {
        return heapSize;
    }

    @Override
    public boolean isEmpty() {
        return heapSize == 0;
    }

}