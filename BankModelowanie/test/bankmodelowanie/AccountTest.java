/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam.kedzia
 */
public class AccountTest {
    private Account fixture;
    private Account anotherAccount;
    
    public AccountTest() {
      
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      Customer customer = new Customer("Adam", "Kedzia", "109090321900");
      ArrayList<Customer> customerArray = new ArrayList<>();
      customerArray.add(customer);
      
      Bank bank = new Bank();
      Currency curr = new Currency(1000.0f, CurrencyUnit.PLN);
      Float interests = 0.5f;
      long accNumber = 1234567890;
      
      OperationValidator validator = new DebitAccountValidator(-1000.f);
      LinearInterest state = new LinearInterest(5.f);
      this.fixture = new Account(bank, customerArray, accNumber, curr, validator,0.02f);
      this.anotherAccount =  new Account(bank, customerArray, (long)9328443, curr, validator,0.02f);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of performOperation method, of class Account.
     */
    @Test
    public void testPerformOperationReceiver() {
        System.out.println("performOperationReceiver");
        Currency curr = new Currency(1000.0f, CurrencyUnit.PLN);

        Operation operation = new TransferOperation(curr, anotherAccount, fixture);
        Account instance = fixture;
        instance.performOperation(operation);
        assertEquals(2000.f, instance.getMoney().getAmount(), 0.01);
    }
    
     @Test
    public void testPerformOperationSender() {
        System.out.println("performOperationReceiver");
        Currency curr = new Currency(1000.0f, CurrencyUnit.PLN);

        Operation operation = new TransferOperation(curr, fixture, anotherAccount);
        Account instance = fixture;
        instance.performOperation(operation);
        assertEquals(0.f, instance.getMoney().getAmount(), 0.01);
    }

    /**
     * Test of evaluateInterest method, of class Account.
     */
    @Test
    public void testEvaluateInterest() {
        System.out.println("evaluateInterest");
        Account instance = this.fixture;
        instance.evaluateInterest();
        assertEquals(1020.f, instance.getMoney().getAmount(), 0.01);
    }

    /**
     * Test of equals method, of class Account.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object ob = anotherAccount;
        Account instance = fixture;
        boolean expResult = false;
        boolean result = instance.equals(ob);
        assertEquals(expResult, result);
        
        result = instance.equals(instance);
        assertEquals(result, true);
    }

     /**
     * Test of calculateInterest method, of class Account.
     */
    @Test
    public void testCalculateInterest() {
        System.out.println("calculateInterest");
        Account instance = this.fixture;
        instance.calculateIntrest();
        assertEquals(1050.f, instance.getMoney().getAmount(), 0.01);
    }
    
     /**
     * Test of calculateInterest method, of class Account.
     */
    @Test
    public void testCalculateInterestChange() {
        System.out.println("calculateInterest");
        Account instance = this.fixture;
        LinearInterest newState = new LinearInterest(0.f);
        ChangeInterestsOperation operation = new ChangeInterestsOperation(newState);
        instance.performOperation(operation);
        instance.calculateIntrest();
        assertEquals(1000.f, instance.getMoney().getAmount(), 0.01);
    }




  







  


    
}
