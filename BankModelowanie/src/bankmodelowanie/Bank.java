/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import java.util.List;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */
public class Bank {
    private Integer id;
    private List<Customer> customers;
    private List<Product> products;
    
    
    
    public Bank(){
        this.id = 213123;
    }
    
    public Customer getCustomerByPESEL(String PESEL){
        return customers.get(customers.indexOf(new Customer(null, null, PESEL)));
    }
    
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }
    
    public void addProduct(Product product){
        products.add(product);
    }
    
    public void removeProduct(Product product){
        products.remove(product);
    }
    
    public Currency conversion(Currency currency, CurrencyUnit currencyUnit, float rate, float spread){
        return new Currency(currency.getAmount() * rate * (1.0f - spread), currencyUnit);
    }
    
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
}
