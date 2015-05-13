package bankmodelowanie;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */
public class Bank implements IBank{
    private Integer id;
    private List<ICustomer> customers;
    private List<Product> products;
    private IKIR kir;

    @Inject
    public Bank(IKIR kir){
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.kir = kir;
    }
    
    @Override
    public void setKir(KIR kir){
        this.kir = kir;
    }
    
    @Override
    public void transferFromKir(TransferOperation top) {
        for(ICustomer c: customers)
        {
            if(c.doOperation(top, true))
                break;
        }
    }
    
    @Override
    public ICustomer getCustomerByPESEL(String pesel){
        return customers.get(customers.indexOf(new Customer(null, null, pesel)));
    }
    
    @Override
    public void addCustomer(ICustomer customer){
        customers.add(customer);
    }
    
    @Override
    public void removeCustomer(ICustomer customer){
        customers.remove(customer);
    }
    
    @Override
    public void addProduct(Product product){
        products.add(product);
    }
    
    @Override
    public void removeProduct(Product product){
        products.remove(product);
    }
    
    @Override
    public ICurrency conversion(ICurrency currency, CurrencyUnit currencyUnit, float rate, float spread){
        return BankModelowanie.getInjector().injectCurrency(currency.getAmount() * rate * (1.0f - spread), currencyUnit);
    }
    
    
    /**
     * @return the id
     */
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public IKIR getKir() {
       return this.kir;
    }


}
