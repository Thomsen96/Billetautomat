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
        assertEquals(auto.returpenge(), 0, 0.0001);
        
        auto.indsaetPenge(100);
        assertEquals(auto.returpenge(), 100, 0.0001);
        
        auto.indsaetPenge(10.5);
        assertEquals(auto.returpenge(), 10.5, 0.0001);
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20);
        assertEquals(auto.returpenge(), 30, 0.0001);
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20.24);
        assertEquals(auto.returpenge(), 30.24, 0.0001);
        
        auto.indsaetPenge(-10);
        assertEquals(auto.returpenge(), 0, 0.0001);      
    }
    
    @Test
    public void test_pengebalance() {
        // Det antages at indsættelse af penge er gået godt.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(0);
        assertEquals(auto.getBalance(), 0, 0.0001);
        auto.returpenge();
        assertEquals(auto.getBalance(), 0, 0.0001);
        
        auto.indsaetPenge(100);
        assertEquals(auto.getBalance(), 100, 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(10.5);
        assertEquals(auto.getBalance(), 10.5, 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20);
        assertEquals(auto.getBalance(), 30, 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(10);
        auto.indsaetPenge(20.24);
        assertEquals(auto.getBalance(), 30.24, 0.0001);
        auto.returpenge();
        
        auto.indsaetPenge(-10);
        assertEquals(auto.getBalance(), 0, 0.0001); 
        auto.returpenge();
    }
    
    
}

    