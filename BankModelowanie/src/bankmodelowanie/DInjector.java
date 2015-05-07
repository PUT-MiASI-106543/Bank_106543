/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.ArrayList;

/**
 *
 * @author MeloneQ
 */
public class DInjector {
    
    public Injector injector;
    
    public DInjector(){
        injector = Guice.createInjector(new DependencyInjector());
    }
    
    public ICustomer InjectCustomer(String name, String surname, String PESEL){
        ICustomer customer = injector.getInstance(ICustomer.class);
        
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPESEL(PESEL);
        
        return customer;
    }
    
    public IAccount InjectAccount(ArrayList<ICustomer> customers, Long accNumber){
        IAccount account = injector.getInstance(IAccount.class);
        
        account.setMoney(InjectCurrency(0f, CurrencyUnit.PLN));
        account.setState(new LinearInterest(5.00f));
        account.setCustomer(customers);
        account.setAccNumber(accNumber);
        
        return account;
    }
    
    public IAccount InjectAccount(IBank bank, ArrayList<ICustomer> customer, Long accNumber, ICurrency money, OperationValidator validator){
        IAccount account = injector.getInstance(IAccount.class);
        
        account.setBank(bank);
        account.setCustomer(customer);
        account.setMoney(money);
        account.setOperationValidator(validator);
        account.setState(new LinearInterest(5.00f));
        
        return account;
    }
    
    public IAccount InjectAccount(IBank bank, ArrayList<ICustomer> customer, Long accNumber, ICurrency money, OperationValidator validator, InterestState state){
        IAccount account = injector.getInstance(IAccount.class);
        
        account.setBank(bank);
        account.setCustomer(customer);
        account.setMoney(money);
        account.setOperationValidator(validator);
        account.setState(state);
        
        return account;
    }
    
    public IBank InjectBank(int id){
        IBank bank = injector.getInstance(IBank.class);
        bank.setId(id);
        return bank;
    }
    
    public ICurrency InjectCurrency(Float ammount, CurrencyUnit curr){
        ICurrency currency = injector.getInstance(ICurrency.class);
        
        currency.setAmount(ammount);
        currency.setCurrency(curr);
        
        return currency;
    }
    
}
