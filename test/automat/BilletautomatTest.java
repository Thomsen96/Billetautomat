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
    /*
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
        
        auto.indsaetPenge(50);
        auto.udskrivBilletTyper();
        auto.udskrivBillet(0, 4);
        assertEquals(50 - (12 + ((12 * (4 - 1)) * 0.8)), auto.getBalance(), 0.0001);
        assertEquals(50 - (12 + ((12 * (4 - 1)) * 0.8)), auto.returpenge(), 0.0001);
    }
    
    @Test
    public void test_Brug2() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(100);
        auto.udskrivBilletTyper();
        auto.udskrivBillet(3, 5);
        assertEquals(100 - (8 + ((8 * (5 - 1)) * 0.8)), auto.getBalance(), 0.0001);
        assertEquals(100 - (8 + ((8 * (5 - 1)) * 0.8)), auto.returpenge(), 0.0001);
        assertEquals(0, auto.returpenge(), 0.0001);
    }
    
    @Test
    public void test_Brug3() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        auto.indsaetPenge(100);
        auto.udskrivBilletTyper();
        auto.udskrivBillet(3, 5);
        assertEquals(100 - (8 + ((8 * (5 - 1)) * 0.8)), auto.getBalance(), 0.0001);
        assertEquals(100 - (8 + ((8 * (5 - 1)) * 0.8)), auto.returpenge(), 0.0001);
        assertEquals(0, auto.returpenge(), 0.0001);
    }
    
    @Test
    public void test_tilgaaMontoerUdenTilladelse() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        assertEquals(false, auto.erMontoer());
        
        auto.montoerSetBilletpris("Voksen", 1);
        
        auto.indsaetPenge(1);
        
        auto.udskrivBillet(0, 1);
        
        assertEquals(1, auto.getBalance(), 0.0001);
    }
    
        @Test
    public void test_tilgaaMontoerMedTilladelse() {
        // Test på køb af billeter.
        Billetautomat auto = new Billetautomat();
        
        assertEquals(false, auto.erMontoer());
        auto.montoerLogin("1234");
        assertEquals(true, auto.erMontoer());
        auto.montoerSetBilletpris("Voksen", 1);
        auto.indsaetPenge(1);
        auto.udskrivBillet(0, 1);
        assertEquals(0, auto.getBalance(), 0.0001);
    }
        
}

    */