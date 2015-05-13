package bankmodelowanie;

/**
 * @author adam.pacanowski
 * @author adam.kedzia
 */


public class Currency implements ICurrency{
    private Float amount;
    private CurrencyUnit currencyUnit;

    public Currency(Float amount, CurrencyUnit currencyUnit){
        this.amount = amount;
        this.currencyUnit = currencyUnit;
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
        return currencyUnit;
    }

    /**
     * @param currency the currency to set
     */
    @Override
    public void setCurrency(CurrencyUnit currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    

}
