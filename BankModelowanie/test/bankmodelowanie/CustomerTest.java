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
    ICustomer cust;
    IAccount acc;
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
        BankModelowanie.main(new String[]{});
        cust = BankModelowanie.getInjector().injectCustomer("Test", "Testowy", "123123123123");
        ArrayList<ICustomer> list = new ArrayList<>();
        list.add(cust);
        acc = BankModelowanie.getInjector().injectAccount(new Bank(new KIR()), list, 1234567890l, new Currency(100f, CurrencyUnit.PLN),new DebitAccountValidator(100f));
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
        
        ArrayList<ICustomer> list = new ArrayList<>();
        list.add(cust2);
        IAccount acc2 = BankModelowanie.getInjector().injectAccount(BankModelowanie.getInjector().injectBank(1), list, Long.MIN_VALUE,new Currency(100f, CurrencyUnit.PLN),new DebitAccountValidator(100f));
        
        Operation op = new TransferOperation(new Currency(30.0f, CurrencyUnit.PLN), acc, acc2);
        cust.doOperation(op, true);
        
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
