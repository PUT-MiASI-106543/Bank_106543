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
        this.account = accounts;
        this.rate = rate;
        this.cardNumber = this.hashCode();
    }
    
    public void performOperation(Operation operation)
    {
        account.performOperation(operation, false);
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
