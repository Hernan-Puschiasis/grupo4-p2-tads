import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.Heap.EmptyHeapException;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeapMax;
import static org.junit.jupiter.api.Assertions.*;

class MyHeapMaxTest {

    @Test
    void insert() {
        MyHeapMax<Integer> sut = new MyHeapMax<>(10);
        try{
            sut.insert(0);
            sut.insert(1);
            sut.insert(2);
            sut.insert(3);
            sut.insert(4);
            sut.insert(5);
            sut.insert(6);
            sut.insert(7);
            sut.insert(8);
            sut.insert(9);
        }catch (HeapOverflow e){}
        assertEquals("9 \n8 5 \n6 7 1 4 \n0 3 2 ",sut.toString());
        //Tira excepción
        Exception exception = assertThrows(HeapOverflow.class,() -> {
            sut.insert(10);
        });

    }

    @Test
    void delete() {
        MyHeapMax<Integer> sut = new MyHeapMax<>(10);
        //Tira excepción
        Exception exception = assertThrows(EmptyHeapException.class,() -> {
            sut.delete();
        });
        try{
            sut.insert(0);
            sut.insert(1);
            sut.insert(2);
            sut.insert(3);
            sut.insert(4);
            sut.insert(5);
            sut.insert(6);
            sut.insert(7);
            sut.insert(8);
            sut.insert(9);
        }catch (HeapOverflow e){}
        try{
            sut.delete();
            sut.delete();
            sut.delete();
            sut.delete();
        }catch (EmptyHeapException e){}
        assertEquals("5 \n3 4 \n0 2 1 ",sut.toString());


    }

    @Test
    void testToString() {
        MyHeapMax<Integer> sut = new MyHeapMax<>(12);
        try{
            sut.insert(0);
            sut.insert(1);
            sut.insert(2);
            sut.insert(3);
            sut.insert(4);
            sut.insert(5);
            sut.insert(6);
            sut.insert(7);
            sut.insert(8);
            sut.insert(9);
            sut.insert(10);
        }catch (HeapOverflow e){}

        assertEquals("10 \n9 5 \n6 8 1 4 \n0 3 2 7 ",sut.toString());
        try{
            sut.delete();
        }catch (EmptyHeapException e){}
        assertEquals("9 \n8 5 \n6 7 1 4 \n0 3 2 ",sut.toString());

    }

    @Test
    void size() {
        MyHeapMax<Integer> sut = new MyHeapMax<>(6);
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
        MyHeapMax<Integer> sut = new MyHeapMax<>(6);
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
}