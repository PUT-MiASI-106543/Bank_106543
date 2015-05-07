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
public class OperationsHistoryTest {
    
    private OperationsHistory fixture;
    
    public OperationsHistoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        BankModelowanie.main();
        this.fixture = new OperationsHistory();

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOperation method, of class OperationsHistory.
     */
    @Test
    public void testAddOperation() {
        System.out.println("addOperation");
        
      ICustomer customer = BankModelowanie.dInjector.InjectCustomer("Adam", "Kedzia", "109090321900");
      ArrayList<ICustomer> customerArray = new ArrayList<>();
      customerArray.add(customer);
      
      IBank bank = BankModelowanie.dInjector.InjectBank(123);
      ICurrency curr = new Currency(1000.0f, CurrencyUnit.PLN);
      ICurrency curr2 = new Currency(1000.0f, CurrencyUnit.PLN);

      Float interests = 0.5f;
      long accNumber = 1234567890;
      
      OperationValidator validator = new DebitAccountValidator(-1000.f);
      
      IAccount acc = BankModelowanie.dInjector.InjectAccount(bank, customerArray, accNumber, curr, validator);

        Operation operation1 = new TransferOperation(curr, acc, acc);
        Operation operation2 = new TransferOperation(curr2, acc, acc);
        OperationsHistory instance = fixture;
        instance.addOperation(operation1);
        instance.addOperation(operation2);

        assertEquals(operation1, fixture.getHistory().get(0));
        assertEquals(operation2, fixture.getHistory().get(1));

    }
    
}
