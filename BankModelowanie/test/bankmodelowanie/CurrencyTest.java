/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author E330
 */
public class CurrencyTest {
    Currency curr;
    public CurrencyTest() {
    }
    
    @Before
    public void setUp() {
        curr = new Currency(20.0f, CurrencyUnit.PLN);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCurrency(){
        assertEquals(20.0, curr.getAmount(), 0.1);
        assertEquals(CurrencyUnit.PLN, curr.getCurrency());
    }

   
    
}
