import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.LinkedList.LinkedList;
import uy.edu.um.prog2.adt.LinkedList.ListIndexOutOfRange;
import uy.edu.um.prog2.adt.LinkedList.MyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        MyLinkedList<Integer> sut = new LinkedList<>(); // test de add para LinkedList primera posición
        try{
            sut.add(1);
            sut.add(2);
            sut.add(3);
            sut.add(4);
            assertEquals(1,sut.get(0));
            assertEquals(2,sut.get(1));
            assertEquals(3,sut.get(2));
            assertEquals(4,sut.get(3));
        }catch (ListIndexOutOfRange e){}
    }

    @Test
    void remove() {
        MyLinkedList<Integer> sut = new LinkedList<>();
        //Cuando está vacía
        Exception exception = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.remove(0);
        });
        Exception exception2 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.remove(-1);
        });
        Exception exception3 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.remove(1);
        });
        //Cuando hay uno
        sut.add(1);
        Exception exception4 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.remove(1);
        });
        Exception exception5 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.remove(-1);
        });
        try{
            sut.remove(0);
        }catch (ListIndexOutOfRange e){}
        Exception exception6 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(0);
        });
        //Cuando hay 2 y elimino primero
        sut.add(1);
        sut.add(2);
        Exception exception7 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(2);
        });
        try{
            sut.remove(0);
            assertEquals(2,sut.get(0));
        }catch (ListIndexOutOfRange e){}
        Exception exception8 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(1);
        });
        //Cuando hay 2 y elimino el último
        sut.add(3);
        try{
            sut.remove(1);
            assertEquals(2,sut.get(0));
        }catch (ListIndexOutOfRange e){}
        Exception exception9 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(1);
        });
        //Cuando hay muchos
        try{
            sut.add(3);
            sut.add(4);
            sut.add(5);
            sut.add(6);
            sut.add(7);
            sut.remove(0);
            assertEquals(3,sut.get(0));
            assertEquals(4,sut.get(1));
            assertEquals(5,sut.get(2));
            assertEquals(6,sut.get(3));
            assertEquals(7,sut.get(4));
            sut.remove(4);
            assertEquals(3,sut.get(0));
            assertEquals(4,sut.get(1));
            assertEquals(5,sut.get(2));
            assertEquals(6,sut.get(3));
            sut.remove(2);
            assertEquals(3,sut.get(0));
            assertEquals(4,sut.get(1));
            assertEquals(6,sut.get(2));
        }catch (ListIndexOutOfRange e){}






    }

    @Test
    void get() {
        MyLinkedList<Integer> sut = new LinkedList<>();
        //Cuando está vacío
        Exception exception = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(0);
        });
        Exception exception2 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(-1);
        });
        Exception exception3 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(1);
        });
        //Cuando hay 1
        sut.add(1);
        Exception exception4 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(1);
        });
        Exception exception5 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(-1);
        });
        try{
            assertEquals(1,sut.get(0));
        }catch (ListIndexOutOfRange e){}
        //Cuando hay 2
        sut.add(2);
        try{
            assertEquals(1,sut.get(0));
            assertEquals(2,sut.get(1));
        }catch (ListIndexOutOfRange e){}
        Exception exception6 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(2);
        });
        Exception exception7 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(-2);
        });
        //Cuando hay muchos
        sut.add(3);
        Exception exception8 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(3);
        });
        Exception exception9 = assertThrows(ListIndexOutOfRange.class,() -> {
            sut.get(-2);
        });
        try{
            assertEquals(1,sut.get(0));
            assertEquals(2,sut.get(1));
            assertEquals(3,sut.get(2));
        }catch (ListIndexOutOfRange e){}
    }

    @Test
    void removeValue() {
        MyLinkedList<String> sut = new LinkedList<>();
        try{
            //Cuando está vacío
            sut.removeValue("Hola");
            assertEquals(0,sut.getSize());
            //Cuando hay uno
            sut.removeValue("Mundo");
            assertEquals(0,sut.getSize());
            sut.add("Hola");
            sut.removeValue("Hola");
            //Cuando hay 2
            sut.add("Hola");
            sut.add("Mundo");
            sut.removeValue("!");
            assertEquals(2,sut.getSize());
            sut.removeValue("Mundo");
            assertEquals("Hola",sut.get(0));
            sut.add("Mundo");
            sut.removeValue("Hola");
            assertEquals("Mundo",sut.get(0));
            //Cuando hay más de 2
            sut.add("Hola");
            sut.add("!");
            sut.removeValue("3");
            assertEquals(3,sut.getSize());
            sut.removeValue("Hola");
            assertEquals("!",sut.get(1));
        }catch (ListIndexOutOfRange e){}
    }

    @Test
    void inList() {
        MyLinkedList<String> sut = new LinkedList<>();
        //Cuando está vacía
        assertFalse(sut.inList("A"));
        //Cuando hay un elemento
        sut.add("A");
        assertTrue(sut.inList("A"));
        assertFalse(sut.inList("B"));
        //Cuando hay 2 elementos
        sut.add("B");
        assertTrue(sut.inList("A"));
        assertTrue(sut.inList("B"));
        assertFalse(sut.inList("C"));
        //Cuando hay muchos elementos
        sut.add("C");
        assertTrue(sut.inList("A"));
        assertTrue(sut.inList("B"));
        assertTrue(sut.inList("C"));
        assertFalse(sut.inList("D"));

    }

    @Test
    void addFirst() {
        MyLinkedList<Integer> sut = new LinkedList<>();
        try{
            //Agregar vacío
            sut.addFirst(20);
            assertEquals(20, sut.get(0));
            //Agregar cuando hay 1
            sut.addFirst(19);
            assertEquals(19, sut.get(0));
            assertEquals(20, sut.get(1));
            //Agregar cuando hay 2
            sut.addFirst(18);
            assertEquals(18, sut.get(0));
            assertEquals(19, sut.get(1));
            assertEquals(20, sut.get(2));
            //Agregar cuando hay muchos
            sut.add(12);
            sut.add(16);
            sut.add(8);
            sut.addFirst(17);
            assertEquals(17, sut.get(0));
        }catch (ListIndexOutOfRange e){}


    }

    @Test
    void getSize() {
        MyLinkedList<String> sut = new LinkedList<>();
        try{
            //Cuando está vacío
            assertEquals(0,sut.getSize());
            //Cuando se agregan
            sut.add("a");
            assertEquals(1,sut.getSize());
            sut.add("b");
            assertEquals(2,sut.getSize());
            sut.add("c");
            assertEquals(3,sut.getSize());
            //Cuando se borra por Value
            sut.removeValue("d");
            assertEquals(3,sut.getSize());
            sut.removeValue("c");
            assertEquals(2,sut.getSize());
            sut.removeValue("b");
            assertEquals(1,sut.getSize());
            sut.removeValue("a");
            assertEquals(0,sut.getSize());
            sut.add("a");
            sut.add("b");
            sut.add("c");
            //Cuando se borra por índice
            sut.remove(2);
            assertEquals(2,sut.getSize());
            sut.remove(1);
            assertEquals(1,sut.getSize());
            sut.remove(0);
            assertEquals(0,sut.getSize());
        }catch (ListIndexOutOfRange e){}

    }

}