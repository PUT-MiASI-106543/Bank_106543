/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public IKir kir;
    
    
    /*public Bank(int id){
        this.id = id;
        customers = new ArrayList<ICustomer>();
        products = new ArrayList<Product>();
        kir = new KIR();
    }*/
    
    @Inject
    public Bank(IKir kir){
        this.customers = new ArrayList<ICustomer>();
        this.products = new ArrayList<Product>();
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
    public ICustomer getCustomerByPESEL(String PESEL){
        return customers.get(customers.indexOf(new Customer(null, null, PESEL)));
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
    
    /*@Override
    public ICurrency conversion(ICurrency currency, CurrencyUnit currencyUnit, float rate, float spread){
        return new Currency(currency.getAmount() * rate * (1.0f - spread), currencyUnit);
    }*/
    
    @Override
    public ICurrency conversion(ICurrency currency, CurrencyUnit currencyUnit, float rate, float spread){
        return BankModelowanie.dInjector.InjectCurrency(currency.getAmount() * rate * (1.0f - spread), currencyUnit);
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


}
