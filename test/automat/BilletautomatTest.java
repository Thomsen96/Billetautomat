/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas
 */
public class BilletautomatTest {
    
    public BilletautomatTest() {
    }
    
    
    /**
     * Test of getBilletpris method, of class Billetautomat.
     */
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
        instance.indsætPenge(0.5);
        instance.indsætPenge(250.5);
       
        assertEquals((100 + 0 + 10+ 0.5+ 250.5), instance.getBalance(), 0.0001);
    }
}

    