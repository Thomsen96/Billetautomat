package automat;

import org.junit.Test;
import static org.junit.Assert.*;

public class BilletautomatTest {
    
    @Test
    public void test_IndsaetPenge() {
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(-100);
        assertEquals(0, auto.getBalance(), 0.0001);
        
        auto.indsaetPenge(100);
        assertEquals(100, auto.getBalance(), 0.0001);
        
        auto.indsaetPenge(-50);
        assertEquals(100, auto.getBalance(), 0.0001);
        
        auto.indsaetPenge(0);
        auto.indsaetPenge(10);
        assertEquals(110, auto.getBalance(), 0.0001);
        
        auto.indsaetPenge(0.5);
        assertEquals(110.5, auto.getBalance(), 0.0001);
        
        auto.indsaetPenge(250.5);
        assertEquals(361, auto.getBalance(), 0.0001);
    }
    
    @Test
    public void test_pengeRetur() {
        // Det antages at indsættelse af penge er gået godt.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(0);
        assertEquals(0, auto.returpenge(), 0.0001);
        
        auto.indsaetPenge(100);
        assertEquals(100, auto.returpenge(), 0.0001);
        
        auto.indsaetPenge(10.5);
        assertEquals(10.5, auto.returpenge(), 0.0001);
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20);
        assertEquals(30, auto.returpenge(), 0.0001);
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20.24);
        assertEquals(30.24, auto.returpenge(), 0.0001);
        
        auto.indsaetPenge(-10);
        assertEquals(0, auto.returpenge(), 0.0001);      
    }
    
    @Test
    public void test_pengebalance() {
        // Det antages at indsættelse af penge er gået godt.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(0);
        assertEquals(0, auto.getBalance(), 0.0001);
        auto.returpenge();
        assertEquals(0, auto.getBalance(), 0.0001);
        
        auto.indsaetPenge(100);
        assertEquals(100, auto.getBalance(), 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(10.5);
        assertEquals(10.5, auto.getBalance(), 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20);
        assertEquals(30, auto.getBalance(), 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20.24);
        assertEquals(30.24, auto.getBalance(), 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(-10);
        assertEquals(0, auto.getBalance(), 0.0001); 
        auto.returpenge();
    }
    
    @Test
    public void test_KoebAfBillet() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(100);
        auto.udskrivBillet(0, 1);
        assertEquals(88, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(1, 1);
        assertEquals(82, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(2, 1);
        assertEquals(68, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(3, 1);
        assertEquals(60, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(4, 1);
        assertEquals(56, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(5, 1);
        assertEquals(26, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(6, 1);
        assertEquals(6, auto.getBalance(), 0.0001);
        
        assertEquals(6, auto.returpenge(), 0.0001);
    }
    
    @Test
    public void test_KoebAfZoneBillet() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(200);
        auto.udskrivBillet(0, 2);
        assertEquals(178.4, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(1, 1);
        assertEquals(172.4, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(2, 1);
        assertEquals(158.4, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(3, 1);
        assertEquals(150.4, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(4, 1);
        assertEquals(146.4, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(5, 1);
        assertEquals(116.4, auto.getBalance(), 0.0001);
        
        auto.udskrivBillet(6, 1);
        assertEquals(96.4, auto.getBalance(), 0.0001);
        
        assertEquals(96.4, auto.returpenge(), 0.0001);
        
        
    }
    @Test
    public void test_Brug1() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(20);
        
        auto.udskrivBilletTyper();
        
    }
        
}

    