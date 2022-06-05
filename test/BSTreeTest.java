import uy.edu.um.prog2.adt.BSTree.BSTree;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {

    @org.junit.jupiter.api.Test
    void find() {
        BSTree<Integer,String> sut = new BSTree<Integer, String>();
        //Checkeo cuando está vacío
        assertNull(sut.find(1));

        //Checkeo común
        sut.insert(3,"a3");
        sut.insert(5,"a5");
        sut.insert(4,"a4");
        sut.insert(2,"a2");
        sut.insert(1,"a1");
        assertEquals("a5",sut.find(5));
        assertEquals("a4",sut.find(4));
        assertEquals("a3",sut.find(3));
        assertEquals("a2",sut.find(2));
        assertEquals("a1",sut.find(1));

        //Cuando la key no existe
        assertNull(sut.find(7));
        assertNull(sut.find(0));
    }

    @org.junit.jupiter.api.Test
    void insert() {
        BSTree<Integer,String> sut = new BSTree<Integer, String>();
        //Checkeo común
        sut.insert(3,"a3");
        sut.insert(5,"a5");
        sut.insert(4,"a4");
        sut.insert(2,"a2");
        sut.insert(1,"a1");
        assertEquals("a5",sut.find(5));
        assertEquals("a4",sut.find(4));
        assertEquals("a3",sut.find(3));
        assertEquals("a2",sut.find(2));
        assertEquals("a1",sut.find(1));

    }

    @org.junit.jupiter.api.Test
    void delete() {
        BSTree<Integer,String> sut = new BSTree<Integer, String>();
        //Borrar solo root
        sut.insert(3,"a3");
        sut.delete(3);
        assertNull(sut.find(3));
        //Borrar root con elemento derecha
        sut.insert(3,"a3");
        sut.insert(5,"a5");
        sut.delete(3);
        assertNull(sut.find(3));
        assertEquals("a5",sut.find(5));
        //Borrar root con elemento izquierda
        sut.insert(3,"a3");
        sut.delete(5);
        assertNull(sut.find(5));
        assertEquals("a3",sut.find(3));
        //Borrar root con dos elementos
        sut.insert(5,"a5");
        sut.insert(2,"a2");
        sut.delete(3);
        assertNull(sut.find(3));
        assertEquals("a2",sut.find(2));
        assertEquals("a5",sut.find(5));
        //Borrar hoja izquierda y derecha
        sut.insert(6,"a6");
        sut.delete(6);
        sut.delete(2);
        assertNull(sut.find(2));
        assertNull(sut.find(6));
        assertEquals("a5",sut.find(5));
        //Borrar nodo con un hijo
        sut.insert(6,"a6");
        sut.insert(2,"a2");
        sut.insert(3,"a3");
        sut.insert(7,"a7");
        sut.delete(6);
        sut.delete(2);
        assertNull(sut.find(6));
        assertNull(sut.find(2));
        assertEquals("a5",sut.find(5));
        assertEquals("a3",sut.find(3));
        assertEquals("a7",sut.find(7));
        sut.insert(1,"a1");
        sut.delete(3);
        assertNull(sut.find(3));
        assertEquals("a1",sut.find(1));
        //Borrar nodo con 2 hijos
        sut.insert(0,"a0");
        sut.insert(3,"a3");
        sut.insert(2,"a2");
        sut.insert(4,"a4");
        sut.insert(6,"a6");
        sut.insert(8,"a8");
        sut.delete(1);
        sut.delete(7);
        assertNull(sut.find(1));
        assertNull(sut.find(7));
        assertEquals("a0",sut.find(0));
        assertEquals("a3",sut.find(3));
        assertEquals("a2",sut.find(2));
        assertEquals("a4",sut.find(4));
        assertEquals("a5",sut.find(5));
        assertEquals("a6",sut.find(6));
        assertEquals("a8",sut.find(8));
        //Borrar root con 2 hijos y más niveles
        sut.delete(5);
        assertEquals("a0",sut.find(0));
        assertEquals("a3",sut.find(3));
        assertEquals("a2",sut.find(2));
        assertEquals("a4",sut.find(4));
        assertEquals("a6",sut.find(6));
        assertEquals("a8",sut.find(8));
        assertNull(sut.find(5));
    }

    @org.junit.jupiter.api.Test
    void size() {
        BSTree<Integer,String> sut = new BSTree<Integer, String>();
        //Checkeo vacío
        assertEquals(0,sut.size());

        //Checkeo agregando
        sut.insert(3,"a3");
        assertEquals(1,sut.size());
        sut.insert(5,"a5");
        sut.insert(4,"a4");
        sut.insert(2,"a2");
        sut.insert(1,"a1");
        sut.insert(-1,"a-1");
        sut.insert(0,"a0");
        assertEquals(7,sut.size());

        //Checkeo borrando
        sut.delete(0);
        assertEquals(6,sut.size());
        sut.delete(1);
        assertEquals(5,sut.size());
        sut.delete(3);
        assertEquals(4,sut.size());

    }

    @org.junit.jupiter.api.Test
    void countLeaf() {
    }

    @org.junit.jupiter.api.Test
    void countCompleteElements() {
    }

    @org.junit.jupiter.api.Test
    void preOrder() {
    }

    @org.junit.jupiter.api.Test
    void postOrder() {
    }

    @org.junit.jupiter.api.Test
    void inOrder() {
    }

    @org.junit.jupiter.api.Test
    void recorrerPorNivel() {
    }
}