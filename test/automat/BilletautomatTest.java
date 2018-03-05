/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas
 */
public class BilletautomatTest {
    
    public BilletautomatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBilletpris method, of class Billetautomat.
     */
    @Test
    public void testGetBilletpris() {
        System.out.println("getBilletpris");
        String inType = "";
        int zoner = 0;
        Billetautomat instance = new Billetautomat();
        double expResult = 0.0;
        double result = instance.getBilletpris(inType, zoner);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indsætPenge method, of class Billetautomat.
     */
    @Test
    public void testIndsætPenge() {
        System.out.println("inds\u00e6tPenge");
        int beløb = 0;
        Billetautomat instance = new Billetautomat();
        instance.indsætPenge(beløb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class Billetautomat.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Billetautomat instance = new Billetautomat();
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of udskrivBillet method, of class Billetautomat.
     */
    @Test
    public void testUdskrivBillet() {
        System.out.println("udskrivBillet");
        int inType = 0;
        int zoner = 0;
        Billetautomat instance = new Billetautomat();
        instance.udskrivBillet(inType, zoner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
    }

    /**
     * Test of returpenge method, of class Billetautomat.
     */
    @Test
    public void testReturpenge() {
        System.out.println("returpenge");
        Billetautomat instance = new Billetautomat();
        double expResult = 0.0;
        double result = instance.returpenge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montørLogin method, of class Billetautomat.
     */
    @Test
    public void testMontørLogin() {
        System.out.println("mont\u00f8rLogin");
        String adgangskode = "";
        Billetautomat instance = new Billetautomat();
        instance.montørLogin(adgangskode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Billetautomat.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Billetautomat instance = new Billetautomat();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAntalBilletterSolgt method, of class Billetautomat.
     */
    @Test
    public void testGetAntalBilletterSolgt() {
        System.out.println("getAntalBilletterSolgt");
        Billetautomat instance = new Billetautomat();
        int expResult = 0;
        int result = instance.getAntalBilletterSolgt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBilletpris method, of class Billetautomat.
     */
    @Test
    public void testSetBilletpris() {
        System.out.println("setBilletpris");
        String inType = "";
        double inPris = 0.0;
        Billetautomat instance = new Billetautomat();
        instance.setBilletpris(inType, inPris);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nulstil method, of class Billetautomat.
     */
    @Test
    public void testNulstil() {
        System.out.println("nulstil");
        Billetautomat instance = new Billetautomat();
        instance.nulstil();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montørLog method, of class Billetautomat.
     */
    @Test
    public void testMontørLog() {
        System.out.println("mont\u00f8rLog");
        Billetautomat instance = new Billetautomat();
        instance.montørLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montørFindUUID method, of class Billetautomat.
     */
    @Test
    public void testMontørFindUUID() {
        System.out.println("mont\u00f8rFindUUID");
        String søg = "";
        Billetautomat instance = new Billetautomat();
        instance.montørFindUUID(søg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montørFindTilbageBetalinger method, of class Billetautomat.
     */
    @Test
    public void testMontørFindTilbageBetalinger() {
        System.out.println("mont\u00f8rFindTilbageBetalinger");
        double over = 0.0;
        String underOver = "";
        Billetautomat instance = new Billetautomat();
        instance.montørFindTilbageBetalinger(over, underOver);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montørFindIndsattePenge method, of class Billetautomat.
     */
    @Test
    public void testMontørFindIndsattePenge() {
        System.out.println("mont\u00f8rFindIndsattePenge");
        double over = 0.0;
        String underOver = "";
        Billetautomat instance = new Billetautomat();
        instance.montørFindIndsattePenge(over, underOver);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of erMontør method, of class Billetautomat.
     */
    @Test
    public void testErMontør() {
        System.out.println("erMont\u00f8r");
        Billetautomat instance = new Billetautomat();
        boolean expResult = false;
        boolean result = instance.erMontør();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of udskrivBilletTyper method, of class Billetautomat.
     */
    @Test
    public void testUdskrivBilletTyper() {
        System.out.println("udskrivBilletTyper");
        Billetautomat instance = new Billetautomat();
        instance.udskrivBilletTyper();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of søgBilletTyper method, of class Billetautomat.
     */
    @Test
    public void testSøgBilletTyper() {
        System.out.println("s\u00f8gBilletTyper");
        String søgType = "";
        Billetautomat instance = new Billetautomat();
        int expResult = 0;
        int result = instance.søgBilletTyper(søgType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
