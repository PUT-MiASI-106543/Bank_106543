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
    private Bank bankA, bankB;
    private Account accountA, accountB;
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
      Customer customerPrim = new Customer("Adam", "Melon", "143390321900");
      ArrayList<Customer> customerArray = new ArrayList<>();
      customerArray.add(customer);
      
      
      
      Bank bank = new Bank(123456);
      Currency curr = new Currency(1000.0f, CurrencyUnit.PLN);
      Float interests = 0.5f;
      long accNumber = 1234567890;
      
      OperationValidator validator = new DebitAccountValidator(-1000.f);
      LinearInterest state = new LinearInterest(5.f);
      this.fixture = new Account(bank, customerArray, accNumber, curr, validator,0.02f);
      this.anotherAccount =  new Account(bank, customerArray, (long)9328443, new Currency(1000.0f, CurrencyUnit.PLN), validator,0.02f);

      bankA = new Bank(123);
      bankB = new Bank(456);
      
      bankA.kir = bankA.kir.getInstance();
      bankB.kir = bankA.kir.getInstance();
      
      this.accountA = new Account(bankA, customerArray, (long)4391234, curr, validator, 0.02f);
      this.accountB = new Account(bankB, customerArray, (long)9328443, new Currency(1000.0f, CurrencyUnit.PLN), validator, 0.02f);
      
      customer.addAccount(accountA);
      customerPrim.addAccount(accountB);
      

      bankA.addCustomer(customer);
      bankB.addCustomer(customerPrim);
      

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
        Account instance = anotherAccount;
        instance.performOperation(operation, false);
        assertEquals(2000.f, this.fixture.getMoney().getAmount(), 0.01);
    }
    
     @Test
    public void testPerformOperationSender() {
        System.out.println("performOperationReceiver");
        Currency curr = new Currency(1000.0f, CurrencyUnit.PLN);

        Operation operation = new TransferOperation(curr, fixture, anotherAccount);
        Account instance = fixture;
        instance.performOperation(operation, false);
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
     *
    @Test
    public void testCalculateInterestChange() {
        System.out.println("calculateInterest");
        Account instance = this.fixture;
        LinearInterest newState = new LinearInterest(0.f);
        ChangeInterestsOperation operation = new ChangeInterestsOperation(newState);
        instance.performOperation(operation);
        instance.calculateIntrest();
        assertEquals(1000.f, instance.getMoney().getAmount(), 0.01);
    }*/

    @Test
    public void testVisitator() {
        Visitor visitor = new TextVisitor();
        Account instance = this.fixture;
      
        Currency curr = new Currency(1000.0f, CurrencyUnit.PLN);

        Operation operation = new TransferOperation(curr, anotherAccount, fixture);
        Operation operation2 = new TransferOperation(curr, fixture, anotherAccount);
        instance.performOperation(operation, false);
        instance.performOperation(operation2, false);
        
        instance.Accept(visitor);
        
        visitor = new CsvVisitor();
        instance.Accept(visitor);
        
        assertFalse(false);
    }

    @Test
    public void testDecorator() {
        IAccount acc = this.fixture;
        acc = new AccountCredit(acc, new Currency(300.0f, CurrencyUnit.PLN));
        
        Currency curr = new Currency(1200.0f, CurrencyUnit.PLN);

        Operation operation = new TransferOperation(new Currency(1000.0f, CurrencyUnit.PLN), anotherAccount, fixture);
        Operation operation2 = new TransferOperation(new Currency(1100.0f, CurrencyUnit.PLN), fixture, anotherAccount);
        
        acc.performOperation(operation2, false);
        
        assertEquals(0.f, acc.getMoney().getAmount(), 0.1f);
        
        acc.performOperation(operation, false);
        
        assertEquals(900.0f, acc.getMoney().getAmount(), 0.1f);
    }
    
    @Test
    public void testMediator()
    {
        bankA.kir.addBank(bankA);
        bankA.kir.addBank(bankB);
        Operation operation = new TransferOperation(new Currency(500.0f, CurrencyUnit.PLN), accountA, accountB);
        
        this.accountA.performOperation(operation, false);
        
        assertEquals(500.0f, this.fixture.getMoney().getAmount(), 0.1f);
        
       
        bankA.kir.sendTransfers();
        
        assertEquals(1500.0f, this.accountB.getMoney().getAmount(), 0.1f);
    }
    
    @Test
    public void testChainOfResponsibility()
    {
        Account instance = this.fixture;
        instance.getMoney().setAmount(200000.0f);
        
        Operation operation = new TransferOperation(new Currency(25000.0f, CurrencyUnit.PLN), fixture, anotherAccount);
        
        AccountChain chain = new AccountChain(instance, (TransferOperation)operation);
        
        
        assertFalse(chain.operation());
        
        Operation operation2 = new TransferOperation(new Currency(1000.0f, CurrencyUnit.PLN), fixture, anotherAccount);
        instance.performOperation(operation2, true);
        instance.performOperation(operation2, true);
        instance.performOperation(operation2, true);
        instance.performOperation(operation2, true);
        
        AccountChain chain2 = new AccountChain(instance, (TransferOperation)operation2);
        assertFalse(chain2.operation());
    }
}
