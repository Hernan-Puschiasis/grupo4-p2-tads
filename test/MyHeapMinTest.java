import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.Heap.EmptyHeapException;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeap;
import uy.edu.um.prog2.adt.Heap.MyHeapMin;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapMinTest {

    @Test
    void insert() {
        MyHeap<Integer> sut = new MyHeapMin<>(10);
        try{
            sut.insert(9);
            sut.insert(8);
            sut.insert(7);
            sut.insert(6);
            sut.insert(5);
            sut.insert(4);
            sut.insert(3);
            sut.insert(2);
            sut.insert(1);
            sut.insert(0);
        }catch (HeapOverflow e){}
        assertEquals("0 \n1 4 \n3 2 8 5 \n9 6 7 ",sut.toString());
        //Tira excepción
        Exception exception = assertThrows(HeapOverflow.class,() -> {
            sut.insert(10);
        });
    }

    @Test
    void delete() {
        MyHeap<Integer> sut = new MyHeapMin<>(10);
        //Tira excepción
        Exception exception = assertThrows(EmptyHeapException.class,() -> {
            sut.delete();
        });
        try{
            sut.insert(9);
            sut.insert(8);
            sut.insert(7);
            sut.insert(6);
            sut.insert(5);
            sut.insert(4);
            sut.insert(3);
            sut.insert(2);
            sut.insert(1);
            sut.insert(0);
        }catch (HeapOverflow e){}
        try{
            sut.delete();
            sut.delete();
            sut.delete();
            sut.delete();
        }catch (EmptyHeapException e){}
        assertEquals("4 \n6 5 \n9 7 8 ",sut.toString());
    }

    @Test
    void testToString() {
        MyHeap<Integer> sut = new MyHeapMin<>(12);
        try{
            sut.insert(10);
            sut.insert(9);
            sut.insert(8);
            sut.insert(7);
            sut.insert(6);
            sut.insert(5);
            sut.insert(4);
            sut.insert(3);
            sut.insert(2);
            sut.insert(1);
            sut.insert(0);
        }catch (HeapOverflow e){}
        assertEquals("0 \n1 5 \n4 2 9 6 \n10 7 8 3 ", sut.toString());
        try{
            sut.delete();
        }catch (EmptyHeapException e){}
       assertEquals("1 \n2 5 \n4 3 9 6 \n10 7 8 ",sut.toString());
    }

    @Test
    void size() {
        MyHeap<Integer> sut = new MyHeapMin<>(6);
        //Cuando está vacío
        assertEquals(0,sut.size());
        //Cuando se inserta 1
        try{
            sut.insert(0);
        }catch (HeapOverflow e){}
        assertEquals(1,sut.size());
        try{
            sut.insert(1);
            sut.insert(2);
            sut.insert(3);
        }catch (HeapOverflow e){}
        assertEquals(4,sut.size());
        try{
            sut.insert(4);
            sut.insert(5);
        }catch (HeapOverflow e){}
        assertEquals(6,sut.size());
    }

    @Test
    void isEmpty() {
        MyHeap<Integer> sut = new MyHeapMin<>(6);
        assertTrue(sut.isEmpty());
        try{
            sut.insert(0);
        }catch (HeapOverflow e){}
        assertFalse(sut.isEmpty());
        try{
            sut.delete();
        }catch (EmptyHeapException e){}
        assertTrue(sut.isEmpty());
    }

    @Test
    void top(){
        MyHeap<Integer> sut = new MyHeapMin<>(10);
        assertNull(sut.top());
        try{
            sut.insert(9);
        }catch (HeapOverflow e){}
        assertEquals(9,sut.top());
    }

}