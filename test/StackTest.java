import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.Stack.EmptyStackException;
import uy.edu.um.prog2.adt.Stack.MyStack;
import uy.edu.um.prog2.adt.Stack.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pop() {
        MyStack<String> sut = new Stack<String>();
        Exception exception = assertThrows(EmptyStackException.class,() -> {
            sut.pop();
        });
        try{
            sut.push("1");
            sut.push("2");
            sut.push("3");
            sut.pop();
            assertEquals("2",sut.top());
            sut.pop();
            assertEquals("1",sut.top());
            sut.pop();
        }catch(EmptyStackException e){}

        Exception exception2 = assertThrows(EmptyStackException.class,() -> {
            sut.pop();
        });
    }

    @Test
    void top() {
        MyStack<String> sut = new Stack<String>();
        Exception exception = assertThrows(EmptyStackException.class,() -> {
            sut.top();
        });
        try{
            sut.push("1");
            assertEquals("1",sut.top());
            sut.push("2");
            assertEquals("2",sut.top());
            sut.push("3");
            assertEquals("3",sut.top());
        }catch(EmptyStackException e){}

    }

    @Test
    void push() {
        MyStack<String> sut = new Stack<String>();
        try{
            sut.push("1");
            assertEquals("1",sut.top());
            sut.push("2");
            assertEquals("2",sut.top());
            sut.push("3");
            assertEquals("3",sut.top());
        }catch(EmptyStackException e){}
    }

    @Test
    void isEmpty() {
        MyStack<String> sut = new Stack<String>();
        assertTrue(sut.isEmpty());
        sut.push("1");
        assertFalse(sut.isEmpty());
        try{
            sut.pop();
        }catch (EmptyStackException e){}
        assertTrue(sut.isEmpty());

    }

    @Test
    void makeEmpty() {
        MyStack<String> sut = new Stack<String>();
        sut.push("1");
        sut.push("2");
        sut.push("3");
        sut.makeEmpty();
        Exception exception = assertThrows(EmptyStackException.class,() -> {
            sut.pop();
        });
    }
}