/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author E330
 */
public class CustomerTest {
    Customer cust;
    Account acc;
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
        cust = new Customer("Janusz", "Nowak", "93010101234");
        ArrayList<Customer> list = new ArrayList<>();
        list.add(cust);
        acc = new Account(new Bank(), list, 1234567890l, new Currency(100f, CurrencyUnit.PLN),new DebitAccountValidator(100f)); 
    }
    
    @After
    public void tearDown() {
        cust = null;
    }

    /**
     * Test of doOperation method, of class Customer.
     */
    @Test
    public void testDoOperation() { //Nie przechodzi naprawić albo sprawdzić czemu nie przechodzi.
        cust.addAccount(acc);
        
        Customer cust2 = new Customer("Grzegorz", "Kowalski", "800101012345");      
        
        ArrayList<Customer> list = new ArrayList<>();
        list.add(cust2);
        Account acc2 = new Account(new Bank(), list, 1234567891l, new Currency(100f, CurrencyUnit.PLN),new DebitAccountValidator(0f)); 
        
        Operation op = new TransferOperation(new Currency(30.0f, CurrencyUnit.PLN), acc, acc2);
        cust.doOperation(op);
        
        assertEquals(70.0f, acc.getMoney().getAmount(), 0.1);
    }

    /**
     * Test of equals method, of class Customer.
     */
    @Test
    public void testEquals() {
        Customer cust2 = new Customer("Grzegorz", "Kowalski", "800101012345");
        assertTrue(!cust.equals(cust2));
        Customer cust1 = new Customer("Janusz", "Nowak", "93010101234");
        assertTrue(cust.equals(cust));
    }
 
    /**
     * Test of addAccount method, of class Customer.
     */
    @Test
    public void testAddAccount() {  
        ArrayList<Customer> list = new ArrayList<>();
        cust.addAccount(acc);
        
        assertTrue(cust.getAccounts().contains(acc));
    }

    /**
     * Test of removeAccount method, of class Customer.
     */
    @Test
    public void testRemoveAccount() {
       
        cust.addAccount(acc);
        
        assertTrue(cust.getAccounts().contains(acc));
        
        cust.removeAccount(acc);
        
        assertTrue(!cust.getAccounts().contains(acc));  
    }

    
}
