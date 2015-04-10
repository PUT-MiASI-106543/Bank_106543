/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 *
 * @author MeloneQ
 */
public class CreditCard {
    private Customer customer;
    private Account account;
    private int cardNumber;
    private double rate;
    
    public CreditCard(Customer customer, Account accounts, double rate)
    {
        this.customer = customer;
        this.account = account;
        this.rate = rate;
        this.cardNumber = this.hashCode();
    }
    
    public void performOperation(Operation operation)
    {
        account.performOperation(operation);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Account getAccount() {
        return account;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    
}
