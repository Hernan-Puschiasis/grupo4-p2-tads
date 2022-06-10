package uy.edu.um.prog2.adt.Heap;

public class MyHeapMin<T extends Comparable<T>> implements MyHeap<T>{
    private T[] values;
    private int heapSize;
    private int maxSize;

    public MyHeapMin(int size){
        this.values = (T[]) new Comparable[size];
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
    public void insert(T value) throws HeapOverflow{
        if(heapSize == maxSize){
            throw new HeapOverflow();
        }
        int position = heapSize;
        heapSize++;
        this.values[position] = value;
        while(position != 0 && values[position].compareTo(values[getFatherPosition(position)]) < 0   ){
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
        while(2 * position < heapSize && getLeftChildPosition(position) < maxSize &&values[getLeftChildPosition(position)] != null && values[getRightChildPosition(position)] != null && last.compareTo(min(values[getLeftChildPosition(position)],values[getRightChildPosition(position)])) > 0){
            if(values[getLeftChildPosition(position)].equals(min(values[getLeftChildPosition(position)],values[getRightChildPosition(position)]))){
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
        if (getLeftChildPosition(position) >= maxSize){}
        else if(getLeftChildPosition(position) < maxSize && getRightChildPosition(position) >= maxSize) {
            if(values[getLeftChildPosition(position)] == null){}
            else{
                if (values[getLeftChildPosition(position)].compareTo(last) < 0) {
                    T temp = values[position];
                    values[position] = values[getLeftChildPosition(position)];
                    values[getLeftChildPosition(position)] = temp;
                }
            }
        }
        else {
            if (values[getLeftChildPosition(position)] == null && values[getRightChildPosition(position)] == null) {}
            else if (values[getLeftChildPosition(position)] == null) {
                if (values[getRightChildPosition(position)].compareTo(last) < 0) {
                    T temp = values[position];
                    values[position] = values[getRightChildPosition(position)];
                    values[getRightChildPosition(position)] = temp;
                }

            } else if (values[getRightChildPosition(position)] == null) {
                if (values[getLeftChildPosition(position)].compareTo(last) < 0) {
                    T temp = values[position];
                    values[position] = values[getLeftChildPosition(position)];
                    values[getLeftChildPosition(position)] = temp;
                }
            }
        }

        return max;
    }
    private T min(T value1,T value2){
        if(value1.compareTo(value2) < 0){
            return value1;
        }
        else{
            return value2;
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
