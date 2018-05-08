package automat;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class BilletautomatTest {
    
    @Test
    public void test_IndsaetPenge() throws IOException {
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
    public void test_pengeRetur() throws IOException {
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
    public void test_pengebalance() throws IOException {
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
    public void test_KoebAfBillet() throws IOException {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(100);
        auto.addtoKurv(1, "Voksen", 1, 10, 0);
        assertEquals(1, auto.udskrivBilleter());
        assertEquals(0, auto.getBalance(), 0.0001);
        
    }
    
}