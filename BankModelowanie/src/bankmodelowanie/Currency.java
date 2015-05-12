package bankmodelowanie;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */


public class Currency implements ICurrency{
    private Float amount;
    private CurrencyUnit currency;

    public Currency(Float amount, CurrencyUnit currency){
        this.amount = amount;
        this.currency = currency;
    }
    
    /**
     * @return the amount
     */
    @Override
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    @Override
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @return the currency
     */
    @Override
    public CurrencyUnit getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    @Override
    public void setCurrency(CurrencyUnit currency) {
        this.currency = currency;
    }

    

}
