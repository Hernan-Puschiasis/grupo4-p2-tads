import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.Queue.EmptyQueueException;
import uy.edu.um.prog2.adt.Queue.MyQueue;
import uy.edu.um.prog2.adt.Queue.QueueTwoPointers;

import static org.junit.jupiter.api.Assertions.*;

class QueueTwoPointersTest {

    @Test
    void enqueue() {
        MyQueue<String> sut = new QueueTwoPointers<>();
        sut.enqueue("1");
        sut.enqueue("2");
        sut.enqueue("3");
        sut.enqueue("4");
        try{
            assertEquals("1",sut.dequeue());
            assertEquals("2",sut.dequeue());
            sut.enqueue("5");
            sut.enqueue("6");
            assertEquals("3",sut.dequeue());
            assertEquals("4",sut.dequeue());
            assertEquals("5",sut.dequeue());
            assertEquals("6",sut.dequeue());
        }catch (EmptyQueueException e){}

    }

    @Test
    void dequeue() {
        MyQueue<String> sut = new QueueTwoPointers<>();
        Exception exception = assertThrows(EmptyQueueException.class,() -> {
            sut.dequeue();
        });
        sut.enqueue("1");
        sut.enqueue("2");
        sut.enqueue("3");
        sut.enqueue("4");
        try{
            assertEquals("1",sut.dequeue());
            assertEquals("2",sut.dequeue());
            sut.enqueue("5");
            sut.enqueue("6");
            assertEquals("3",sut.dequeue());
            assertEquals("4",sut.dequeue());
            assertEquals("5",sut.dequeue());
            assertEquals("6",sut.dequeue());
        }catch (EmptyQueueException e){}
        Exception exception2 = assertThrows(EmptyQueueException.class,() -> {
            sut.dequeue();
        });
    }

    @Test
    void isEmpty() {
        MyQueue<String> sut = new QueueTwoPointers<>();
        assertTrue(sut.isEmpty());
        sut.enqueue("1");
        assertFalse(sut.isEmpty());
        sut.enqueue("2");
        assertFalse(sut.isEmpty());
        sut.enqueue("3");
        assertFalse(sut.isEmpty());
        try{
            sut.dequeue();
            assertFalse(sut.isEmpty());
            sut.dequeue();
            assertFalse(sut.isEmpty());
            sut.dequeue();
            assertTrue(sut.isEmpty());
        }catch (EmptyQueueException e){}
    }

    @Test
    void getSize() {
        MyQueue<String> sut = new QueueTwoPointers<>();
        assertEquals(0,sut.getSize());
        sut.enqueue("1");
        assertEquals(1,sut.getSize());
        sut.enqueue("2");
        assertEquals(2,sut.getSize());
        sut.enqueue("3");
        assertEquals(3,sut.getSize());
        sut.enqueue("4");
        assertEquals(4,sut.getSize());
        try{
            sut.dequeue();
            assertEquals(3,sut.getSize());
            sut.dequeue();
            assertEquals(2,sut.getSize());
            sut.dequeue();
            assertEquals(1,sut.getSize());
            sut.dequeue();
            assertEquals(0,sut.getSize());
        }catch (EmptyQueueException e){}
    }
}