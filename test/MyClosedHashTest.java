import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.Hash.MyClosedHash;
import uy.edu.um.prog2.adt.Hash.MyHash;

import static org.junit.jupiter.api.Assertions.*;

class MyClosedHashTest {

    @Test
    void put() {
        MyHash<String,String> sut = new MyClosedHash<String,String>(5);
        //Agregando normal
        sut.put("1","1");
        sut.put("2","2");
        sut.put("11","11");
        sut.put("111","111");
        assertEquals("1",sut.get("1"));
        assertEquals("2",sut.get("2"));
        assertEquals("11",sut.get("11"));
        assertEquals("111",sut.get("111"));
        //Actualizando un dato
        sut.put("1","3");
        assertEquals("3",sut.get("1"));
    }

    @Test
    void get() {
        MyHash<String,String>  sut = new MyClosedHash<String,String>(5);
        //Agregando normal
        sut.put("1","1");
        sut.put("2","2");
        sut.put("11","11");
        sut.put("111","111");
        assertEquals("1",sut.get("1"));
        assertEquals("2",sut.get("2"));
        assertEquals("11",sut.get("11"));
        assertEquals("111",sut.get("111"));
        //Actualizando un dato
        sut.put("1","3");
        assertEquals("3",sut.get("1"));
        //Después de uno borrado
        sut.delete("1");
        sut.put("1","4");
        assertEquals("4",sut.get("1"));
    }

    @Test
    void delete() {
        MyHash<String,String>  sut = new MyClosedHash<String,String>(5);
        //Agregando normal
        sut.put("1","1");
        sut.put("6","6");
        sut.put("11","11");
        sut.put("15","15");
        sut.delete("1");
        assertNull(sut.get("1"));
        sut.delete("1");
        assertNull(sut.get("1"));
    }

    @Test
    void size() {
        MyHash<String,String>  sut = new MyClosedHash<String,String>(5);
        //Vacío
        assertEquals(0,sut.size());
        //Agregando normal
        sut.put("1","3");
        sut.put("2","2");
        assertEquals(2,sut.size());
        //Modificando uno ya existente
        sut.put("1","1");
        assertEquals(2,sut.size());
        //Eliminando uno que no existe
        sut.delete("3");
        assertEquals(2,sut.size());
        //Eliminando uno existente
        sut.delete("2");
        assertEquals(1,sut.size());
        //Eliminando uno que existía
        sut.delete("2");
        assertEquals(1,sut.size());
    }

    @Test
    void resize() {
        MyHash<String,String>  sut = new MyClosedHash<String,String>(5);
        sut.put("1","1");
        sut.put("2","2");
        sut.put("3","3");
        sut.put("4","4");
        sut.put("5","5");
        sut.put("6","6");
        sut.put("7","7");
        assertEquals(7,sut.size());
        assertEquals("7",sut.get("7"));
        assertEquals("6",sut.get("6"));
        assertEquals("5",sut.get("5"));
        assertEquals("4",sut.get("4"));
        assertEquals("3",sut.get("3"));
        assertEquals("2",sut.get("2"));
        assertEquals("1",sut.get("1"));

    }

    @Test
    void inHash(){
        MyHash<String,String>  sut = new MyClosedHash<String,String>(5);
        assertFalse(sut.inHash("1"));
        sut.put("1","3");
        assertFalse(sut.inHash("2"));
        assertTrue(sut.inHash("1"));
        sut.put("2","2");
        assertTrue(sut.inHash("2"));
        assertTrue(sut.inHash("1"));
        assertFalse(sut.inHash("3"));
        sut.delete("2");
        assertFalse(sut.inHash("2"));
    }
}