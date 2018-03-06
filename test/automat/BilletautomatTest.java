package automat;

import org.junit.Test;
import static org.junit.Assert.*;

public class BilletautomatTest {
    
    @Test
    public void test_IndsætPenge() {
        Billetautomat instance = new Billetautomat();
        
        instance.indsætPenge(-100);
        assertEquals(0, instance.getBalance(), 0.0001);
        
        instance.indsætPenge(100);
        assertEquals(100, instance.getBalance(), 0.0001);
        
        instance.indsætPenge(-50);
        assertEquals(100, instance.getBalance(), 0.0001);
        
        instance.indsætPenge(0);
        instance.indsætPenge(10);
        assertEquals(110, instance.getBalance(), 0.0001);
        
        instance.indsætPenge(0.5);
        assertEquals(110.5, instance.getBalance(), 0.0001);
        
        
        instance.indsætPenge(250.5);
        assertEquals(361, instance.getBalance(), 0.0001);
    }
    
    @Test
    public void test_pengeRetur() {
        
    }
    
    
}

    