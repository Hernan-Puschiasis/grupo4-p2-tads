import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.LinkedList.LinkedList;
import uy.edu.um.prog2.adt.LinkedList.ListIndexOutOfRange;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() throws ListIndexOutOfRange {


        LinkedList<Integer> sut = new LinkedList<>(); // test de add para LinkedList primera posición
        sut.add(1);
        assertEquals(new Integer(1), sut.get(0));

        sut.add(null);
        assertEquals(2, sut.getSize());

//        falta agregar exception de lista vacía (que si yo estoy tratando de obtener la posición de una lista vacía me tire una excepción).
//        LinkedList<Integer> lista2 = new LinkedList<>();
//        assertNull(lista2.get(0), new LinkedList<>());
//        cuando este vacía te tire una excepción
//        cuando te tire una posicion invalida te tira una excepción.
    }

    @Test
    void remove() throws ListIndexOutOfRange {
        //        AGREGAR EXCEPTION SI HAGO UN GET DE UNA LISTA VACÍA DEBE TIRAR EXCEPCIÓN

        LinkedList<Integer> sut = new LinkedList<>();
        sut.add(1);
        sut.add(2);
        sut.remove(1);
        assertEquals(new Integer(1), sut.get(0));

    }

    @Test
    void get() throws ListIndexOutOfRange {
        LinkedList<Integer> sut = new LinkedList<>();
        sut.add(1);
        assertEquals(1, sut.get(0));
//       AGREGAR EXCEPTION LISTA VACÍA

    }

    @Test
    void removeValue() throws ListIndexOutOfRange {
        LinkedList<String> sut = new LinkedList<>();
        sut.add("Hola");
        sut.add("Mundo");
        sut.removeValue("Mundo");
        assertEquals("Hola", sut.get(0));
//      AGREGAR EXCEPTION LISTA VACÍA
    }

    @Test
    void inList() {
        LinkedList<String> sut = new LinkedList<>();
        sut.add("A");
        sut.add("B");
        sut.add("C");
        assertTrue(sut.inList("B"));

//        AGREGAR EXCEPTION LISTA VACÍA
    }

    @Test
    void addFirst() throws ListIndexOutOfRange {
        LinkedList<Integer> sut = new LinkedList<>();
        sut.add(12);
        sut.add(16);
        sut.add(8);
        sut.addFirst(20);
        assertEquals(20, sut.get(0));
    }

    @Test
    void display() {

    }

    @Test
    void getHead() {

    }

    @Test
    void setHead() {
    }

    @Test
    void getSize() {
    }

    @Test
    void setSize() {
    }
}