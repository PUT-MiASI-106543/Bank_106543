package bankmodelowanie;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.List;

/**
 *
 * @author MeloneQ
 */
public class DInjector {
    
    private Injector injector;
    
    public DInjector(){
        injector = Guice.createInjector(new DependencyInjector());
    }
    
    public ICustomer injectCustomer(String name, String surname, String pesel){
        ICustomer customer = injector.getInstance(ICustomer.class);
        
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPESEL(pesel);
        
        return customer;
    }
    
    public IAccount injectAccount(List<ICustomer> customers, Long accNumber, OperationValidator validator){
        IAccount account = injector.getInstance(IAccount.class);
        IBank bank = this.injectBank(123);
        
        account.setBank(bank);
        account.setMoney(injectCurrency(1000f, CurrencyUnit.PLN));
        account.setState(new LinearInterest(5.00f));
        account.setCustomer(customers);
        account.setAccNumber(accNumber);
        account.setOperationValidator(validator);
        
        return account;
    }
    
    public IAccount injectAccount(IBank bank, List<ICustomer> customer, Long accNumber, ICurrency money, OperationValidator validator){
        IAccount account = injector.getInstance(IAccount.class);
        
        account.setBank(bank);
        account.setCustomer(customer);
        account.setMoney(money);
        account.setOperationValidator(validator);
        account.setState(new LinearInterest(5.00f));
        account.setAccNumber(accNumber);
        
        return account;
    }
    
    public IAccount injectAccount(IBank bank, List<ICustomer> customer, Long accNumber, ICurrency money, OperationValidator validator, InterestState state){
        IAccount account = injector.getInstance(IAccount.class);
        
        account.setBank(bank);
        account.setCustomer(customer);
        account.setMoney(money);
        account.setOperationValidator(validator);
        account.setState(state);
        account.setAccNumber(accNumber);
        
        return account;
    }
    
    public IBank injectBank(int id){
        IBank bank = injector.getInstance(IBank.class);
        bank.setId(id);
        bank.setKir(KIR.getInstance());
        return bank;
    }
    
    
    public ICurrency injectCurrency(Float amount, CurrencyUnit currency){
        return new Currency(amount, currency);
    }
}
