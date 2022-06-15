import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.ArrayList.ArrayList;
import uy.edu.um.prog2.adt.ArrayList.IndexOutOfRangeException;
import uy.edu.um.prog2.adt.ArrayList.MyArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    @Test
    void add() {
        MyArrayList<String> sut = new ArrayList<>(5);
        sut.add("a");
        sut.add("b");
        sut.add("c");
        sut.add("d");
        sut.add("e");
        sut.add("f");
        sut.add("g");
        assertEquals("a",sut.get(0));
        assertEquals("b",sut.get(1));
        assertEquals("c",sut.get(2));
        assertEquals("d",sut.get(3));
        assertEquals("e",sut.get(4));
        assertEquals("f",sut.get(5));
        assertEquals("g",sut.get(6));

    }

    @Test
    void get() {
        MyArrayList<String> sut = new ArrayList<>(5);
        sut.add("a");
        sut.add("b");
        sut.add("c");
        sut.add("d");
        sut.add("e");
        sut.add("f");
        sut.add("g");
        assertEquals("a",sut.get(0));
        assertEquals("b",sut.get(1));
        assertEquals("c",sut.get(2));
        assertEquals("d",sut.get(3));
        assertEquals("e",sut.get(4));
        assertEquals("f",sut.get(5));
        assertEquals("g",sut.get(6));
        Exception exception = assertThrows(IndexOutOfRangeException.class,() -> {
            sut.get(-1);
        });
        Exception exception2 = assertThrows(IndexOutOfRangeException.class,() -> {
            sut.get(7);
        });
    }

    @Test
    void size() {
        MyArrayList<String> sut = new ArrayList<>(5);
        assertEquals(0,sut.size());
        sut.add("a");
        assertEquals(1,sut.size());
        sut.add("b");
        assertEquals(2,sut.size());
        sut.add("c");
        assertEquals(3,sut.size());
        sut.add("d");
        assertEquals(4,sut.size());
        sut.add("e");
        assertEquals(5,sut.size());
        sut.add("f");
        assertEquals(6,sut.size());
        sut.add("g");
        assertEquals(7,sut.size());
    }
}